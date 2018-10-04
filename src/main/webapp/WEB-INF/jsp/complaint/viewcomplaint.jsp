<%@page import="org.arpicoinsurance.groupit.complaint.main.dto.ImageDto"%>
<%@page import="org.arpicoinsurance.groupit.complaint.main.dto.ComplaintStageDetailsDto"%>
<%@page import="org.arpicoinsurance.groupit.complaint.main.dto.ComplaintDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<link href="${path}/assets/assets-for-demo/demo.css" rel="stylesheet" />
	<!-- datatable -->
	<link rel="stylesheet" type="text/css" href="${path}/assets/datatable/datatables.min.css"/>
	<link href="${path}/assets/css/custom.css" rel="stylesheet" />
</head>

<body onload="">
	<div class="wrapper">
	<!-- sidebar start -->

		<jsp:include page="../core/sidebar.jsp">
			<jsp:param name="cur_page" value="Complaints" />
		</jsp:include>

		<!-- sidebar end -->



		<div class="main-panel">

			<!-- nav bar start -->

			<jsp:include page="../core/navbar.jsp">
				<jsp:param name="topic" value="View Complaint" />
			</jsp:include>


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
												<td><a href="" onclick="downloadFile('<%= imageDto.getImageId() %>')" ><i class="fa fa-paperclip" aria-hidden="true"></i> Attachment(<%= i %>)</a></td>
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
	<script src="${path}/assets/js/core/jquery.min.js"></script>
	<script src="${path}/assets/js/core/popper.min.js"></script>
	<script src="${path}/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>

	<script>
		
		function downloadFile(id){
			window.open("${path}/downloadFile/"+id ,"blank");
		}
		
		
	</script>
</body>


</html>