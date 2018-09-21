<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"
	name="viewport" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<!-- Favicons -->
<link rel="apple-touch-icon" href="../assets/img/develop.gif">
<link rel="icon" href="../assets/img/develop.gif">
<title>Customer Complaint System</title>
<!--     Fonts and icons     -->
<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="../assets/css/material-dashboard.css?v=2.0.0">
<!-- Documentation extras -->
<!-- CSS Just for demo purpose, don't include it in your project -->
<!--<link href="../assets/assets-for-demo/demo.css" rel="stylesheet" />-->

<link href="../assets/css/custom.css" rel="stylesheet" />
<!-- iframe removal -->
</head>
<body>
	<div class="wrapper">
		<div class="content">
			<div class="container-fluid" id="div_center">
				<div class="card" id="loginDiv">
					<div class="card-body">
						<div id="imgDiv">
							<img src="assets/img/logo.png" alt="ARPICO INSURANCE">
						</div>
						<h2>Sign in</h2>
						<h5>with your Arpico Insurance Account</h5>
						<form id="signInForm" name="signInForm" method="post" action="/login">
							<div style="width: 100%;height: 20px;text-align: center;color: red;padding: 5px;">
								${login_error}
							</div>
							
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="bmd-label-floating" for="userName">User
											Name</label> <input type="text" id="userName" name="userName"
											class="form-control" required>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="bmd-label-floating" for="password">Password</label>
										<input type="password" required id="password" name="password"
											class="form-control">
									</div>
								</div>
							</div>
							
							<input type="submit" class="btn btn-blue pull-right"
								id="signInBtn" value="SIGN IN">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--   Core JS Files   -->
	<script src="../assets/js/core/jquery.min.js"></script>
	<script src="../assets/js/core/popper.min.js"></script>
	<script src="../assets/js/bootstrap-material-design.js"></script>
	<script src="../assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>

	<script>
	
	/*function signIn() {
		
		if(($("#userName").val() != "" && $("#userName").val() != " ") && ($("#password").val() != "" &&  $("#password").val() != " ")){
			$.ajax({
				type : "POST",
				url : "/signin",
				data : {userName:$("#userName").val(),password:$("#password").val(),subSbu:"3"},
				success : function(result) {
					console.log(result);
					
				},
				error : function(result) {
					console.log(result);
					alert(result);
				}
			});
		}else{
			alert("Please enter username and password.");
		}
		
		
	}	*/
	
	</script>
</body>


</html>