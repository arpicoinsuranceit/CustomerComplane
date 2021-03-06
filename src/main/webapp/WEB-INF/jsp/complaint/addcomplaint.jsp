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
		
		<jsp:include page="../core/sidebar.jsp" ></jsp:include>
		
		<div class="main-panel">
			
		<jsp:include page="../core/navbar.jsp"></jsp:include>
		
			<div class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header card-header-pri" style="background-color: #224099;opacity: 0.8;">
                                    <h3 class="card-title">ADD COMPLAINT</h3>
                                </div>
                                <div class="card-body">
                                    <form name="add_complaint_form" id="add_complaint_form" enctype='multipart/form-data'>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Customer Name *</label>
                                                    <input type="text" class="form-control" id="customerName" name="customerName">
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Nic *</label>
                                                    <input type="text" class="form-control" id="customerNic" name="customerNic">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Email</label>
                                                    <input type="email" class="form-control" id="customerEmail" name="customerEmail">
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Mobile</label>
                                                    <input type="text" class="form-control" id="customerMobile" name="customerMobile">
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row">
                                        	<div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Reference * (policy no)</label>
                                                    <input type="text" class="form-control" id="polNo" name="polNo">
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Complaint Category *</label>
                                                    <select type="text" class="form-control" id="comCategory" name="comCategory">
                                                    </select>
                                                </div>
                                            </div>
                                            
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Subject *</label>
                                                    <input type="text" class="form-control" id="comSubject" name="comSubject">
                                                </div>
                                            </div>
                                            
                                            <div class="col-md-6">
                                                <div class="">
                                                    <label class="bmd-label-floating">Attachment </label>
                                                    <input type="file" name="attachment" id="attachment" multiple>
                                                </div>
                                                <div class="upload-image-preview" style="width:100%;height: auto;background-color: lightgrey;border:1px dashed black;"> </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Message</label>
                                                    <textarea class="form-control" id="comMessage" name="comMessage"></textarea>
                                                </div>
                                            </div>
                                        </div>
                                        <button type="button" class="btn btn-blue pull-right" onclick="sendComplaint();">Send Complaint</button>
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

	<script>
	
		$("input[name=attachment]").change(function (e) {
		    if (this.files && this.files[0]) {
		        
		        var files = e.target.files,
		        filesLength = files.length;
		      for (var i = 0; i < filesLength; i++) {
		    	  
		        var f = files[i];
		        console.log(f);
		        var fileReader = new FileReader();
		        
		        fileReader.onload = (function(e) {
		          var file = e.target;
		          console.log(file);
		          $("<span class=\"pip\" style=\"display: inline-block;\" >" +
		            "<img class=\"imageThumb\" style=\"width:100px;height:100px;padding:5px;\" src=\"" + e.target.result + "\" title=\"" + file.name + "\"/>" +
		            "<br/><span class=\"remove\" style=\"display: block;margin:5px;text-align: center;background-color: #224099;color: white;\">Remove</span>" +
		            "</span>").appendTo(".upload-image-preview");
		          
		          $(".remove").click(function(){
		            $(this).parent(".pip").remove();
		          });
		          
		        });
		        
		        fileReader.readAsDataURL(f);
		      }
		    }
		});
		
		
		function loadCategory(){
			$.ajax({
				type : "GET",
				url : "/view_category",
				success : function(result) {
					var category = document.getElementById('comCategory');
					for(var i in result){
						category.options.add(new Option(result[i].categoryName, result[i].categoryId));
					}
				},
				error : function(result) {
					
				}
			});
		}
		
		
		function sendComplaint(){
			alert("called send complaint..");
			//console.log($("#attachment").file.files[0]);
			
			var formData = new FormData($('#add_complaint_form')[0]);
			formData.append('attachment', $('input[type=file]')[0].files[0]); 
			
			console.log($('input[type=file]')[0].files[0]);
			
			$.ajax({
				type : "POST",
				url : "/send_complaint",
				data : formData,
				enctype: 'multipart/form-data',
				processData: false,
				contentType: false,
				cache: false,
				success : function(result) {
					alert(result);
				},
				error : function(result) {
					alert(result);
				}
			});
			
		}
		
	</script>
</body>


</html>