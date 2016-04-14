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
</head>
<body>
	<div class="well well-lg">
		<h1>
			My home
		</h1>
	</div>
		
		
		
				<div class="row">
					<div class="col-lg-12">
						<h2 class="orderStatus">My orders</h2>
						<div class="table-responsive">
							<table class="table table-bordered table-hover table-striped">
								<thead>
									<tr>
										<th>Order num</th>
										<th>Start Time</th>
										<th>End Time</th>
										<th>Total price</th>						
										<th>Description</th>
										<th>Status</th>
										<th>Confirm goods receipt</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${sOrderList}" var="o">
										<tr>
											<td>${o.orderNum }</td>
											<td>${o.startTime }</td>
											<td>${o.endTime }</td>
											<td>${o.totalPrice }</td>
											
											<td>${o.des }</td>
											<td class="finished">${o.statusView }</td>
											<td><a href="${pageContext.request.contextPath}/sOrder/confirmOrder?uuid=${o.uuid}">confirm</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				
			
		
		<!-- jQuery -->
		<script src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>
		<!-- Bootstrap Core JavaScript -->
		<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
		
		<script type="text/javascript">
    
		var msg='${msg}';
		if(msg!=null && msg!="" )
		alert(msg);
		
		function disappearA()
		{
			var obj=$(".finished");
			$.each(obj,function(i,val){
				var $v=$(val)
				if($v.text().trim()=="finished")
					$v.next().text("disabled");
				
			});
		}
		
		disappearA()
		
    
    </script>
</body>
</html>
