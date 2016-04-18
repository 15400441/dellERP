<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Dell Admin</title>
<!-- Bootstrap Core CSS -->
<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/assets/css/sb-admin.css" rel="stylesheet">
<!-- Morris Charts CSS -->
<link href="${pageContext.request.contextPath}/assets/css/plugins/morris.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="wrapper">
		<%@ include file="navForAssemblyEmp.jsp"%>
		<div id="page-wrapper">
			<div class="container-fluid">
				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							Dashboard <small>Statistics Overview</small>
						</h1>
						<ol class="breadcrumb">
							<li class="active"><i class="fa fa-dashboard"></i> Dashboard</li>
						</ol>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
						<div class="panel panel-yellow">
							<div class="panel-heading">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa fa-shopping-cart fa-5x"></i>
									</div>
									<div class="col-xs-9 text-right">
										<div class="huge" id="orderNeedAssemblyCount"></div>
										<div>Orders need Assemble !</div>
									</div>
								</div>
							</div>
							<a href="${pageContext.request.contextPath}/sOrder/orderList.do?status=1&empUuid=${loginEmp.uuid}">
								<div class="panel-footer">
									<span class="pull-left">View Details</span> <span class="pull-right"><i class="fa fa-arrow-circle-right"></i>
									</span>
									<div class="clearfix"></div>
								</div> </a>
						</div>
					</div>
				<div class="row">
					<div class="col-lg-4 col-md-6">
						<div class="panel panel-green">
							<div class="panel-heading">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa fa-shopping-cart fa-5x"></i>
									</div>
									<div class="col-xs-9 text-right">
										<div class="huge" id="deliverOrderCount"></div>
										<div>Delivering Orders!</div>
									</div>
								</div>
							</div>
							<a  onclik="changeClass()" href="${pageContext.request.contextPath}/sOrder/orderList.do?status=2&empUuid=${loginEmp.uuid}">
								<div class="panel-footer">
									<span class="pull-left">View Details</span> <span class="pull-right"><i class="fa fa-arrow-circle-right"></i>
									</span>
									<div class="clearfix"></div>
								</div> </a>
						</div>
					</div>
					
				</div>
				<!-- /.row -->
				
				<div id="showControl1" class="show">
				<div class="row">
					<div class="col-lg-10">
						<h2>Orders need Assemble</h2>
						<div class="table-responsive">
							<table class="table table-bordered table-hover table-striped">
								<thead>
									<tr>
										<th>Order num</th>
										<th>Start Time</th>
										<th>Total price</th>
										<th>Components needed</th>
										<th>Description</th>
										<th>Status</th>
										<th>Finish task</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${page.records}" var="o">
										<tr>
											<td>${o.orderNum }</td>
											<td>${o.startTime }</td>
											<td>${o.totalPrice }</td>
											<td><a href="${pageContext.request.contextPath}/sOrder/getDetail?uuid=${o.uuid}">Detail</a>
											</td>
											<td>${o.des }</td>
											<td>${o.statusView }</td>
											<td><a href="${pageContext.request.contextPath}/emp/changeSorderStatus?uuid=${o.uuid}&status=2">finish</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				</div>
				<!-- /.row -->
				
				<div id="showControl2" class="hidden">
				<div class="row">
					<div class="col-lg-10">
						<h2>finished assembley orders</h2>
						<div class="table-responsive">
							<table class="table table-bordered table-hover table-striped">
								<thead>
									<tr>
										<th>Order num</th>
										<th>Start Time</th>
										<th>Total price</th>
										<th>Components needed</th>
										<th>Description</th>
										<th>status</th>
										
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${page.records}" var="o">
										<tr>
											<td>${o.orderNum }</td>
											<td>${o.startTime }</td>
											<td>${o.totalPrice }</td>
											<td><a href="${pageContext.request.contextPath}/sOrder/getDetail?uuid=${o.uuid}">Detail</a>
											</td>
											<td>${o.des }</td>
											<td>${o.statusView }</td>										
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				</div>
				<!-- /.row -->
				
				<form action="${pageContext.request.contextPath}/sOrder/orderList.do" id="searchForm">
					<input name="status" type="hidden" value="1"> <input name="empUuid" type="hidden" value="${loginEmp.uuid }"> <input name="pageNum" id="pageNum" type="hidden" value="${page.currentPageNum }"> <input id="totalPages" type="hidden" value="${page.totalPageSize }">
				</form>
				<ul id="pagination" class="pagination"></ul>
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
</body>
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<!-- Morris Charts JavaScript -->
<script src="${pageContext.request.contextPath}/assets/js/jqPaginator.js"></script>
<script type="text/javascript">
   
//ajax get new sOrders num
$.get("/dellERP/sOrder/getCount.do?status=2", function(result)
	{
	  $("#deliverOrderCount").text(result.count);
	  
	});
	
$.get("/dellERP/sOrder/getCount.do?status=1", function(result)
		{
		  
		  $("#orderNeedAssemblyCount").text(result.count);
		});
   
   current=$('#pageNum').val();
	totalPage=$('#totalPages').val(); 
  
   var status="${status}";
  
   if(2==status)
	   {
	   $("#showControl1").attr("class","hidden");
	   $("#showControl2").attr("class","show");
	   }
   if(1==status)
	   {
	   $("#showControl1").attr("class","show");
	   $("#showControl2").attr("class","hidden");
	   }
   
   $.jqPaginator('#pagination', {
       totalPages: eval(totalPage),
       visiblePages: 6,
       currentPage:  eval(current),
       prev: '<li class="prev"><a href="javascript:;">Previous</a></li>',
       next: '<li class="next"><a href="javascript:;">Next</a></li>',
       page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
       onPageChange: function (num, type) {
           $('#pageNum').val(num);
           
           if(type=="change"){
                                   
           $('#searchForm').submit()
           }
           
       }  
   });
   
   </script>
</html>
