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

    <title>Order Details</title>

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
        <%@ include file="navForAssemblyEmp.jsp"%>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Tables
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-table"></i> Tables
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                   
                    <div class="col-lg-10">
                        <h2>Order Detail</h2>
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                 <thead>
                                    <tr>
                                        <th>Components name</th>
                                        <th>amount</th>                
                                        <th>Total price</th>
                                        
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${orderDetailViewList}" var="od">
                                    <tr>
                                        <td>${od.name }</td>
                                        <td>${od.amount }</td>
                                        <td>${od.totalPrice }</td>
                                 
                                    </tr>
                                 </c:forEach> 
                                </tbody>
                            </table>
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
    <script  src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>

</body>

</html>
