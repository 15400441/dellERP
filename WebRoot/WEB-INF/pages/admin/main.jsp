<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<%@ include file="navForManager.jsp"%>
		<div id="page-wrapper">
			<div class="container-fluid">
				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							Home <small>Statistics Overview</small>
						</h1>
						<ol class="breadcrumb">
							<li class="active"><i class="fa fa-dashboard"></i> Dashboard</li>
						</ol>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-3 col-md-6">
						<div class="panel panel-green">
							<div class="panel-heading">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa fa-tasks fa-5x"></i>
									</div>
									<div class="col-xs-9 text-right">
										<div class="huge">12</div>
										<div>New Tasks!</div>
									</div>
								</div>
							</div>
							<a href="#">
								<div class="panel-footer">
									<span class="pull-left">View Details</span> <span class="pull-right"><i class="fa fa-arrow-circle-right"></i>
									</span>
									<div class="clearfix"></div>
								</div> </a>
						</div>
					</div>
					<div class="col-lg-3 col-md-6">
						<div class="panel panel-yellow">
							<div class="panel-heading">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa fa-shopping-cart fa-5x"></i>
									</div>
									<div class="col-xs-9 text-right">
										<div class="huge" id="newOrderCount"></div>
										<div>New Orders!</div>
									</div>
								</div>
							</div>
							<a href="${pageContext.request.contextPath}/sOrder/orderList.do?status=0">
								<div class="panel-footer">
									<span class="pull-left">View Details</span> <span class="pull-right"><i class="fa fa-arrow-circle-right"></i>
									</span>
									<div class="clearfix"></div>
								</div> </a>
						</div>
					</div>
					<div class="col-lg-4 col-md-6">
						<div class="panel panel-red">
							<div class="panel-heading">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa fa-support fa-5x"></i>
									</div>
									<div class="col-xs-9 text-right">
										<div class="huge" id="insufficientComponentCount"></div>
										<div>Insufficient components!</div>
									</div>
								</div>
							</div>
							<a href="${pageContext.request.contextPath}/components/getInsufficientComponents.do">
								<div class="panel-footer">
									<span class="pull-left">View Details</span> <span class="pull-right"><i class="fa fa-arrow-circle-right"></i>
									</span>
									<div class="clearfix"></div>
								</div> </a>
						</div>
					</div>
				</div>
				<!-- /.row -->
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-5">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<i class="fa fa-clock-o fa-fw"></i> Tasks Panel
								</h3>
							</div>
							<div class="panel-body">
								<div class="list-group">
									<a href="#" class="list-group-item"> <span class="badge">1 hour ago</span> <i class="fa fa-fw fa-user"></i> A new user has been added </a> <a href="#" class="list-group-item"> <span class="badge">2 hours ago</span> <i class="fa fa-fw fa-check"></i> Completed task: "pick up dry cleaning" </a> <a href="#" class="list-group-item"> <span class="badge">yesterday</span> <i
										class="fa fa-fw fa-globe"></i> Saved the world </a> <a href="#" class="list-group-item"> <span class="badge">two days ago</span> <i class="fa fa-fw fa-check"></i> Completed task: "fix error on sales page" </a>
								</div>
								<div class="text-right">
									<a href="#">View All Activity <i class="fa fa-arrow-circle-right"></i>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
	<!-- Morris Charts JavaScript -->
	<script src="${pageContext.request.contextPath}/assets/js/plugins/morris/raphael.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/plugins/morris/morris.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/plugins/morris/morris-data.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
</body>
</html>
