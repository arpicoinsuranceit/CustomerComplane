<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
 	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<!-- Favicons -->
	<link rel="apple-touch-icon" href="../assets/img/develop.gif">
	<link rel="icon" href="../assets/img/develop.gif">
	<title>Customer Complaint System</title>
	<!--     Fonts and icons     -->
	<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />
	<link rel="stylesheet" href="../assets/css/material-dashboard.css?v=2.0.0">
	<link href="../assets/assets-for-demo/demo.css" rel="stylesheet" />
	<!-- datatable -->
<link rel="stylesheet" type="text/css" href="../assets/datatable/datatables.min.css"/>
	<link href="../assets/css/custom.css" rel="stylesheet" />
</head>

<body class="">
	<div class="wrapper">
		
		<!-- sidebar start -->
		
		<jsp:include page="../core/sidebar.jsp">
			<jsp:param name="cur_page" value="Complaints"/>
		</jsp:include>
		
		<!-- sidebar end -->
		
		
		
		<div class="main-panel">
		
		<!-- nav bar start -->
		
		<jsp:include page="../core/navbar.jsp">
			<jsp:param name="topic" value="Complaints"/>
		</jsp:include>
		
		
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
            	    { "data": "edit" },
            	    { "data": "view" }
            	]
            });
        });
		
		function editComplaint(id){
			//alert(id);
			window.location.replace("/updatecomplaint/"+id);
		}
		
		function viewComplaint(id){
			//alert(id);
			window.location.replace("/viewcomplaint/"+id);
		}
	</script>
</body>


</html>