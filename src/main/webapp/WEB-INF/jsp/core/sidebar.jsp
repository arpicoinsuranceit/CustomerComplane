<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<meta charset="utf-8">
	<meta
		content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"
		name="viewport" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	<!-- Favicons -->
	<link rel="apple-touch-icon" href="${path}/assets/img/develop.gif">
	<link rel="icon" href="${path}/assets/img/develop.gif">
	<title>Customer Complaint System</title>
	<!--     Fonts and icons     -->
	<link rel="stylesheet" href="${path}/assets/css/font-awesome.min.css" />
	<link rel="stylesheet" href="${path}/assets/css/material-dashboard.css?v=2.0.0">
	
	<link href="${path}/assets/css/custom.css" rel="stylesheet" />
	<!-- iframe removal -->
</head>
<body>
	<div class="sidebar" data-color="ar-orange"
			data-background-color="white"
			data-image="${path}/assets/img/sidebar-1.jpg">


	<div class="logo">
				<a href="http://www.arpicoinsurance.com/"
					class="simple-text logo-normal"><img src="${path}/assets/img/logo.png"
					style="width: 75%; height: 100px;" alt="ARPICO INSURANCE"></a>
			</div>
			<div class="sidebar-wrapper">
				<ul class="nav">
				
					<c:choose>
					    <c:when test="${param.cur_page eq 'Dashboard'}">
					        <li class="nav-item active ">
							<a class="nav-link" href="${path}/home">
							<i class="fa fa-tachometer" aria-hidden="true"></i>
									<p>Dashboard</p>
							</a></li>
					    </c:when>
					    <c:otherwise>
					       	<li class="nav-item ">
							<a class="nav-link" href="${path}/home">
							<i class="fa fa-tachometer" aria-hidden="true"></i>
									<p>Dashboard</p>
							</a></li>
					    </c:otherwise>
					</c:choose>
					
					<c:choose>
					    <c:when test="${param.cur_page eq 'Complaints'}">
					        <li class="nav-item active">
								<a class="nav-link" href="${path}/complaint"> 
									<i class="fa fa-commenting" aria-hidden="true"></i>
									<p>Customer Complaints</p>
								</a>
							</li>
					    </c:when>
					    <c:otherwise>
					       	<li class="nav-item">
								<a class="nav-link" href="${path}/complaint"> 
									<i class="fa fa-commenting" aria-hidden="true"></i>
									<p>Customer Complaints</p>
								</a>
							</li>
					    </c:otherwise>
					</c:choose>
					
					<c:choose>
					    <c:when test="${param.cur_page eq 'Reports'}">
					        <li class="nav-item active"><a class="nav-link"
								href="${path}/report_main"> <i class="fa fa-bar-chart" aria-hidden="true"></i>
									<p>Reports</p>
							</a></li>
					    </c:when>
					    <c:otherwise>
					       	<li class="nav-item "><a class="nav-link"
								href="${path}/report_main"> <i class="fa fa-bar-chart" aria-hidden="true"></i>
									<p>Reports</p>
							</a></li>
					    </c:otherwise>
					</c:choose>
					
					
				</ul>
			</div>
		</div>
		
		
		
		<!--   Core JS Files   -->
	<script src="${path}/assets/js/core/jquery.min.js"></script>
	<script src="${path}/assets/js/core/popper.min.js"></script>
	<script src="${path}/assets/js/bootstrap-material-design.js"></script>
	<script src="${path}/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>

</body>
</html>