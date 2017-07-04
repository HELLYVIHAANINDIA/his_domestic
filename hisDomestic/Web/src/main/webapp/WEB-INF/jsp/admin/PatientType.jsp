<script type="text/javascript">
function callpage(val){
	
        $.ajax({
			type: "POST",
			url: contextPath+"/domestic/user/getCaseType/1/"+val,
	// 		data: data,
			success: function success(result){
			
				 $("#patientRegistration").html("");
	 			 $("#patientRegistration").html(result);
				
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

<section id="content-wrapper">
			
	<div class="site-content-title">
		<div class="col-sm-6 col-xs-12"><h2 class="float-xs-left content-title-main pull-left">Patient Registration</h2></div>
		<div class="col-sm-6 col-xs-12"><span class="small pull-right cm-field-up">All (*) marked Fields are mandatory</span></div>
	</div>
			
	<div class="content">
	
		<div class="row">
			<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
				<div class="field-set-box">
					<div class="radio-inline">
						<div class="radio-button">
							<input value="1" id="radio-button1" name="radio" type="radio" onclick="callpage(this.value)" checked="checked"> 
							<label for="radio-button1"></label> <span>&nbsp;New</span>
						</div>
						<div class="radio-button">
							<input value="2" id="radio-button2" name="radio" type="radio" onclick="callpage(this.value)"> <label for="radio-button2"></label> <span>&nbsp;Followup</span>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	<div id="patientRegistration"></div>
            
