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

<body onload="window.print();">
	<div class="wrapper" style="margin: 20px;">
		<h3 style="text-align: center;">Age Analysis Of Outstanding Complaints Report</h3>
		
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
              	  <th>Duration</th>
              	  <th>Complaints Outstanding</th>
              </tr>
           </thead>
           
           <tbody>
           	
           </tbody>
         </table>
         
         
         <div>This is a system generated report</div>
         <div>Printed Date : <%= new Date() %></div>
		
		
		
	</div>


	<!--   Core JS Files   -->
	<script src="../assets/js/core/jquery.min.js"></script>
	<script src="../assets/js/core/popper.min.js"></script>
	<script src="../assets/js/bootstrap-material-design.js"></script>
	<script src="../assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
	<script type="text/javascript"
		src="../assets/datatable/datatables.min.js"></script>
	<script src="../assets/js/bootstrap-datepicker.js"></script>
</body>


</html>