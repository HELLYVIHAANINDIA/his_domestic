<script>
function searchAppointment() {
	 
	var search = $("#txtsearch").val();
	 $.ajax({
			type: "POST",
			url: contextPath+"/domestic/patient/searchAppointment/"+search,
			success: function success(result){
				$("#viewAppointment").html("");
	 			$("#viewAppointment").html(result);
			},
			error: function (xhr, ajaxOptions, thrownError) {
		        alert(xhr.status);
		        alert(thrownError);
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
						<button class="btn btn-primary sv btn-icon-hover fa fa-floppy-o" onclick="return searchAppointment()">
							<span>Search</span>
						</button>
					</div>
							</div>
						</div>
					</div>
					

						
					</div>
			
			</div>
			<div id="viewAppointment">
			
		<%-- 	<%@include file="../admin/ViewPatientRegistrationDtl.jsp"%>  --%>
		</div>

		</section>