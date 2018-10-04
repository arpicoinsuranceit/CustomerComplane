<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<!-- Favicons -->
	<link rel="apple-touch-icon" href="${path}/assets/img/develop.gif">
	<link rel="icon" href="${path}/assets/img/develop.gif">
	<title>Customer Complaint System</title>
	<!--     Fonts and icons     -->
	<link rel="stylesheet" href="${path}/assets/css/font-awesome.min.css" />
	<link rel="stylesheet" href="${path}/assets/css/material-dashboard.css?v=2.0.0">
	
	<link href="${path}/assets/css/custom.css" rel="stylesheet" />

</head>
<body class="">
	<div class="wrapper">
		
		<jsp:include page="core/sidebar.jsp">
			<jsp:param name="cur_page" value="Dashboard"/>
		</jsp:include>
		
		<div class="main-panel">
			
			<jsp:include page="core/navbar.jsp">
				<jsp:param name="topic" value="Dashboard"/>
			</jsp:include>
			
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-3 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header card-header-blue card-header-icon">
									<div class="card-icon" id="blue-card" style="opacity: 0.5;">
										<i class="fa fa-bell-o" aria-hidden="true"></i>
									</div>
									<p class="card-category">New Complaints</p>
									<h3 class="card-title"><%= session.getAttribute("NEW") %></h3>
								</div>
								<div class="card-footer">
									<div class="stats">
										<i class="fa fa-refresh" aria-hidden="true"></i> Just Updated
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-3 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header card-header-danger card-header-icon">
									<div class="card-icon" style="background-color: #F26F21;opacity: 0.5;">
										<i class="fa fa-times-circle" aria-hidden="true"></i>
									</div>
									<p class="card-category">Not Resolved</p>
									<h3 class="card-title"><%= session.getAttribute("NOT RESOLVED") %></h3>
								</div>
								<div class="card-footer">
									<div class="stats">
										<i class="fa fa-exclamation-circle" aria-hidden="true"></i> Get Quick
										Action
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-3 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header card-header-blue card-header-icon">
									<div class="card-icon" style="background-color: #F26F21;opacity: 0.5;">
										<i class="fa fa-star-half-o" aria-hidden="true"></i>
									</div>
									<p class="card-category">Partially</p>
									<h3 class="card-title"><%= session.getAttribute("PARTIALLY RESOLVED") %></h3>
								</div>
								<div class="card-footer">
									<div class="stats">
										<i class="fa fa-refresh" aria-hidden="true"></i> Just Updated
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-3 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header card-header-info card-header-icon">
									<div class="card-icon" id="blue-card" style="opacity: 0.5;">
										<i class="fa fa-check-circle" aria-hidden="true"></i>
									</div>
									<p class="card-category">Fully Resolved</p>
									<h3 class="card-title"><%= session.getAttribute("FULLY RESOLVED") %></h3>
								</div>
								<div class="card-footer">
									<div class="stats">
										<i class="fa fa-refresh" aria-hidden="true"></i> Just Updated
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
													href="#profile" data-toggle="tab">
													<i class="fa fa-bell-o fa-1x" aria-hidden="true"></i> New
												</a></li>
												<li class="nav-item"><a class="nav-link"
													href="#messages" data-toggle="tab"> 
													<i class="fa fa-times-circle fa-1x" aria-hidden="true"></i> Not Resolved
														
												</a></li>
												<li class="nav-item"><a class="nav-link"
													href="#settings" data-toggle="tab"> 
													<i class="fa fa-star-half-o fa-1x" aria-hidden="true"></i> Partially
													
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
													
												</tbody>
												<tfoot id="tfoot_newComplaints">
												
												</tfoot>
												
											</table>
										</div>
										<div class="tab-pane" id="messages">
											<table class="table">
												<tbody id="tbody_notResolvedComplaints">
													
												</tbody>
											</table>
										</div>
										<div class="tab-pane" id="settings">
											<table class="table">
												<tbody id="tbody_partiallyComplaints">
													
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
	<script src="${path}/assets/js/core/jquery.min.js"></script>
	<script src="${path}/assets/js/core/popper.min.js"></script>
	<script src="${path}/assets/js/bootstrap-material-design.js"></script>
	<script src="${path}/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
	<script src="${path}/assets/js/plugins/bootstrap-notify.js"></script>

	<script>
		$(document).ready(function() {
			loadNewComplaints();
			loadPartiallyResolve();
			loadFullyResolve();
			loadNotResolve();

		});
		
		function loadNewComplaints(){
			$.ajax({
				type : "POST",
				url : "${path}/search_complaint",
				data : {complaintStatus : 'NEW'},
				success : function(result) {
					$("#tbody_newComplaints tr").remove();
					if(result != null){
						var html="<tr>";
						for(var i in result){
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
					showNotification('bottom','right','danger','Error');
				}
			});
		}
		
		function loadPartiallyResolve(){
			$.ajax({
				type : "POST",
				url : "${path}/search_complaint",
				data : {complaintStatus : 'PARTIALLY RESOLVED'},
				success : function(result) {
					$("#tbody_partiallyComplaints tr").remove();
					if(result != null){
						var html="<tr>";
						for(var i in result){
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
					showNotification('bottom','right','danger','Error');
				}
			});
		}
		
		function loadFullyResolve(){
			$.ajax({
				type : "POST",
				url : "${path}/search_complaint",
				data : {complaintStatus : 'FULLY RESOLVED'},
				success : function(result) {
					
					
				},
				error : function(result) {
					showNotification('bottom','right','danger','Error');
				}
			});
		}
		
		function loadNotResolve(){
			$.ajax({
				type : "POST",
				url : "${path}/search_complaint",
				data : {complaintStatus : 'NOT RESOLVED'},
				success : function(result) {
					$("#tbody_notResolvedComplaints tr").remove();
					if(result != null){
						var html="<tr>";
						for(var i in result){
							html+="<td>"+result[i].complaintReference+"</td>";
							
							html+="<td>"+result[i].customerDto.customerNic+"</td>";
							
							html+="<td>"+result[i].complaintMessage+"</td>";
							
							html+="<td>"+result[i].complaintCreateDate+"</td>";
							
							
							html+="</tr>";
							
							$("#tbody_notResolvedComplaints").append(html);
							html="<tr>";
						}
					}
					
				},
				error : function(result) {
					showNotification('bottom','right','danger','Error');
				}
			});
		}
		
		var complaintIdArr=[];
		
		function addCompaintToAccept(id){
			complaintIdArr.push(id);
		}
		
		function acceptComplaints(){
			if(complaintIdArr.length > 0){
				$.ajax({
					type : "POST",
					url : "${path}/accept_complaint",
					data : {complaints : complaintIdArr},
					traditional: true,
					success : function(result) {
						if(result == "200"){
							showNotification('bottom','right','success','Success');
							loadNewComplaints();
						}
					},
					error : function(result) {
						showNotification('bottom','right','danger','Error');
					}
				});
			}
			
		}
		
		
		function showNotification(from, align,type,message) {
	        type = ['', 'info', 'danger','success', 'warning', 'rose', 'primary'];

	        color = Math.floor((Math.random() * 6) + 1);

	        $.notify({
	            icon: "",
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