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
		<%@ include file="navForManager.jsp"%>
		<div id="page-wrapper">
			<div class="container-fluid">
				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Tables</h1>
						<ol class="breadcrumb">
							<li><i class="fa fa-dashboard"></i> <a href="#">Home</a></li>
							<li class="active"><i class="fa fa-table"></i> Insufficient components</li>
						</ol>
					</div>
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-10">
						<h2>Components</h2>
						<div class="table-responsive">
							<table class="table table-bordered table-hover table-striped">
								<thead>
									<tr>
										<th>Name</th>
										<th>Producer</th>
										<th>Purchasing price</th>
										<th>Selling price</th>
										<th>Inventory/Sufficient level</th>
										<th>Purchase</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${components }" var="c">
										<tr>
											<td>${c.name }</td>
											<td>${c.producer }</td>
											<td>${c.inPrice }</td>
											<td>${c.outPrice }</td>
											<td><label style="color:green">${c.inventory }</label>/<label style="color:red">${c.sufficientLevel }</label>
											</td>
											<td><a href="javascript:purchasePop('${c.uuid }','${c.name}','${c.inPrice }')">purchase</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /.row -->
				<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">Choose supplier</h4>
							</div>
							<div class="modal-body">
								<form action="${pageContext.request.contextPath}/components/purchase.do" onsubmit="return check()">
									<input type="hidden" name="componentsUuid" value="" id="componentsUuid"> <input type="hidden" name="inPrice" value="" id="inPrice">
									<lable id="name"></lable>
									<input type="number" min="1" placeholder="purchse number" name="num" class="form-control" style="width:40%; display:inline" required>
									<hr>
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
    
    
    function purchasePop(uuid,name,price)
    {
    	$("#componentsUuid").val(uuid);
    	$("#inPrice").val(price);
        $("#name").text(name+":");
       
       $('#table').bootstrapTable({
   		url:"${pageContext.request.contextPath}/supplier/getAll",
           columns: [{
               field: 'name',
               title: 'Supplier'
           }, {
               field: 'tele',
               title: 'Tele'
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
   	   selectItemName:'supplierUuid'
       });
       
       $('#myModal').modal('show');
   			    	
    };
    
    		
    			   		   
     function check()
    {
      
    	var supplier=$('input:radio[name="supplierUuid"]:checked').val();
    	if(supplier==null)
    	{
    	alert("please choose supplier")
    	return false;
    	}
    	else
    	return true;
    
    }
    
    	
    	
  
    </script>
</body>
</html>
