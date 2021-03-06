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
									<form method="post"  accept-charset="UTF-8">
										<input id="username" class="form-control" type="text" placeholder="username" name="username"> 
										<input id="password" class="form-control" type="password" placeholder="Password" name="password"> 
										<input class="btn btn-default btn-login" type="button" value="Login" onclick="loginAjax()">
									</form>
								</div>
							</div>
						</div>
						<div class="box">
							<div class="content registerBox" style="display:none;">
								<div class="form">
									<form method="post" html="{:multipart=>true}" data-remote="true"  accept-charset="UTF-8">
										<input id="username1" class="form-control" type="text" placeholder="username" name="username" required> 
										<input id="password1" class="form-control" type="password" placeholder="Password" name="password"> 
										<input id="password_confirmation" class="form-control" type="password" placeholder="Repeat Password" required name="password_confirmation"> 
										<input class="btn btn-default btn-register"
											type="button" value="Create account" onclick="register()">
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