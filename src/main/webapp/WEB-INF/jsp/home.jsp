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
<body class="">
	<div class="wrapper">
		
		<jsp:include page="core/sidebar.jsp"></jsp:include>
		
		<div class="main-panel">
			
			<jsp:include page="core/navbar.jsp"></jsp:include>
			
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-3 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header card-header-blue card-header-icon">
									<div class="card-icon" id="blue-card" style="opacity: 0.5;">
										<i class="material-icons">content_copy</i>
									</div>
									<p class="card-category">New Complaints</p>
									<h3 class="card-title">100</h3>
								</div>
								<div class="card-footer">
									<div class="stats">
										<i class="material-icons">update</i> Just Updated
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-3 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header card-header-danger card-header-icon">
									<div class="card-icon" style="background-color: #F26F21;opacity: 0.5;">
										<i class="material-icons">info_outline</i>
									</div>
									<p class="card-category">Not Resolved</p>
									<h3 class="card-title">20</h3>
								</div>
								<div class="card-footer">
									<div class="stats">
										<i class="material-icons text-danger">warning</i> Get Quick
										Action
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-3 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header card-header-blue card-header-icon">
									<div class="card-icon" style="background-color: #F26F21;opacity: 0.5;">
										<i class="material-icons">store</i>
									</div>
									<p class="card-category">Partially</p>
									<h3 class="card-title">75</h3>
								</div>
								<div class="card-footer">
									<div class="stats">
										<i class="material-icons">update</i> Just Updated
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-3 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header card-header-info card-header-icon">
									<div class="card-icon" id="blue-card" style="opacity: 0.5;">
										<i class="fa fa-twitter"></i>
									</div>
									<p class="card-category">Fully Resolved</p>
									<h3 class="card-title">245</h3>
								</div>
								<div class="card-footer">
									<div class="stats">
										<i class="material-icons">update</i> Just Updated
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-12 col-md-12">
							<div class="card">
								<div class="card-header card-header-tabs card-header-in" style="background-color: #224099;opacity: 0.8;">
									<div class="nav-tabs-navigation" style="background-color: #224099;">
										<div class="nav-tabs-wrapper" style="background-color: #224099;">
											<span class="nav-tabs-title">Complaints Summary:</span>
											<ul class="nav nav-tabs" data-tabs="tabs">
												<li class="nav-item"><a class="nav-link active"
													href="#profile" data-toggle="tab"> <i
														class="material-icons">bug_report</i> New
														<div class="ripple-container"></div>
												</a></li>
												<li class="nav-item"><a class="nav-link"
													href="#messages" data-toggle="tab"> <i
														class="material-icons">code</i> Not Resolved
														<div class="ripple-container"></div>
												</a></li>
												<li class="nav-item"><a class="nav-link"
													href="#settings" data-toggle="tab"> <i
														class="material-icons">cloud</i> Partially
														<div class="ripple-container"></div>
												</a></li>
											</ul>
										</div>
									</div>
								</div>
								<div class="card-body">
									<div class="tab-content">
										<div class="tab-pane active" id="profile" style="overflow-x: auto;max-height: 300px;">
											<table class="table" >
												<tbody id="tbody_newComplaints">
													<!--<tr>
														<td>
															<div class="form-check">
																<label class="form-check-label"> <input
																	class="form-check-input" type="checkbox" value=""
																	checked> <span class="form-check-sign">
																		<span class="check"></span>
																</span>
																</label>
															</div>
														</td>
														<td>Sign contract for "What are conference organizers
															afraid of?"</td>
														<td class="td-actions text-right">
															<button type="button" rel="tooltip" title="Edit Task"
																class="btn btn-primary btn-link btn-sm">
																<i class="material-icons">edit</i>
															</button>
															<button type="button" rel="tooltip" title="Remove"
																class="btn btn-danger btn-link btn-sm">
																<i class="material-icons">close</i>
															</button>
														</td>
													</tr>
													<tr>
														<td>
															<div class="form-check">
																<label class="form-check-label"> <input
																	class="form-check-input" type="checkbox" value="">
																	<span class="form-check-sign"> <span
																		class="check"></span>
																</span>
																</label>
															</div>
														</td>
														<td>Lines From Great Russian Literature? Or E-mails
															From My Boss?</td>
														<td class="td-actions text-right">
															<button type="button" rel="tooltip" title="Edit Task"
																class="btn btn-primary btn-link btn-sm">
																<i class="material-icons">edit</i>
															</button>
															<button type="button" rel="tooltip" title="Remove"
																class="btn btn-danger btn-link btn-sm">
																<i class="material-icons">close</i>
															</button>
														</td>
													</tr>
													<tr>
														<td>
															<div class="form-check">
																<label class="form-check-label"> <input
																	class="form-check-input" type="checkbox" value="">
																	<span class="form-check-sign"> <span
																		class="check"></span>
																</span>
																</label>
															</div>
														</td>
														<td>Flooded: One year later, assessing what was lost
															and what was found when a ravaging rain swept through
															metro Detroit</td>
														<td class="td-actions text-right">
															<button type="button" rel="tooltip" title="Edit Task"
																class="btn btn-primary btn-link btn-sm">
																<i class="material-icons">edit</i>
															</button>
															<button type="button" rel="tooltip" title="Remove"
																class="btn btn-danger btn-link btn-sm">
																<i class="material-icons">close</i>
															</button>
														</td>
													</tr>
													<tr>
														<td>
															<div class="form-check">
																<label class="form-check-label"> <input
																	class="form-check-input" type="checkbox" value=""
																	checked> <span class="form-check-sign">
																		<span class="check"></span>
																</span>
																</label>
															</div>
														</td>
														<td>Create 4 Invisible User Experiences you Never
															Knew About</td>
														<td class="td-actions text-right">
															<button type="button" rel="tooltip" title="Edit Task"
																class="btn btn-primary btn-link btn-sm">
																<i class="material-icons">edit</i>
															</button>
															<button type="button" rel="tooltip" title="Remove"
																class="btn btn-danger btn-link btn-sm">
																<i class="material-icons">close</i>
															</button>
														</td>
													</tr>-->
												</tbody>
												<tfoot id="tfoot_newComplaints">
												
												</tfoot>
												
											</table>
										</div>
										<div class="tab-pane" id="messages">
											<table class="table">
												<tbody>
													<tr>
														<td>
															<div class="form-check">
																<label class="form-check-label"> <input
																	class="form-check-input" type="checkbox" value=""
																	checked> <span class="form-check-sign">
																		<span class="check"></span>
																</span>
																</label>
															</div>
														</td>
														<td>Flooded: One year later, assessing what was lost
															and what was found when a ravaging rain swept through
															metro Detroit</td>
														<td class="td-actions text-right">
															<button type="button" rel="tooltip" title="Edit Task"
																class="btn btn-primary btn-link btn-sm">
																<i class="material-icons">edit</i>
															</button>
															<button type="button" rel="tooltip" title="Remove"
																class="btn btn-danger btn-link btn-sm">
																<i class="material-icons">close</i>
															</button>
														</td>
													</tr>
													<tr>
														<td>
															<div class="form-check">
																<label class="form-check-label"> <input
																	class="form-check-input" type="checkbox" value="">
																	<span class="form-check-sign"> <span
																		class="check"></span>
																</span>
																</label>
															</div>
														</td>
														<td>Sign contract for "What are conference organizers
															afraid of?"</td>
														<td class="td-actions text-right">
															<button type="button" rel="tooltip" title="Edit Task"
																class="btn btn-primary btn-link btn-sm">
																<i class="material-icons">edit</i>
															</button>
															<button type="button" rel="tooltip" title="Remove"
																class="btn btn-danger btn-link btn-sm">
																<i class="material-icons">close</i>
															</button>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
										<div class="tab-pane" id="settings">
											<table class="table">
												<tbody id="tbody_partiallyComplaints">
													<!--  <tr>
														<td>
															<div class="form-check">
																<label class="form-check-label"> <input
																	class="form-check-input" type="checkbox" value="">
																	<span class="form-check-sign"> <span
																		class="check"></span>
																</span>
																</label>
															</div>
														</td>
														<td>Lines From Great Russian Literature? Or E-mails
															From My Boss?</td>
														<td class="td-actions text-right">
															<button type="button" rel="tooltip" title="Edit Task"
																class="btn btn-primary btn-link btn-sm">
																<i class="material-icons">edit</i>
															</button>
															<button type="button" rel="tooltip" title="Remove"
																class="btn btn-danger btn-link btn-sm">
																<i class="material-icons">close</i>
															</button>
														</td>
													</tr>
													<tr>
														<td>
															<div class="form-check">
																<label class="form-check-label"> <input
																	class="form-check-input" type="checkbox" value=""
																	checked> <span class="form-check-sign">
																		<span class="check"></span>
																</span>
																</label>
															</div>
														</td>
														<td>Flooded: One year later, assessing what was lost
															and what was found when a ravaging rain swept through
															metro Detroit</td>
														<td class="td-actions text-right">
															<button type="button" rel="tooltip" title="Edit Task"
																class="btn btn-primary btn-link btn-sm">
																<i class="material-icons">edit</i>
															</button>
															<button type="button" rel="tooltip" title="Remove"
																class="btn btn-danger btn-link btn-sm">
																<i class="material-icons">close</i>
															</button>
														</td>
													</tr>
													<tr>
														<td>
															<div class="form-check">
																<label class="form-check-label"> <input
																	class="form-check-input" type="checkbox" value=""
																	checked> <span class="form-check-sign">
																		<span class="check"></span>
																</span>
																</label>
															</div>
														</td>
														<td>Sign contract for "What are conference organizers
															afraid of?"</td>
														<td class="td-actions text-right">
															<button type="button" rel="tooltip" title="Edit Task"
																class="btn btn-primary btn-link btn-sm">
																<i class="material-icons">edit</i>
															</button>
															<button type="button" rel="tooltip" title="Remove"
																class="btn btn-danger btn-link btn-sm">
																<i class="material-icons">close</i>
															</button>
														</td>
													</tr>-->
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<jsp:include page="core/footer.jsp"></jsp:include>
		</div>
	</div>


	<!--   Core JS Files   -->
	<script src="../assets/js/core/jquery.min.js"></script>
	<script src="../assets/js/core/popper.min.js"></script>
	<script src="../assets/js/bootstrap-material-design.js"></script>
	<script src="../assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
	<script src="../assets/js/plugins/bootstrap-notify.js"></script>

	<script>
		$(document).ready(function() {
			loadNewComplaints();
			loadPartiallyResolve();

		});
		
		function loadNewComplaints(){
			$.ajax({
				type : "POST",
				url : "/search_complaint",
				data : {complaintStatus : 'NEW'},
				success : function(result) {
					$("#tbody_newComplaints tr").remove();
					if(result != null){
						var html="<tr>";
						for(var i in result){
							console.log(i);
							html+="<td>"+
								"<div class=\"form-check\">"+
								"<label class=\"form-check-label\"> <input "+
								"class=\"form-check-input\" type=\"checkbox\" onclick=\"addCompaintToAccept('"+result[i].complaintId+"');\" value=\"'"+result[i].complaintId+"'\" >"+
								"<span class=\"form-check-sign\">"+
								"<span class=\"check\"></span>"+
								"</span>"+
								"</label>"+
								"</div>"+
								"</td>";
								
							html+="<td>"+result[i].complaintReference+"</td>";
							
							html+="<td>"+result[i].customerDto.customerNic+"</td>";
							
							html+="<td>"+result[i].complaintMessage+"</td>";
							
							html+="<td>"+result[i].complaintCreateDate+"</td>";
							
							
							html+="</tr>";
							
							$("#tbody_newComplaints").append(html);
							html="<tr>";
						}
						$("#tfoot_newComplaints button").remove();
						$("#tfoot_newComplaints").append("<button class=\"btn btn-blue pull-right\" onclick=\"acceptComplaints()\">ACCEPT</button>");
						
					}
					
				},
				error : function(result) {
					alert(result);
				}
			});
		}
		
		function loadPartiallyResolve(){
			$.ajax({
				type : "POST",
				url : "/search_complaint",
				data : {complaintStatus : 'PARTIALLY'},
				success : function(result) {
					$("#tbody_partiallyComplaints tr").remove();
					if(result != null){
						var html="<tr>";
						for(var i in result){
							console.log(i);
							
							html+="<td>"+result[i].complaintReference+"</td>";
							
							html+="<td>"+result[i].customerDto.customerNic+"</td>";
							
							html+="<td>"+result[i].complaintMessage+"</td>";
							
							html+="<td>"+result[i].complaintCreateDate+"</td>";
							
							
							html+="</tr>";
							
							$("#tbody_partiallyComplaints").append(html);
							html="<tr>";
						}
					}
					
				},
				error : function(result) {
					alert(result);
				}
			});
		}
		
		var complaintIdArr=[];
		
		function addCompaintToAccept(id){
			complaintIdArr.push(id);
		}
		
		function acceptComplaints(){
			$.ajax({
				type : "POST",
				url : "/accept_complaint",
				data : {complaints : complaintIdArr},
				traditional: true,
				success : function(result) {
					if(result == "200"){
						showNotification('bottom','right','success','Success');
						loadNewComplaints();
					}
				},
				error : function(result) {
					alert(result);
				}
			});
		}
		
		
		function showNotification(from, align,type,message) {
	        type = ['', 'info', 'danger','success', 'warning', 'rose', 'primary'];

	        color = Math.floor((Math.random() * 6) + 1);

	        $.notify({
	            icon: "notifications",
	            message: message

	        }, {
	            type: 'success',
	            timer: 3000,
	            placement: {
	                from: from,
	                align: align
	            }
	        });
	    }
		
	</script>
</body>


</html>