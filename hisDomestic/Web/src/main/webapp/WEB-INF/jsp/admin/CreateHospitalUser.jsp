<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
var lbl_pass_should_not_as_old = '<spring:message code="lbl_pass_should_not_as_old"/>';
	$(document).ready(function() {
		$("#successMsg").html($("#hdmessage").val());	
		var objectId = $('#txtobjectId').val();
		var childId = $('#txtChildId').val();
		var subChildId = $('#txtSubChildId').val();
		var otherSubChildId = $('#txtOtherSubChildId').val();
		var obj;

		if ('' != '${countryJson}') {
			obj = '${countryJson}';
			$('#selCountry').html('');
			$.each(JSON.parse(obj), function(key, value) {
				$('#selCountry').append($('<option>', {
					value : value.value,
					text : value.label
				}));

			});
		}
		getState();
		getDesignation();

		/* if ('' != '${designationJson}') {
			obj = '${designationJson}';
			$('#dtdesignationid').html('');
			$.each(JSON.parse(obj), function(key, value) {
				$('#dtdesignationid').append($('<option>', {
					value : value.value,
					text : value.label
				}));

			});
		} */
		
		if(''!='${userType}'){
			obj = '${userType}';
			$("#selUserRole").html('');
			$.each(JSON.parse(obj),function(key,value){
				$('#selUserRole').append($('<option>', {
					value : value.value,
					text : value.label
				}));
			});
		}
		$(".dateBox").each(function() {
			$(this).datetimepicker({
				format : 'd-M-Y',
				maxDate : 0
			});
		});
	});

	function validate() {
		if($("#dtdesignationid").val() == -1 && $("#hidOtherDesig").val() != " " ){
			$("#errorDesignation").html("Please Select Designation");
			
		}

		var vbool = valOnSubmit();
		
		
		if (vbool) {

			if ($("#txtconfpassword").val() != $("#txtpassword").val()) {
			   $("#error").html("Confirm password does not match with password.");
	 			vbool = false;

			}
		}
		return disableBtn(vbool);

	}
	
	

</script>

<section id="content-wrapper">
         
	<div class="site-content-title">
		<div class="col-sm-6 col-xs-12"><h2 class="float-xs-left content-title-main pull-left">Create User</h2>
		<div id="successMsg" style="display:inline-block; float:left; margin-top:10px; margin-left:50px; color:#006400;"></div>
		</div>
		<div class="col-sm-6 col-xs-12"><span class="small pull-right cm-field-up">All (*) marked Fields are mandatory</span></div>		 
	</div>
	
	<div class="content">
	
		<form action="${pageContext.servletContext.contextPath}/domestic/user/SaveCreateUser" method="post" onsubmit="return validate()">
			<div class="row">
			
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="field-set-box">
						<label>User Role <span class="cm-field">*</span></label>
						<div class="form-group">
							<select class="form-control" id="selUserRole" name="selUserRole"
								isrequired="true" onchange=validateCombo(this)"
								title="UserRole" validationmsg="Select UserRole">
							</select>
						</div>
					</div>
				</div>
                     	
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="field-set-box">
						<label>First Name <span class="cm-field">*</span></label>
						<div class="form-group">
							<input class="form-control" value="" type="text"
								id="txtfirstname" placeholder="Enter First Name"
								name="txtfirstname"
								onblur="javascript:{if(validateTextComponent(this));}"
								validarr="required@@alphabet@@length:3,100" tovalid="true"
								onblur="validateTextComponent(this)" title="First Name"
								validationmsg="Allows min 3 and max. 200 characters (',- , .,space)">
						</div>
						<span id="verifyFirstName" style="display: block; color: red"></span>
					</div>
				</div>

				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="field-set-box">
						<label>Middle Name </label>
						<div class="form-group">
							<input class="form-control" value="" type="text"
								placeholder="Enter Middle Name" id="txtmiddlename"
								name="txtmiddlename"
								onblur="javascript:{if(validateTextComponent(this));}"
								validarr="alphabet@@length:3,20" tovalid="true"
								onblur="validateTextComponent(this)" title="Middle Name"
								validationmsg="Allows min 3 and max. 20 characters ">
						</div>

					</div>
				</div>

				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="field-set-box">
						<label>Last Name <span class="cm-field">*</span></label>
						<div class="form-group">
							<input class="form-control" value="" type="text"
								placeholder="Enter Last Name" id="txtlastname"
								name="txtlastname"
								onblur="javascript:{if(validateTextComponent(this));}"
								validarr="required@@alphabet@@length:3,20" tovalid="true"
								onblur="validateTextComponent(this)" title="Last Name"
								validationmsg="Allows min 3 and max. 20 characters ">
						</div>
						<span id="verifyLastName" style="display: block; color: red"></span>
					</div>
				</div>

				<div class="clearfix"></div>

				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="field-set-box">
						<label>Gender <span class="cm-field">*</span></label>
						<div class="form-group">
							<select class="form-control" id="dtgender" name="dtgender"
								onblur="javascript:{if(validateTextComponent(this));}"
								validarr="required@@alphanumspecial@@length:3,200"
								onblur="validateTextComponent(this)"
								title="Gender"  isrequired="true"
								validationmsg="Allows min 3 and max. 200 characters and special character (',- , .,space)">
								<option disabled="disabled" selected="selected">Please
									select gender</option>
								<option>Male</option>
								<option>Female</option>
							</select>
						</div>
						<span id="verifyGender" style="display: block; color: red"></span>
					</div>
				</div>

				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="field-set-box">
						<label>Date Of Birth</label>
						<div class="form-group">
							<input type="hidden" name="clientDateFormate"
								id="clientDateFormate" value='dd-MMM-yyyy'> <input
								type="text" class="form-control dateBox" name="txtdateofbirth"
								datepicker="yes" id="txtstartDate" datevalidate="lt:txtendDate"
								placeholder="dd-MMM-yyyy"
								title="Date of Birth"  value="">
						</div>
					</div>
				</div>
				<div class="clearfix"></div>

				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="field-set-box">
						<label>E-mail ID <span class="cm-field">*</span></label>
						<div class="form-group">
							<input class="form-control" value="" type="text" id="txtloginid"
								validarr="required@@email" tovalid="true" name="txtloginid"
								onblur="javascript:{if(validateTextComponent(this)){checkDuplicateEmail();}}"
								title="Email ID"
								onblur="javascript:{if(validateTextComponent(this)){checkDuplicateEmail();}}">
							<span id="verifyMail" style="display: block; color: red"></span>
						</div>
					</div>
				</div>

				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="field-set-box">
						<label>Password <span class="cm-field">*</span></label>
						<div class="form-group">
							<input class="form-control" value="" type="password"
								id="txtpassword" name="txtpassword"
								onblur="javascript:{if(validateTextComponent(this));}"
								validarr="required@@alphanumspecial@@length:8,15" tovalid="true"
								onblur="validateTextComponent(this)" title="Password"
								validationmsg="Allows min 8 and max. 15 characters and special character (',- , .,space)">
						</div>
						<span id="verifyPassword" style="display: block; color: red"></span>
					</div>
				</div>

				<div class="clearfix"></div>

				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="field-set-box">
						<label>Confirm Password <span class="cm-field">*</span></label>
						<div class="form-group">
							<input class="form-control" value="" type="password"
								id="txtconfpassword" name="txtconfpassword"
								onblur="javascript:{if(validateTextComponent(this));}"
								validarr="required@@alphanumspecial@@length:8,15" tovalid="true"
								onblur="validateTextComponent(this)" title="Confirm Password"
								validationmsg="Allows min 8 and max. 200 characters and special character (',- , .,space)"
								maxlength="15">
						</div>
						<span id="verifyConfirmPassword"
							style="display: block; color: red"></span>
					</div>
				</div>
				<div id="error"></div>

				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="field-set-box">
						<label>Mobile No. <span class="cm-field">*</span></label>
						<div class="row">
							<div class="col-sm-4 col-xs-12">
								<div class="form-group">
									<input class="form-control" value="" type="text"
										placeholder="Country Code :" id="txtcountrycodemobile"
										name="txtcountrycodemobile"
										onblur="javascript:{if(validateTextComponent(this));}"
										validarr="required@@numeric@@length:2,2" tovalid="true"
										onblur="validateTextComponent(this)" title="Country Code"
										validationmsg="Allows 2 Numeric" maxlength="2">
								</div>
							</div>
							<div class="col-sm-8 col-xs-12">
								<div class="form-group">
									<input class="form-control" value="" type="text"
										placeholder="Mobile No. :" id="txtmobileno" name="txtmobileno"
										onblur="javascript:{if(validateTextComponent(this));}"
										validarr="required@@numeric@@length:10,10" tovalid="true"
										onblur="validateTextComponent(this)" title="Mobile Number"
										validationmsg="Allows 10 Numeric" maxlength="10">
								</div>
								<span id="verifyMobileno" style="display: block; color: red"></span>
							</div>
						</div>
					</div>
				</div>

				<div class="clearfix"></div>

				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="field-set-box">
						<label>Landline No.</label>
						<div class="row">
							<div class="col-sm-3 col-xs-12">
								<div class="form-group">
									<input class="form-control" value="" type="text"
										placeholder="Country Code :" id="txtcountrycodelandline"
										onblur="javascript:{if(validateTextComponent(this));}"
										validarr="numeric@@length:2,2" tovalid="true"
										onblur="validateTextComponent(this)" class="form-control"
										name="txtcountrycodelandline" title="Country Code"
										validationmsg="Allows 2 Numeric" maxlength="2">
								</div>
							</div>
							<div class="col-sm-6 col-xs-12">
								<div class="form-group">
									<input class="form-control" value="" type="text"
										placeholder="Landline No. :" id="txtlandlineno"
										onblur="javascript:{if(validateTextComponent(this));}"
										validarr="numeric@@length:3,5" tovalid="true"
										onblur="validateTextComponent(this)" class="form-control"
										name="txtlandlineno" title="Landline Number"
										validationmsg="Allows Minimum 3 Numbers" maxlength="5">
								</div>
							</div>
							<div class="col-sm-3 col-xs-12">
								<div class="form-group">
									<input class="form-control" value="" type="text"
										placeholder="Extension :"
										onblur="javascript:{if(validateTextComponent(this));}"
										validarr="numeric@@length:5,10" tovalid="true"
										onblur="validateTextComponent(this)" class="form-control"
										name="txtexentionlandline" title="Extention"
										id="txtexentionlandline" validationmsg="Allows Minimum 5 Numbers"
										maxlength="10">
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="field-set-box">
						<label>Address <span class="cm-field">*</span></label>
						<div class="form-group">
							<input class="form-control" value="" type="text" id="txtaddress"
								name="txtaddress"
								onblur="javascript:{if(validateTextComponent(this));}"
								validarr="required@@alphanumspecial@@length:3,200"
								tovalid="true" onblur="validateTextComponent(this)"
								title="Address" placeholder="Address"
								validationmsg="Allows min 3 and max. 200 characters and special character (',- , .,space)">
						</div>
						<span id="verifyAddress" style="display: block; color: red"></span>
					</div>
				</div>

				<div class="clear"></div>

				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="field-set-box">
						<label>Landmark</label>
						<div class="form-group">
							<input class="form-control" value="" type="text" id="txtlandmark"
								onblur="javascript:{if(validateTextComponent(this));}"
								validarr="alphanum@@length:3,200" class="form-control"
								name="txtlandmark" title="LandMark"
								validationmsg="Allows min 3 and max. 200 characters and Numeric ">
						</div>
					</div>
				</div>

				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="field-set-box">
						<label>Area</label>
						<div class="form-group">
							<input class="form-control" value="" type="text" id="txtarea"
								onblur="javascript:{if(validateTextComponent(this));}"
								validarr="alphanum@@length:3,200" tovalid="true"
								onblur="validateTextComponent(this)" class="form-control"
								name="txtarea" title="Area"
								validationmsg="Allows min 3 and max. 200 characters and Numeric">
						</div>
					</div>
				</div>

				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="field-set-box">
						<label>Country <span class="cm-field">*</span></label>
						<div class="form-group">
							<select class="form-control" id="selCountry" name="selCountry"
								isrequired="true" onchange="if(validateCombo(this)){getState()}"
								title="Country" validationmsg="Select Country">
							</select>
						</div>
					</div>
				</div>

				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="field-set-box">
						<label>State <span class="cm-field red">*</span></label>
						<div class="form-group">
							<select class="form-control" id="selState" name="selState"
								placeholder="State" onchange="if(validateCombo(this)){}" isrequired="true"
								title="State" validationmsg="Select State">
								<option value="">Select</option>
							</select>
						</div>
					</div>
				</div>

				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="field-set-box">
						<label>City <span class="cm-field">*</span></label>
						<div class="form-group">
							<input class="form-control" value="" type="text" id="txtcity"
								name="txtcity"
								onblur="javascript:{if(validateTextComponent(this));}"
								validarr="required@@alphabet@@length:3,100" tovalid="true"
								onblur="validateTextComponent(this)" title="City"
								isrequired="true"
								validationmsg="Allows min 3 and max. 200 characters ">
						</div>
					</div>
				</div>

				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="field-set-box">
						<label>Pincode</label>
						<div class="form-group">
							<input class="form-control" value="" type="text" id="txtpincode"
								name="txtpincode"
								onblur="javascript:{if(validateTextComponent(this));}"
								validarr="numeric@@length:6,6" tovalid="true"
								onblur="validateTextComponent(this)" title="Pincode"
								validationmsg="Allows 6 digit " maxlength="6">
						</div>
						<span id="verifyPincode" style="display: block; color: red"></span>
					</div>
				</div>

				<div class="clearfix"></div>

				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="field-set-box">
						<label>Designation</label><span class="cm-field">*</span>
						<div class="form-group">
							<select class="form-control" style="width: 95%; float: left;"
								onblur="javascript:{if(validateTextComponent(this));}"
								validarr="required" tovalid="true"
								onblur="validateTextComponent(this)" title="Designation"
								id="dtdesignationid" name="dtdesignationid" 
								validationmsg="Allows min 3 and max. 200 characters and special character (',- , .,space)" on>
								<option value="-1" >Select</option>
							</select> <i class="fa fa-plus add" aria-hidden="true" data-toggle="modal"
								data-target="#designation" id="toggledesignation" ></i>
							<div class="modal fade" id="designation" role="dialog">
								<div class="modal-dialog modal-md">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
										</div>
										<div class="modal-body">
											<div class="row">
												<div class="col-xs-12">
													<label class="lbl-1">Enter Designation</label> <input
														type="text" class="form-control" id="otherDedignation">
												</div>
											</div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default" data-dismiss="modal" onclick="saveDesignation()">Submit</button>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="dg" id="errorDesignation"></div>
					</div>
				</div>
                    <input type ="hidden" id="hidOtherDesig" name="hidOtherDesig" value="">
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="field-set-box">
						<label>Upload Photo : (Single file upload (JPG, JPEG, PNG)
							of size less than 2MB)</label>
						<div class="form-group">
							<input class="form-control" value="" id="fileToUpload" name="fileToUpload" type="file" style="width: 83%; float: left;">
						</div>
						<input type="hidden" id="txtobjectId" value="${objectId}"> <input
							type="hidden" id="txtChildId" value="${childId}"> <input
							type="hidden" id="txtSubChildId" value="${subChildId}"> <input
							type="hidden" id="txtOtherSubChildId" value="${otherSubChildId}">
						<input class="form-control" id="txtDocDesc" value="AdminUser"
							name="txtDocDesc" type="hidden">
						<button type="button" class="btn btn-default" onclick="return ajaxFileUpload();" style="float: right; height: 47px; margin-top: -16px; padding: 10px 20px;">
							<i class="fa fa-upload" aria-hidden="true"></i>					
							Upload
						</button>
					</div>
				</div>

			</div>

			<div class="row">
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<button type="submit"
						class="btn btn-primary sv btn-icon-hover fa fa-floppy-o">
						<span>Save</span>
					</button>
				</div>

				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<button type="button" class="btn btn-primary cn btn-icon-hover fa fa-ban" onclick="cancelDetails()">
						<span>Cancel</span>
					</button>
				</div>
			</div>
		</form>
	</div>
</section>

</div>
</section>
<script>
function cancelDetails(){
	
	$(":input[type='text']").each(function(){
		if(!$(this).is('[disabled=disabled]') && !$(this).is('[readonly=readonly]')){
			$(this).val('');
		} 
	});
	
	$(":selected").each(function(){
		if($(this).is('[disabled=disabled]')){
			$('select').prop('selectedIndex', 0); 
		}

	});
	/* $(":input[type='radio']").each(function(){
		$("input[type='radio']").prop('checked', true);
	});
	
	$(":input[type='checkbox']").each(function(){
		$('input:checkbox').removeAttr('checked');
	}); */
	
}
function saveDesignation() {

	var designation = $("#otherDedignation").val();
	$("#hidOtherDesig").val(designation);
	
	
	
}

</script>
