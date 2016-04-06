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
					<div class="form-group">
						<form action="${pageContext.request.contextPath}/emp/getEmpList.do" id="searchForm" method="post">
						    Department:<select class="form-control" name="depUuid" style="width:20%; display:inline" id="depSelect">
						    <option value="">All</option>
						    <c:forEach items="${depList }" var="d">
						    <option value="${ d.uuid}">${ d.name}</option>
						    </c:forEach>
						    </select>
							Name:<input name="name" type="text" value="${searchEmp.name }" class="form-control" style="width:20%; display:inline"> 
							Employ Num:<input name="empNum" type="text" value="${searchEmp.empNum }" class="form-control" style="width:20%; display:inline"> 
							<input name="pageNum" id="pageNum" type="hidden" value="${page.currentPageNum }">
                            <input id="totalPages" type="hidden" value="${page.totalPageSize }">
							<button type="submit" class="btn btn-primary">Search</button>  <a href="${pageContext.request.contextPath}/emp/empAddUI.do" class="btn btn-primary">Add</a>
							
						</form>
					</div>
				</div>
				
				
				<!-- /.row -->
				
				
					<div class="row">
						<div class="col-lg-11">
							<h2>Employees</h2>
							
							<div class="table-responsive">
								<table class="table table-bordered table-hover table-striped">
									<thead>
										<tr>
											<th>Name</th>
											<th>Gender</th>
											<th>Employe num</th>
											<th>Email</th>
											<th>Salary</th>
											<th>Birthday</th>
											<th>Address</th>	
											<th>Update</th>	
											<th>Delete</th>									
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${page.records}" var="e">
											<tr>
												<td>${e.name }</td>
												<td>${e.gender }</td>
												<td>${e.empNum }</td>
												<td>${e.email }</td>
												<td>${e.salary }</td>
												<td>${e.birthday }</td>
												<td>${e.address }</td>
												<td><a href="${pageContext.request.contextPath}/emp/empUpdateUI.do?uuid=${e.uuid}">update</a></td>
												<td><a href="${pageContext.request.contextPath}/emp/empDelete.do?uuid=${e.uuid}">delete</a></td>
												
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				
				<!-- /.row -->
				
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
   
   var depUuid="${searchEmp.depUuid}"
   if(depUuid!=null&&depUuid!="")
	   $("#depSelect").val(depUuid);
   
   var msg="${msg}";
   if(msg!=null&&msg!="")
	   alert(msg);
   
   current=$('#pageNum').val();
	totalPage=$('#totalPages').val(); 
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
