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
<body onload="loadCategory()">
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
			
		<% ComplaintDto complaintDto=(ComplaintDto)session.getAttribute("editComplaint"); %>
		
			<div class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header card-header-pri" style="background-color: #224099;opacity: 0.8;">
                                    <h3 class="card-title">Update Complaint</h3>
                                </div>
                                <div class="card-body">
                                    <form name="update_complaint_form" id="update_complaint_form" enctype='multipart/form-data'>
                                        <div class="row">
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Customer Name </label>
                                                    <input type="text" class="form-control" id="customerName" name="customerName" value=<%= complaintDto.getCustomerDto().getCustomerName() %> readonly> 
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Nic </label>
                                                    <input type="text" class="form-control" id="customerNic" name="customerNic" value=<%= complaintDto.getCustomerDto().getCustomerNic() %> readonly>
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Email</label>
                                                    <input type="email" class="form-control" id="customerEmail" name="customerEmail" value=<%= complaintDto.getCustomerDto().getCustomerEmail() %> readonly> 
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Mobile</label>
                                                    <input type="text" class="form-control" id="customerMobile" name="customerMobile" value=<%= complaintDto.getCustomerDto().getCustomerMobile() %> readonly>
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Reference (policy no)</label>
                                                    <input type="text" class="form-control" id="comRef" name="comRef" value=<%= complaintDto.getComplaintReference() %> readonly>
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Complaint Category </label>
                                                    <input class="form-control" id="comCategory" name="comCategory" value=<%= complaintDto.getCategoryDto().getCategoryName() %> readonly>
                                                    
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row">
                                        	<div class="col-md-4">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Subject </label>
                                                    <input type="text" class="form-control" id="comSubject" name="comSubject" value=<%= complaintDto.getComplaintSubject() %> readonly>
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Message</label>
                                                    <textarea class="form-control" id="comMessage" name="comMessage" readonly><%= complaintDto.getComplaintMessage() %></textarea>
                                                </div>
	                                        </div>
                                            <!-- <div class="col-md-4">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Attachment </label>
                                                    <div class="upload-image-preview1" style="width:100%;height: auto;background-color: lightgrey;border:1px dashed black;"> </div>
                                                </div>
                                            </div> -->
                                            
                                        </div>
                                        <div class="row">
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Complaint Status </label>
                                                    <select  class="form-control" id="comStatus" name="comStatus">
                                                    	<option value="FULLY RESOLVED">FULLY RESOLVED</option>
                                                    	<option value="PARTIALLY RESOLVED">PARTIALLY RESOLVED</option>
                                                    	<option value="NOT RESOLVED">NOT RESOLVED</option>
                                                    </select>
                                                </div>
                                            </div>
                                            
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Root Cause </label>
                                                    <input type="text" class="form-control" id="comRootCause" name="comRootCause">
                                                </div>
                                            </div>
                                            
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Action </label>
                                                    <input type="text" class="form-control" id="comAction" name="comAction">
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row">
                                        	<div class="col-md-4">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Complaint Stage </label>
                                                    <select class="form-control" id="comStage" name="comStage">
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Note</label>
                                                    <textarea class="form-control" id="comStageDesc" name="comStageDesc"></textarea>
                                                </div>
                                            </div>
                                            
                                            <div class="col-md-4">
                                                <div class="">
                                                    <label class="bmd-label-floating">Attachment </label>
                                                    <input type="file" name="attachment" id="attachment" multiple>
                                                </div>
                                                <div class="upload-image-preview" style="width:100%;height: auto;background-color: lightgrey;border:1px dashed black;"> </div>
                                            </div>
                                        </div>
                                        <button type="button" class="btn btn-blue pull-right" onclick="updateComplaint();">Update Complaint</button>
                                        <div class="clearfix"></div>
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
	<script src="../assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
	<script src="../assets/js/plugins/bootstrap-notify.js"></script>

	<script>
	
		var fileArr=[];
		
		$("input[name=attachment]").change(function (e) {
		    if (this.files && this.files[0]) {
		        
		        var files = e.target.files,
		        filesLength = files.length;
		      	for (var i = 0; i < filesLength; i++) {
		    	  
		        var f = files[i];
		        
	        	for (var j in fileArr){
	        		if(f.name == fileArr[j].name){
	        			alert("Already Exist.");
	        			return;
	        		}
	        	}
	        	
		        fileArr.push(f);
		        console.log(f);
		        
		        var fileReader = new FileReader();
		        
		        fileReader.onload = (function(e) {
		          var file = e.target;
		         console.log(file);
		          $("<span class=\"pip\" style=\"display: inline-block;\" id=\""+f.name+"\">" +
		            "<img class=\"imageThumb\" style=\"width:100px;height:100px;padding:5px;\" src=\"" + e.target.result + "\" title=\"" + f.name + "\"/>" +
		            "<br/><span class=\"remove\" onclick=\"removeImage('"+f.name+"')\" style=\"display: block;margin:5px;text-align: center;background-color: #224099;color: white;\">Remove</span>" +
		            "</span>").appendTo(".upload-image-preview");
		          
		          /*$(".remove").click(function(){
		            $(this).parent(".pip").remove();
		            console.log(f);
		            console.log(fileArr.indexOf(f));
		            fileArr.splice(fileArr.indexOf(f),1);
		          });*/
		          
		        });
		        
		        fileReader.readAsDataURL(f);
		      }
		    }
		});
		
		function removeImage(name){
			alert(name);
			for (var j in fileArr){
        		if(name == fileArr[j].name){
        			document.getElementById(name).setAttribute('style', 'display: none');
        			fileArr.splice(j,1);
        			
        			return;
        		}
        	}
		}
		
		
		function loadCategory(){
			$.ajax({
				type : "GET",
				url : "/view_stages",
				success : function(result) {
					var stages = document.getElementById('comStage');
					for(var i in result){
						console.log(result);
						stages.options.add(new Option(result[i].stageName, result[i].stageId));
					}
				},
				error : function(result) {
					
				}
			});
		}
		
		
		function updateComplaint(){
			var formData = new FormData($('#update_complaint_form')[0]);
			
			var count = 0;
			
			formData.delete("attachment");
			$.each(fileArr, function(i, file){
				console.log(i);
				formData.append("attachment",file);
			    count++;
			})
			
			console.log(fileArr);
			
			for (var pair of formData.entries()) {
			    console.log(pair[0]+ ', ' + pair[1]); 
			}
			
			$.ajax({
				type : "POST",
				url : "/update_complaint",
				data : formData,
				enctype: 'multipart/form-data',
				processData: false,
				contentType: false,
				cache: false,
				success : function(result) {
					
					if(result == 200){
						showNotification('bottom','right','success','Success');
						$('#update_complaint_form')[0].reset();
					}else{
						showNotification('bottom','right','warning','Fail');
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