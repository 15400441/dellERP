<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Dell DIY your PC</title>
<meta name="description" content="Dell: Select the components you like to assemble your PC">
<meta name="keywords" content="Dell PC Assemble">
<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/assets/css/login-register.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<%@ include file="popLogin.jsp"%>
	<div class="well well-lg">
		<h1>
			 Wellcome to our DELLERP system <small>Pick whatever you want </small>
		</h1>
	</div>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">All product</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">New <span class="sr-only">(current)</span> </a>
					</li>
					<li id="login"><a data-toggle="modal" href="javascript:void(0)" onclick="openLoginModal();">Log in</a></li>
					<li id="regist"><a data-toggle="modal" href="javascript:void(0)" onclick="openRegisterModal();">Register</a>
					</li>
					<li class="hidden" id="home"><a id="goHome" data-toggle="modal" href="${pageContext.request.contextPath}/sOrder/getOrderListByCustomerUuid.do" >Home of <span id="customerUsername">${customer.userName}</span></a>
					</li>
					<li class="hidden" id="logout"><a id="goHome" data-toggle="modal" href="${pageContext.request.contextPath}/customer/logout.do" >Logout</a>
					</li>
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<h3>
		<font color="blue">Plese choose components</font>
	</h3>
	<div class="row">
		<div class="col-md-12">
			<div class="btn-group btn-group-justified" role="group" aria-label="...">
				<c:forEach items="${componentsTypeList}" var="ct">
					<div class="btn-group" role="group">
						<button onclick="findComponents(${ct.uuid})" type="button" class="btn btn-default">${ct.name}</button>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	</br>
	<div class="row">
		<div class="col-md-5">
			<div class="panel panel-default" class="col-md-12">
				<div class="panel-heading">
					Shopping list <a href="#" class="col-md-offset-7">Clean</a>
				</div>
				<div class="panel-body">
					<div class="col-md-12">
					<form action="${pageContext.request.contextPath}/sOrder/generateOrder.do" method="post">
						<table class="table">
							<thead>
								<tr>
									<th>Component</th>
									<th>Name</th>
									<th>Number</th>
									<th>Operation</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${componentsTypeList}" var="ct">
									<tr>
										<td>${ct.name }</td>
										<td id="${ct.uuid }"></td>
										<td><input name="num" type="text" value="0" class="form-control" style="width:60px;">
										    <input name="uuid" type="hidden"  class="form-control" id="${ct.uuid }para" >										
										</td>
										<td><a href="#"><span class="glyphicon glyphicon-remove"></span>
										</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="col-md-12">
							<button type="submit" class="btn btn-info" class="col-md-offset-1">Submit Order</button>
						</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-7">
			<div class="panel panel-default" class="col-md-12">
				<div class="panel-heading">Product list</div>
				<div class="panel-body">
					<table id="showComponents" class="table" >
						<thead>
							<tr>
								<th data-field="uuid" data-formatter="imgFormatter">Picture</th>
								<th data-field="name" data-formatter="nameFormatter"> Name</th>
								<th data-field="outPrice" > Price</th>
								<th data-field="uuid"  data-formatter="buttonFormatter"> </th>
							
							</tr>
						</thead>
						
					</table>
					
				</div>
			</div>
		</div>
	</div>
	<div class="hidden" id="msg">${info }</div>
	<div class="well">
		<div class="panel-head">
			<li><a href="#">Contact Us</a> <a href="#" class="col-md-offset-1">Feedback</a> <a href="#" class="col-md-offset-1">Others</a></li> Design by XXX 2016@CopyRight
		</div>
	</div>
</body>
<script src="${pageContext.request.contextPath}/assets/js/jquery.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/login-register.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap-table.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/customerMain.js"></script>
</html>