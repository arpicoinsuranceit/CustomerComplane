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
		<h3 style="text-align: center;">Performance Report</h3>
		
		<hr>
		
		<table style="width: 100%;margin-bottom: 10px;">
			<tr>
				<th>From Date : </th>
				
				<th style="text-align: right;">To Date :  </th>
			</tr>
		</table>
		
		
		<table class="table table-bordered" id="complaint_table" style="width:100%">
             <thead>
              <tr>
              	  <th>Description</th>
              	  <th>Present Period</th>
              	  <th>Previous Period</th>
              </tr>
           </thead>
           
           <tbody>
           	
           </tbody>
         </table>
         
         
         <div>This is a system generated report</div>
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