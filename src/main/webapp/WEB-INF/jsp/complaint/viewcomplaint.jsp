<%@page import="org.arpicoinsurance.groupit.complaint.main.dto.ImageDto"%>
<%@page import="org.arpicoinsurance.groupit.complaint.main.dto.ComplaintStageDetailsDto"%>
<%@page import="org.arpicoinsurance.groupit.complaint.main.dto.ComplaintDto"%>
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
</head>
<body onload="">
	<div class="wrapper">
	<!-- sidebar start -->
	<div class="sidebar" data-color="ar-orange"
			data-background-color="white"
			data-image="../assets/img/sidebar-1.jpg">

	<div class="logo">
				<a href="http://www.arpicoinsurance.com/"
					class="simple-text logo-normal"><img src="../assets/img/logo.png"
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
			
		
		<% ComplaintDto complaintDto=(ComplaintDto)session.getAttribute("viewComplaint"); %>
		
			<div class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header card-header-pri" style="background-color: #224099;opacity: 0.8;">
                                    <h5 class="card-title">Customer Detail</h5>
                                </div>
                                <div class="card-body">
                                	<table style="width: 100%;">
										<tr>
											<th>Customer Name </th>
											<td>: <%= complaintDto.getCustomerDto().getCustomerName() %></td>
											
											<th>Nic </th>
											<td>: <%= complaintDto.getCustomerDto().getCustomerNic() %></td>
											
											<th>Email </th>
											<td>: <%= complaintDto.getCustomerDto().getCustomerEmail() %></td>
											
											<th>Mobile </th>
											<td>: <%= complaintDto.getCustomerDto().getCustomerMobile() %></td>
										</tr>                                	
                                	</table>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header card-header-pri" style="background-color: #224099;opacity: 0.8;">
                                    <h5 class="card-title">Complaint Detail</h5>
                                </div>
                                <div class="card-body">
                                	<table style="width: 100%;">
										<tr>
											<th>Complaint Reference </th>
											<td>: <%= complaintDto.getComplaintReference() %></td>
											
											<th>Complaint Message </th>
											<td>: <%= complaintDto.getComplaintMessage() %></td>
											
											
										</tr>  
										
										<tr>
											<th>Complaint Subject </th>
											<td>: <%= complaintDto.getComplaintSubject() %></td>
											
											<th>Complaint Type </th>
											<td>: <%= complaintDto.getComplaintType() %></td>
										</tr>  
										
										<tr>
											<th>Complaint Date </th>
											<td>: <%= complaintDto.getComplaintCreateDate() %></td>
											
											<th>Acknowledgement Date </th>
											<td>: <%= complaintDto.getAcknowledgementDate() %></td>
										</tr>
										
										<tr>
											<th>Complaint Status </th>
											<td>: <%= complaintDto.getComplaintStatus() %></td>
											
											<th>Complaint Action </th>
											<td>: <%= complaintDto.getComplaintAction() %></td>
										</tr>
										
										<tr>
											<th>Complaint Root Cause </th>
											<td>: <%= complaintDto.getComplaintRootCause() %></td>
											
											
										</tr>                                	
                                	</table>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header card-header-pri" style="background-color: #224099;opacity: 0.8;">
                                    <h5 class="card-title">Complaint Stage Detail</h5>
                                </div>
                                <div class="card-body">
                                <% for(ComplaintStageDetailsDto complaintStageDetailsDto:complaintDto.getComplaintsDetails()){ %>
                                	<table style="width: 100%;">
										<tr>
											<th>Complaint Stage </th>
											<td>: <%= complaintStageDetailsDto.getStage().getStageName() %></td>
											
											<th>Complaint Stage Note</th>
											<td>: <%= complaintStageDetailsDto.getStage().getStageDescription() %></td>											
										</tr>
										
										<tr>
											<th>Description </th>
											<td>: <%= complaintStageDetailsDto.getDescription() %></td>
										</tr>
										
										<tr>
											<th>Attachments </th>
											<td>: </td>
										</tr> 
										
										<tr>
											<% int i=1; %>
											<% for(ImageDto imageDto : complaintStageDetailsDto.getImages()){ %>
												<td><a href="" onclick="downloadFile('<%= imageDto.getImageId() %>')" ><i class="material-icons">attach_file</i> Attachment(<%= i %>)</a></td>
												<% i++; %>
											<%} %>
										</tr>                                	
                                	</table>
                                	<hr>
                                	<% } %>
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
	<script src="../assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>

	<script>
		
		function downloadFile(id){
			window.open("/downloadFile/"+id ,"blank");
		}
		
		
	</script>
</body>


</html>