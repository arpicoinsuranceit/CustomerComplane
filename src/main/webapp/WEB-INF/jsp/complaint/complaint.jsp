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
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="../assets/css/material-dashboard.css?v=2.0.0">
<!-- Documentation extras -->
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="../assets/assets-for-demo/demo.css" rel="stylesheet" />

<link href="../assets/css/custom.css" rel="stylesheet" />
<!-- iframe removal -->

<!-- datatable -->
<link rel="stylesheet" type="text/css" href="../assets/datatable/datatables.min.css"/>

</head>
<body class="">
	<div class="wrapper">
		
		<!-- sidebar start -->
	<div class="sidebar" data-color="ar-orange"
			data-background-color="white"
			data-image="../assets/img/sidebar-1.jpg">

	<div class="logo">
				<a href="http://www.arpicoinsurance.com/"
					class="simple-text logo-normal"><img src="assets/img/logo.png"
					style="width: 75%; height: 100px;" alt="ARPICO INSURANCE"></a>
			</div>
			<div class="sidebar-wrapper">
				<ul class="nav">
					<li class="nav-item"><a class="nav-link"
						href="/home"> <i class="material-icons">dashboard</i>
							<p>Dashboard</p>
					</a></li>
					<li class="nav-item active">
						<a class="nav-link" href="/complaint"> 
							<i class="material-icons">content_paste</i>
							<p>Customer Complaints</p>
						</a>
					</li>
					<li class="nav-item "><a class="nav-link"
						href="../examples/typography.html"> <i class="material-icons">library_books</i>
							<p>Reports</p>
					</a></li>
					<li class="nav-item "><a class="nav-link"
						href="../examples/notifications.html"> <i
							class="material-icons">notifications</i>
							<p>Notifications</p>
					</a></li>
					<li class="nav-item "><a class="nav-link"
						href="../examples/user.html"> <i class="material-icons">person</i>
							<p>User Profile</p>
					</a></li>
				</ul>
			</div>
		</div>
		<!-- sidebar end -->
		
		
		
		<div class="main-panel">
		
		<!-- nav bar start -->
		
		<nav
				class="navbar navbar-expand-lg navbar-transparent  navbar-absolute fixed-top">
			<div class="container-fluid">
				<div class="navbar-wrapper">
					<a class="navbar-brand" href="/complaint">Customer Complaints</a>
				</div>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navigation" aria-controls="navigation-index"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="sr-only">Toggle navigation</span> <span
						class="navbar-toggler-icon icon-bar"></span> <span
						class="navbar-toggler-icon icon-bar"></span> <span
						class="navbar-toggler-icon icon-bar"></span>
				</button>
				<div class="collapse navbar-collapse justify-content-end"
					id="navigation">
					<form class="navbar-form">
						<div class="input-group no-border">
							<input type="text" value="" class="form-control"
								placeholder="Search...">
							<button type="submit"
								class="btn btn-white btn-round btn-just-icon">
								<i class="material-icons">search</i>
								<div class="ripple-container"></div>
							</button>
						</div>
					</form>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="#pablo"> <i
								class="material-icons">dashboard</i>
								<p>
									<span class="d-lg-none d-md-block">Stats</span>
								</p>
						</a></li>
						<li class="nav-item dropdown"><a class="nav-link"
							href="http://example.com" id="navbarDropdownMenuLink"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<i class="material-icons">notifications</i> <span
								class="notification">5</span>
								<p>
									<span class="d-lg-none d-md-block">Some Actions</span>
								</p>
						</a>
							<div class="dropdown-menu dropdown-menu-right"
								aria-labelledby="navbarDropdownMenuLink">
								<a class="dropdown-item" href="#">Mike John responded to
									your email</a> <a class="dropdown-item" href="#">You have 5 new
									tasks</a> <a class="dropdown-item" href="#">You're now friend
									with Andrew</a> <a class="dropdown-item" href="#">Another
									Notification</a> <a class="dropdown-item" href="#">Another One</a>
							</div></li>
						<li class="nav-item"><a class="nav-link" href=""> <i
								class="material-icons">person</i>
								<p>
									<span class="d-lg-none d-md-block">Account</span>
								</p>
						</a></li>
					</ul>
				</div>
			</div>
			</nav>
			
			<!-- nav bar end -->
		
			<div class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12 col-md-12">
                            <div class="card">
                                <div class="card-header card-header-pri" style="background-color: #224099;opacity: 0.8;">
                                    <div class="row">
                                    	<div class="col-md-8 col-lg-8">
                                    	<h4 class="card-title">Complaints</h4>
                                    </div>
                                    <div class="col-md-4 col-lg-4">
                                    	<button type="button" class="btn btn-bl pull-right" style="background-color: #F26F21;" onclick="addComplaint()">New</button>
                                    </div>
                                    </div>
                                    
                                    
                                </div>
                                <div class="card-body table-responsive">
                                    <table class="table table-hover" id="complaint_table" style="width:100%">
                                        <thead class="text-warning">
	                                        <tr>
	                                        	<th>Customer Name</th>
	                                            <th>Nic</th>
	                                            <th>Email</th>
	                                            <th>Mobile</th>
	                                            <th>Reference</th>
	                                            <th>Complaint Category</th>
	                                            <th>Subject</th>
	                                            <th>Message</th>
	                                            <th> </th>
	                                            
	                                        </tr>
	                                     </thead>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
			
		<jsp:include page="../core/footer.jsp"></jsp:include>
		</div>
	</div>


	<!--   Core JS Files   -->
	<script src="../assets/js/core/jquery.min.js"></script>
	<script src="../assets/js/core/popper.min.js"></script>
	<script src="../assets/js/bootstrap-material-design.js"></script>
	<script src="../assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
	<script type="text/javascript" src="../assets/datatable/datatables.min.js"></script>

	<script>
		
		function addComplaint(){
			window.location.replace("/addcomplaint");
		}
		
		$(function () {
            var table = $('#complaint_table').DataTable({
                'ajax': '/view_complaint_dt',
                "columns": [
            	    { "data": "name" },
            	    { "data": "nic" },
            	    { "data": "email" },
            	    { "data": "mobile" },
            	    { "data": "reference" },
            	    { "data": "category" },
            	    { "data": "subject" },
            	    { "data": "message" },
            	    { "data": "edit" }
            	]
            });
        });
		
		function editComplaint(id){
			alert(id);
		}
	</script>
</body>


</html>