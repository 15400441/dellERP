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
<link href="${pageContext.request.contextPath}/assets/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="wrapper">
		<%@ include file="navForFinancial.jsp"%>
		<div id="page-wrapper">
			<div class="container-fluid">
				<!-- Page Heading -->
				<div class="row">
					<div class="form-group">
						<form action="${pageContext.request.contextPath}/transaction/getTransactionList.do" id="searchForm" method="post">
						
						    Type:<select class="form-control" name="type" style="width:20%; display:inline" id="typeSelect">
						    <option value="">All</option>
						    <option value="sale">Sale</option>
						    <option value="buy">Buy</option>						    
						    </select>
							Start Date:<input name="startDate" id="datetimepicker1" type="text" value="${searchEmp.name }" class="form-control" style="width:20%; display:inline"> 
							End Date:<input name="endDate" id="datetimepicker2" type="text" value="${searchEmp.empNum }" class="form-control" style="width:20%; display:inline"> 
							<input name="pageNum" id="pageNum" type="hidden" value="${page.currentPageNum }">
                            <input id="totalPages" type="hidden" value="${page.totalPageSize }">
							<button type="submit" class="btn btn-primary">Search</button>  
							
						</form>
					</div>
				</div>
				
				
				<!-- /.row -->
				
				<div id="showControl1" class="show">
				<div class="row">
					<div class="col-lg-10">
					    
						<h2>Transactions</h2>
						<a href="${pageContext.request.contextPath}/transaction/downloadTransactions.do">download this month transactions</a>
						<div class="table-responsive">
							<table class="table table-bordered table-hover table-striped">
								<thead>
									<tr>
										<th>Transaction ID</th>
										<th>Transaction type </th>
										<th>Income</th>
										<th>Expense</th>
										<th>Date</th>
										<th>Detail</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${page.records}" var="t">
										<tr>
											<td>${t.uuid }</td>
											<td>${t.type }</td>
											<td>${t.moneyIn }</td>
											<td>${t.moneyOut }</td>
											<td>${t.date }</td>
											<td><a href="#">detail</a>
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
<script src="${pageContext.request.contextPath}/assets/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
<script type="text/javascript">



function initailSearchCriteria()
{
	var type="${transaction.type}";
	var startDate="${startDate}";
	var endDate="${endDate}";
	$("#typeSelect").val(type);
	$("#datetimepicker1").val(startDate);
	$("#datetimepicker2").val(endDate);
}

initailSearchCriteria();

function initialTimePicker()
{
	$('#datetimepicker1').datetimepicker({
	    format: 'yyyy-mm-dd ',
	    todayBtn :true,
	    minView :2,
	    autoclose: true
	});

	$('#datetimepicker2').datetimepicker({
	    format: 'yyyy-mm-dd ',
	    todayBtn :true,
	    minView :2,
	    autoclose: true
	});
	
}

initialTimePicker();
   
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
