<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
<title>orders</title>
<!-- Bootstrap Core CSS -->
<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/assets/css/sb-admin.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="wrapper">
		<!-- Navigation -->
		<%@ include file="nav.jsp"%>
		<div id="page-wrapper">
			<div class="container-fluid">
				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Tables</h1>
						<ol class="breadcrumb">
							<li><i class="fa fa-dashboard"></i> <a href="index.html">Home</a>
							</li>
							<li class="active"><i class="fa fa-table"></i> New orders</li>
						</ol>
					</div>
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-10">
						<h2>New orders</h2>
						<div class="table-responsive">
							<table class="table table-bordered table-hover table-striped">
								<thead>
									<tr>
										<th>Order num</th>
										<th>Start Time</th>
										<th>Total price</th>
										<th>Customer id</th>
										<th>Detail</th>
										<th>Assign task</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${page.records }" var="o">
										<tr>
											<td>${o.orderNum }</td>
											<td>${o.startTime }</td>
											<td>${o.totalPrice }</td>
											<td>${o.customerUuid }</td>
											<td><a href="${pageContext.request.contextPath}/sOrder/getDetail?uuid=${o.uuid}">Detail</a></td>
											<td><a href="javascript:showStaffs(${o.uuid })" >assign</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<form action="${pageContext.request.contextPath}/sOrder/orderList.do" id="searchForm">
					<input name="status" type="hidden" value="0"> <input name="pageNum" id="pageNum" type="hidden" value="${page.currentPageNum }"> <input id="totalPages" type="hidden" value="${page.totalPageSize }">
				</form>
				<ul id="pagination" class="pagination"></ul>
				<!-- /.row -->
				
				
				<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">Avaiable assembly department staffs  </h4>
							</div>
							<div class="modal-body">
							
							<form action="${pageContext.request.contextPath}/sOrder/assignOrder.do">
							<input type="hidden" name="orderUuid" value="" id="orderUuid">
							<table id="table">
					
							</table>
							
							
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">close</button>
								<button type="submit" class="btn btn-primary">submit</button>
							</div>
							</form>
							
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
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
		<script src="${pageContext.request.contextPath}/assets/js/bootstrap-table.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/jqPaginator.js"></script>
		<script type="text/javascript">
    
    
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
    
    
    function showStaffs(uuid)
    {
    	
    	$("#orderUuid").val(uuid);
    	
    			   $('#table').bootstrapTable({
    		    		url:"${pageContext.request.contextPath}/emp/getEmpInfo",
    		            columns: [{
    		                field: 'empNum',
    		                title: 'Employ number'
    		            }, {
    		                field: 'name',
    		                title: 'Name'
    		            }, 
    		            {
    		                field: 'count',
    		                title: 'Unfinished orders number'
    		            },
    		            {
    		            	
    		            	radio:true
    		               
    		            	     
    		            }
    		            
    		            ],
    		           
    		    	   pagination:true,
    		    	   pageNum:1,
    		    	   pageSize:5,
    		    	   clickToSelect:true,
    		    	   idField:'uuid',
    		    	   selectItemName:'empUuid'
    		        });
    		    	
    		    	$('#myModal').modal('show');
    		    	
    	}
    			   		   
    		
    	
    	
    	
    
    
    </script>
</body>
</html>
