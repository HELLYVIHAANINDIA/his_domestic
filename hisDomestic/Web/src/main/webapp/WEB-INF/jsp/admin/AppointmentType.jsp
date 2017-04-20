<script type="text/javascript">
function callpage(val){
		if(val==1){
			$("#AppointmentTitle").text("Appointment New");	
		}else if(val==2){
			$("#AppointmentTitle").text("Appointment Followup");	
		}
        $.ajax({
			type: "POST",
			url: contextPath+"/domestic/user/getCaseType/2/"+val,
	// 		data: data,
			success: function success(result){
			
				 $("#appointmentRegistration").html("");
	 			 $("#appointmentRegistration").html(result);
				
			},
	        error: function(e){
	        	alert(e.status);
	        }
		}); 
} 
$(document).ready(function() {
	callpage(1);
});

</script>
		<div id="content-wrapper">
			<div class="site-content-title">
				<h2 class="float-xs-left content-title-main"><label id="AppointmentTitle"></label></h2>
			</div>
			
				<div class="row">
					<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
						<div class="field-set-box">
<!-- 							<label>Appointment <span class="cm-field">*</span></label> -->
							<div class="radio-inline">
								<div class="radio-button">
									<input value="1" id="radio-button1" name="radio" type="radio" onclick="callpage(this.value)" checked="checked"> <label
										for="radio-button1"></label> <span>&nbsp;New</span>
								</div>
								<div class="radio-button">
									<input value="2" id="radio-button2" name="radio" type="radio" onclick="callpage(this.value)"> <label for="radio-button2"></label> <span>&nbsp;Followup</span>
								</div>
							</div>
						</div>
					</div>

			
			</div>
			<div id="appointmentRegistration">
			</div>
             
		</div>

