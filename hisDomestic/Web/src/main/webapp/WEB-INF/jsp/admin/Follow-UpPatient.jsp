<script>
function searchPatient() {
	 
	var search = $("#txtsearch").val();
	
			 $.ajax({
				type: "POST",
				url: contextPath+"/domestic/patient/searchPatient/"+search,
				success: function success(result){
					$("#viewRegister").html("");
		 			$("#viewRegister").html(result);
				}
			}); 
	   
	    
	
}
</script>    
<section id="content-wrapper">

		

			<div class="content">
				

				<div class="row">
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
						<div class="field-set-box">
							<label>Search</label>
							<div class="form-group">
								<input class="form-control" value="" type="text" id="txtsearch" name="txtsearch">
								<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
						<button class="btn btn-primary sv btn-icon-hover fa fa-floppy-o" onclick="return searchPatient()">
							<span>Search</span>
						</button>
					</div>
							</div>
						</div>
					</div>
					

						
					</div>
			
			</div>
			<div id="viewRegister">
<%-- 			<%@include file="../admin/ViewPatientRegistrationDtl.jsp"%> --%>
		</div>

		</section>