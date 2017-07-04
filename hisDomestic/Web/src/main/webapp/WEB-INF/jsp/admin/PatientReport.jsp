
<section id="content-wrapper">
 
<div class="site-content-title">
<div class="col-sm-6 col-xs-12"><h2 class="float-xs-left content-title-main pull-left">Clinical</h2></div>
<div class="col-sm-6 col-xs-12"><span class="small pull-right cm-field-up">All (*) marked Fields are mandatory</span></div>
</div>

<div class="content">

<div class="row">



		<div class="col-xl-4 col-lg-4 col-md-12 col-sm-12 col-xs-12">
					<div class="field-set-box">
						<label>Consulting Doctor <span class="cm-field">*</span></label>
						<div class="form-group">
							<select class="form-control" id="selconsltingDoctor"
								name="selconsltingDoctor" isrequired="true"
								validationmsg="Select Counsulting Doctor">
								<option selected="selected" disabled="disabled">Select
									Consulting Doctor</option>
							</select>
						</div>
					</div>
				</div>


<div class="col-xl-2 col-lg-2 col-md-2 col-sm-12 col-xs-12">
    <input type="submit" class="srcs" value="Search" onclick="getReport()">
</div>

<div class="col-sm-12 col-xl-12">
	<div id="patientReport"></div>
</div>

<div class="clear"></div>
</div>
</div>

</section>

 <script>

 $(".dateBox").each(function() {
		$(this).datetimepicker({
			format : 'd-M-Y',
			maxDate : 0
		});
	});
 
 var dateFieldObject = new Object();
 function getConsltingDoctor(){
		$.ajax({
			contentType : "application/json",
			url : contextPath+"/domestic/user/getConsltingDoctor",
			dataType: "json",
			async:false,
			success : function(data) {
				$("#selconsltingDoctor option").not(":first").remove();
				for(var i = 0; i <data.length;i++){
					$("#selconsltingDoctor").append("<option value='"+data[i][0]+"'>"+data[i][1]+"</option>");
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				  console.log(jqXHR+"------jqXHR");
		            console.log(textStatus+'------textStatus');
		            console.log(errorThrown+'-----errorThrown');
			},
		});
	}
	$(document).ready(function() {
		getConsltingDoctor();
	});
	function getReport(){
	 var drId =$("#selconsltingDoctor").val();
		$.ajax({
			type: "POST",
		    url : contextPath+"/domestic/user/patientReport/"+drId,
		    success:function(data){
		    	$("#patientReport").html("");
		    	$("#patientReport").html(data);
		    }
		
		})
	}
 </script>
