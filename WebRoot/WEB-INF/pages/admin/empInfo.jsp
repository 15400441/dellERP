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
		<%@ include file="navForHumanResources.jsp"%>
		<div id="page-wrapper">
			<div class="container-fluid">
				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Employe information update</h1>
					</div>
				</div>
				<div class="show" id="control1">
					<div class="row">
						<div class="form-group">
							<form action="${pageContext.request.contextPath}/emp/empUpdate.do" id="searchForm" class="form-horizontal" method="post">
								<div class="form-group">
									<label class="col-sm-2 control-label">Department</label>
									<div class="col-sm-10">
										<select class="form-control" name="depUuid" style="width:50%;display:inline" id="depSelect">
											<c:forEach items="${depList }" var="d">
												<option value="${ d.uuid}">${ d.name}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Name</label>
									<div class="col-sm-10">
										<input name="name" type="text" value="${updateEmp.name }" class="form-control" style="width:50%; display:inline">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Employ Num</label>
									<div class="col-sm-10">
										<input name="empNum" type="text" value="${updateEmp.empNum }" class="form-control" style="width:50%;display:inline">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Username</label>
									<div class="col-sm-10">
										<input name="userName" required type="text" value="${updateEmp.userName }" class="form-control" style="width:50%;display:inline">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Password</label>
									<div class="col-sm-10">
										<input name="pwd" required type="password" value="originalPwd" class="form-control" style="width:50%;display:inline">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Salary</label>
									<div class="col-sm-10">
										<input name="salary" type="text" value="${updateEmp.salary }" class="form-control" style="width:50%;display:inline">
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button type="submit" class="btn btn-primary">update</button>
									</div>
								</div>
								<input name="uuid" type="hidden" value="${updateEmp.uuid }">
							</form>
						</div>
					</div>
				</div>
				<!-- /.row -->
				<!-- the part for add new employe -->
				<div class="hidden" id="control2">
					<div class="row">
						<div class="form-group">
							<form action="${pageContext.request.contextPath}/emp/empAdd.do" class="form-horizontal" method="post">
								<div class="form-group">
									<label class="col-sm-2 control-label">Department</label>
									<div class="col-sm-10">
										<select class="form-control" name="depUuid" style="width:50%;display:inline" id="depSelect">
											<c:forEach items="${depList }" var="d">
												<option value="${ d.uuid}">${ d.name}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Employ Num</label>
									<div class="col-sm-10">
										<input name="empNum" type="text" value="" class="form-control" style="width:50%;display:inline">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Username</label>
									<div class="col-sm-10">
										<input name="userName" required type="text" value="" class="form-control" style="width:50%;display:inline">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Password</label>
									<div class="col-sm-10">
										<input name="pwd" required type="password" value="" class="form-control" style="width:50%;display:inline">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Salary</label>
									<div class="col-sm-10">
										<input name="salary" type="text" value="" class="form-control" style="width:50%;display:inline">
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button type="submit" class="btn btn-primary">Add</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<!-- /.row -->
				</div>
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
	var depUuid = "${updateEmp.depUuid}"
	if (depUuid != null && depUuid != "")
		$("#depSelect").val(depUuid);

	var msg = "${msg}";
	if (msg != null && msg != "")
		alert(msg);

	var add = "${add}"
	if (add == "add")
	{
		$("#control1").attr("class", "hidden");
		$("#control2").attr("class", "show");
	}
</script>
</html>
