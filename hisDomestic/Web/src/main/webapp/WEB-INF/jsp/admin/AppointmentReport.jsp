
<section id="content-wrapper">
 
<div class="site-content-title">
<div class="col-sm-6 col-xs-12"><h2 class="float-xs-left content-title-main pull-left">Appointment Report</h2></div>
<div class="col-sm-6 col-xs-12"><span class="small pull-right cm-field-up">All (*) marked Fields are mandatory</span></div>
</div>

<div class="content">

<div class="row">
<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
<div class="row">

<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
<div class="field-set-box">
<div class="form-group">
	<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12" id="drStartDate" >
					<div class="field-set-box">
						<label>Start Date</label>
						<div class="form-group">
							<input type="hidden" name="clientDateFormate"
								id="clientDateFormate" value='dd-MMM-yyyy'> <input
								type="text" class="form-control dateBox" name="txtstartDate"
								datepicker="yes" id="txtstartDate" datevalidate="lt:txtendDate"
								placeholder="dd-MMM-yyyy HH:mm" dtrequired="true"
								title="Start Date" onblur="doChangeForDateValidation(this)" value="">
						</div>

					</div>
				</div>
					<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12" id="drEndDate" >
					<div class="field-set-box">
						<label>End Date </label>
						<div class="form-group">
							<input type="hidden" name="clientDateFormate"
								id="clientDateFormate" value='dd-MMM-yyyy'> <input
								type="text" class="form-control dateBox" name="txtEndDate"
								datepicker="yes" id="txtEndDate" datevalidate="lt:txtendDate"
								placeholder="dd-MMM-yyyy HH:mm" dtrequired="true" onfocus="loadDatePicker(this,'lt','txtstartDate')"
								title="End Date" onblur="doChangeForDateValidation(this)" value="">
						</div>

					</div>
				</div>
</div>
</div>
</div>



</div>
</div>

<div class="col-xl-2 col-lg-2 col-md-2 col-sm-12 col-xs-12">
    <input type="submit" class="srcs" value="Search" onclick="getReport()">
</div>

<div class="clear"></div>
</div>
</div>
<div id="appoiintmentReport"></div>
</section>
</div>
</section>
 <script>
 
 
 $(".dateBox").each(function() {
		$(this).datetimepicker({
			format : 'd-M-Y H:i',
// 			maxDate : 0
		});
	});
 
 function getReport(){
	 var startdate =$("#txtstartDate").val();
	 var enddate = $("#txtEndDate").val();
		$.ajax({
			type: "POST",
		    url : contextPath+"/domestic/user/appointmentReport/"+startdate+"/"+enddate,
		    success:function(data){
		    	$("#appoiintmentReport").html("");
		    	$("#appoiintmentReport").html(data);
		    }
		
		})
	}

 </script>