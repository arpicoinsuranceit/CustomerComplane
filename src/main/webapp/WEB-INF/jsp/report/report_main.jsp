<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
<link href="../assets/assets-for-demo/demo.css" rel="stylesheet" />
<!-- datatable -->
<link rel="stylesheet" type="text/css"
	href="../assets/datatable/datatables.min.css" />
<link href="../assets/css/custom.css" rel="stylesheet" />
</head>

<body class="">
	<div class="wrapper">

		<!-- sidebar start -->

		<jsp:include page="../core/sidebar.jsp">
			<jsp:param name="cur_page" value="Reports" />
		</jsp:include>

		<!-- sidebar end -->



		<div class="main-panel">

			<!-- nav bar start -->

			<jsp:include page="../core/navbar.jsp">
				<jsp:param name="topic" value="Reports" />
			</jsp:include>


			<!-- nav bar end -->

			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-12 col-md-12">
							<div class="card">
								<div class="card-header card-header-pri"
									style="background-color: #224099; opacity: 0.8;">
									<div class="row">
										<div class="col-md-8 col-lg-8">
											<h4 class="card-title">Report</h4>
										</div>
									</div>
								</div>

								<div class="card-body">
									<form>
										<div class="row">

											<div class="col-md-4">
												<label for="from_date">From Date</label> <input type="date"
													name="from_date" id="from_date" class="form-control" />
													
												<label for="to_date">To Date</label> <input type="date"
													name="to_date" id="to_date" class="form-control" />
											</div>

											<div class="col-md-8">
												<div class="row">
											<div class="col-lg-3 col-md-6 col-sm-6">
												<div class="card card-stats">
													<div class="card-header card-header-blue card-header-icon">
														<div class="card-icon" id="blue-card" style="opacity: 0.5;">
															<i class="fa fa-table" aria-hidden="true"></i>
														</div>
														
													</div>
													<div class="card-footer">
														<div class="stats">
															Customer Complaints
														</div>
													</div>
												</div>
											</div>
											<div class="col-lg-3 col-md-6 col-sm-6">
												<div class="card card-stats">
													<div class="card-header card-header-danger card-header-icon">
														<div class="card-icon"
															style="background-color: #F26F21; opacity: 0.5;">
															<i class="fa fa-tasks" aria-hidden="true"></i>
														</div>
													</div>
													<div class="card-footer">
														<div class="stats">
															Performance <br> Report
														</div>
													</div>
												</div>
											</div>
											<div class="col-lg-3 col-md-6 col-sm-6">
												<div class="card card-stats">
													<div class="card-header card-header-blue card-header-icon">
														<div class="card-icon"
															style="background-color: #F26F21; opacity: 0.5;">
															<i class="fa fa-bar-chart" aria-hidden="true"></i>
														</div>
													</div>
													<div class="card-footer">
														<div class="stats">
															Age Analysis Of Outstanding Complaints
														</div>
													</div>
												</div>
											</div>
											<div class="col-lg-3 col-md-6 col-sm-6">
												<div class="card card-stats">
													<div class="card-header card-header-info card-header-icon">
														<div class="card-icon" id="blue-card"
															style="opacity: 0.5;">
															<i class="fa fa-file-text-o" aria-hidden="true"></i>
														</div>
													</div>
													<div class="card-footer">
														<div class="stats">
															Root Cause Analysis
														</div>
													</div>
												</div>
											</div>
										</div>
									
											</div>

										</div>
									</form>
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
	<script type="text/javascript"
		src="../assets/datatable/datatables.min.js"></script>
	<script src="../assets/js/bootstrap-datepicker.js"></script>

	<script>
		function addComplaint() {
			window.location.replace("/addcomplaint");
		}

		function editComplaint(id) {
			//alert(id);
			window.location.replace("/updatecomplaint/" + id);
		}

		function viewComplaint(id) {
			//alert(id);
			window.location.replace("/viewcomplaint/" + id);
		}
	</script>
</body>


</html>