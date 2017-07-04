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

	<div class="row">
		<div class="col-xl-4 col-lg-4 col-md-4 col-sm-4 col-xs-12">
			<div class="field-set-box">
				<label>Search</label>
				<div class="form-group">
					<input class="form-control" value="" type="text" id="txtsearch" name="txtsearch">					
				</div>
			</div>
		</div>
		<div class="col-xl-4 col-lg-4 col-md-4 col-sm-4 col-xs-12">
			<button class="btn btn-primary sv btn-icon-hover fa fa-floppy-o" onclick="return searchPatient()" style="float:left;">
				<span>Search</span>
			</button>
		</div>									
	</div>
			
	<div id="viewRegister">
<%-- 			<%@include file="../admin/ViewPatientRegistrationDtl.jsp"%> --%>
	</div>
