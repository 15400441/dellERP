<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<title>Dell DIY your PC</title>
<meta name="description" content="Dell: Select the components you like to assemble your PC">
<meta name="keywords" content="Dell PC Assemble">
<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/assets/css/login-register.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/assets/css/mydiy.css" rel="stylesheet" type="text/css" charset="gbk" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-10"></div>
			<div class="col-sm-2">
				<a class="btn" data-toggle="modal" href="javascript:void(0)" onclick="openLoginModal();">Log in</a> 
				<a class="btn" data-toggle="modal" href="javascript:void(0)" onclick="openRegisterModal();">Register</a>
			</div>
		</div>
		
		<div class="modal fade login" id="loginModal">
			<div class="modal-dialog login animated">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title">Login</h4>
					</div>
					<div class="modal-body">
						<div class="box">
							<div class="content">
								<div class="form loginBox">
									<form method="post" action="/login" accept-charset="UTF-8">
										<input id="username" class="form-control" type="text" placeholder="username" name="username"> <input id="password" class="form-control" type="password" placeholder="Password" name="password"> <input class="btn btn-default btn-login" type="button" value="Login" onclick="loginAjax()">
									</form>
								</div>
							</div>
						</div>
						<div class="box">
							<div class="content registerBox" style="display:none;">
								<div class="form">
									<form method="post" html="{:multipart=>true}" data-remote="true" action="/register" accept-charset="UTF-8">
										<input id="username" class="form-control" type="text" placeholder="username" name="username"> <input id="password" class="form-control" type="password" placeholder="Password" name="password"> <input id="password_confirmation" class="form-control" type="password" placeholder="Repeat Password" name="password_confirmation"> <input class="btn btn-default btn-register"
											type="submit" value="Create account" name="commit">
									</form>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<div class="forgot login-footer">
							<span>Looking to <a href="javascript: showRegisterForm();">create an account</a> ?</span>
						</div>
						<div class="forgot register-footer" style="display:none">
							<span>Already have an account?</span> <a href="javascript: showLoginForm();">Login</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		
        
        






	</div>
	
	<script src="${pageContext.request.contextPath}/assets/js/jquery-1.12.1.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/assets/js/login-register.js" type="text/javascript"></script>
</body>
</html>