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
	<button class="srch-bttn" onclick="return searchAppointment()">
		<i class="fa fa-search" aria-hidden="true"></i>
		<span>Search</span>
	</button>
	</div>										
</div>
			
<div id="viewAppointment">			
	<%-- 	<%@include file="../admin/ViewPatientRegistrationDtl.jsp"%>  --%>
</div>
