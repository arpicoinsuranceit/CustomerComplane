<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.arpicoinsurance.groupit.complaint.main.dto.CustomerComplaintReportDto"%>
<%@page import="java.util.List"%>
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
<link rel="apple-touch-icon" href="${path}/assets/img/develop.gif">
<link rel="icon" href="${path}/assets/img/develop.gif">
<title>Customer Complaint System</title>
<!--     Fonts and icons     -->
<link rel="stylesheet" href="${path}/assets/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="${path}/assets/css/material-dashboard.css?v=2.0.0">
<link href="${path}/assets/assets-for-demo/demo.css" rel="stylesheet" />
<!-- datatable -->
<link rel="stylesheet" type="text/css"
	href="${path}/assets/datatable/datatables.min.css" />
<link href="${path}/assets/css/custom.css" rel="stylesheet" />
</head>

<body onload="window.print();">
	<div class="wrapper" style="margin: 20px;">
		<h3 style="text-align: center;">Customer Complaints Report</h3>
		
		<hr>
		
		<table style="width: 100%;margin-bottom: 10px;">
			<tr>
				<th>From Date : <%= session.getAttribute("complaintReport_fromDate") %> </th>
				
				<th style="text-align: right;">To Date : <%= session.getAttribute("complaintReport_toDate") %> </th>
			</tr>
		</table>
		
		<% ArrayList<CustomerComplaintReportDto> complaintReportDtos=(ArrayList<CustomerComplaintReportDto>)session.getAttribute("comlaintReportdata");
			
		%> 
		
		<table class="table table-bordered" id="complaint_table" style="width:100%">
             <thead>
              <tr>
              	  <th rowspan="2">Complaint Category</th>
                  <th rowspan="2">Complaints outstanding at the beginning of the bi-annual period</th>
                  <th rowspan="2">Complaints received during the bi-annual period</th>
                   <th rowspan="1" colspan="3">Complaints closed during the bi-annual period</th>
                   <th rowspan="2">No. of complaints outstanding at the end of the period</th>
              </tr>
              <tr>
              	  <th rowspan="1">Fully Resolved</th>
                  <th rowspan="1">Partially Resolved</th>
                  <th rowspan="1">Not Resolved</th>
                  
              </tr>
           </thead>
           
           <tbody>
           	<% for(int i=0;i<complaintReportDtos.size();i++){%>
				<tr>
					<td><%= complaintReportDtos.get(i).getComplaintCategory()  %></td>
					<td><%= complaintReportDtos.get(i).getComOutAtBegining()  %></td>
					<td><%= complaintReportDtos.get(i).getComReceiDuringPeriod()  %></td>
					<td><%= complaintReportDtos.get(i).getComClosedFullyResolved()  %></td>
					<td><%= complaintReportDtos.get(i).getComClosedPartResolved()  %></td>
					<td><%= complaintReportDtos.get(i).getComClosedNotResolved()  %></td>
					<td><%= complaintReportDtos.get(i).getComOutAtEnd()  %></td>
				</tr>
				
			<% } %>
           </tbody>
         </table>
         
         
         <div>This is a system generated report .</div>
         <div>Printed Date : <%= new Date() %></div>
		
		
		
	</div>


	<!--   Core JS Files   -->
	<script src="${path}/assets/js/core/jquery.min.js"></script>
	<script src="${path}/assets/js/core/popper.min.js"></script>
	<script src="${path}/assets/js/bootstrap-material-design.js"></script>
	<script src="${path}/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
	<script type="text/javascript"
		src="${path}/assets/datatable/datatables.min.js"></script>
	<script src="${path}/assets/js/bootstrap-datepicker.js"></script>
</body>


</html>