
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 <c:if test="${pageStatus eq 'Ackedit'}">
 	<%@include file="../includes/header.jsp"%>
 	<%@include file="../includes/AdminMenu.jsp"%>
</c:if> 

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/hospital/css/jquery.datetimepicker.css">
<script src="${pageContext.servletContext.contextPath}/resources/hospital/js/jquery.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/hospital/js/jquery.datetimepicker.js"></script>

<script type="text/javascript">
	$(function() {

		$("#selrefrence").change(function() {
			if ($(this).val() == "1") {
				$("#divref").show();
			} else {
				$("#divref").hide();
			}

		});
	});
	// Pay By
	$(function() {
		$("#selPayby").change(function() {
			if ($(this).val() == "1") {
				$("#divOther").show();
			} else {
				$("#divOther").hide();
			}
		});
	});
	//Addiction
	function addictionother(){
		if ($("#chk1").is(":checked")) {
			
			$("#divOtherAddictiob").show();
		} else {
			$("#divOtherAddictiob").hide();
		}
	
	}
	$(document)
			.ready(
					function() {
						//	var hdTabId = $("#hdTabId").val();
						//	$("#hdNewTabId").val(hdTabId);
						var pageStatus = '${pageStatus}';
						var patientcrno = '${patient.txtpatientcrno}';
						if (pageStatus != 'edit'){
							
							 var id = '${patientcount[0]}';
	                            id++;
	                           $("#txtpatientcrno").val(id);
						}else{
							 $("#txtpatientcrno").val(patientcrno);
						}
                       
						var caseSelect = '${selectTabId}';
						$("#appoinmentPatientTabId").val(caseSelect);
						if (caseSelect == 2) {
							appointmentval();
						}

						$(".dateBox").each(function() {
							$(this).datetimepicker({
								format : 'd-M-Y',
								maxDate : 0
							});
						});

						$(".dateBoxappointment").each(function() {
							$(this).datetimepicker({
								format : 'd-M-Y H:i',
								minDate : 0
							});
						});
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

		
						

						if (pageStatus == 'edit') {
							var countryId = '${patient.dtcountryId}';
							var stateId = '${patient.dtstateId}';
							var referenceId = '${patient.selreferenceid}';
							var socialeconomicId = '${patient.txtsocialeconomicstatusid}';
							var paybyid = '${patient.selpaybyid}';
							var consultingDoctorid = '${patient.consltingDoctorId}';
							var isdabitic = '${patient.rdisdiabetic}';
							var ishighbp = '${patient.rdishignbp}';
							var gender = '${patient.dtgender}';
							var addictionid = '${patientAddiction.addictionid}';
							var otherref = '${patient.refothersname}';
							var otherpay = '${patient.paybyname}';
							$("#txtpatientcrno").attr("disabled", "disabled");
							$("#txtfirstname").attr("disabled", "disabled");
							$("#txtregdate").attr("disabled", "disabled");
							$("#dtgender").attr("disabled", "disabled");
							$("#txtstartDate").attr("disabled", "disabled");
							$("#txtage").attr("disabled", "disabled");
							$("#selconsltingDoctor").attr("disabled","disabled");
							$("#divCancel").hide();
							$("#divappointment").show();
							

							$("#txtrefrenceDetail")
									.attr("disabled", "disabled");

							$('select[id="dtgender"] option:selected').attr(
									"selected", null);
							$(
									'select[id="dtgender"] option[value="'
											+ gender + '"]').attr("selected",
									"selected");

							$('select[id="selCountry"] option:selected').attr(
									"selected", null);
							$(
									'select[id="selCountry"] option[value="'
											+ countryId + '"]').attr(
									"selected", "selected");
							getState();

							$('select[id="selState"] option:selected').attr(
									"selected", null);
							$(
									'select[id="selState"] option[value="'
											+ stateId + '"]').attr("selected",
									"selected");

							getReferenceType();
							$('select[id="selrefrence"] option:selected').attr(
									"selected", null);
							$(
									'select[id="selrefrence"] option[value="'
											+ referenceId + '"]').attr(
									"selected", "selected");
							$("#selrefrence").attr("disabled", "disabled");
							if (referenceId == 1) {
								$("#divref").show();
								$("#txtotherRef").val(otherref);
							
							}

							getSocialEconomicStatus();
							$('select[id="selEconomic"] option:selected').attr(
									"selected", null);
							$(
									'select[id="selEconomic"] option[value="'
											+ socialeconomicId + '"]').attr(
									"selected", "selected");

							getPayby();
							$('select[id="selPayby"] option:selected').attr(
									"selected", null);
							$(
									'select[id="selPayby"] option[value="'
											+ paybyid + '"]').attr("selected",
									"selected");
							$("#selPayby").attr("disabled", "disabled");
							if (paybyid == 1) {
								$("#divOther").show();
								$("#txtother").val(otherpay);
								

							}
                                  
							getConsltingDoctor();
							$('select[id="selconsltingDoctor"] option:selected')
									.attr("selected", null);
							$(
									'select[id="selconsltingDoctor"] option[value="'
											+ consultingDoctorid + '"]').attr(
									"selected", "selected");
							if (isdabitic == 1) {

								$("#radio-button3").attr('checked', 'checked');
							} else {
								$("#radio-button4").attr('checked', 'checked');
							}
							if (ishighbp == 1) {
								$("#radio-button5").attr('checked', 'checked');
							} else {
								$("#radio-button6").attr('checked', 'checked');
							}
							 addictionother();
						} else {
							getState();
							getReferenceType();
							getPayby();
							getConsltingDoctor();
							getSocialEconomicStatus();
						}

						var appeditid = '${tabid}';
						$("#newAppointmenttabid").val(appeditid);
						if (appeditid == 7) {
							$("#txtrefrenceDetail").removeAttr("disabled");
							$("#selPayby").removeAttr("disabled");
							$("#selrefrence").removeAttr("disabled");
							$("#divappointment").show();
							$("#AppointmentTitle").text("Appointment New");
						}

						/* if (appeditid == 8) {
							$("#hdNewTabId").val(appeditid);

							appointmentval();

							$("#dtgender").attr("disabled", "disabled");
							$("#txtstartDate").attr("disabled", "disabled");
							$("#txtage").attr("disabled", "disabled");
							$("#txtcountrycodemobile").attr("disabled",
									"disabled");
							$("#txtmobileno").attr("disabled", "disabled");
							$("#txtstartDate").attr("disabled", "disabled");
							$("#selconsltingDoctor").attr("disabled",
									"disabled");
							$("#txtmiddlename").attr("disabled", "disabled");
							$("#txtlastname").attr("disabled", "disabled");
							$("#txtappdate").attr("disabled", "disabled");

						}
						if (appeditid == 9) {
							$("#hdNewTabId").val(appeditid);
							appointmentval();

							$("#dtgender").attr("disabled", "disabled");
							$("#txtstartDate").attr("disabled", "disabled");
							$("#txtage").attr("disabled", "disabled");
							$("#txtcountrycodemobile").attr("disabled",
									"disabled");
							$("#txtmobileno").attr("disabled", "disabled");
							$("#txtstartDate").attr("disabled", "disabled");
							$("#selconsltingDoctor").attr("disabled",
									"disabled");
							$("#txtmiddlename").attr("disabled", "disabled");
							$("#txtlastname").attr("disabled", "disabled");
							$("#txtappdate").attr("disabled", "disabled");

						}
 */
					});

	function validatePatient() {
		var pageStatus = '${pageStatus}';
		var appTabid = '${tabid}';
		var vbool = false;
		//	var hdTabId = $("#hdTabId").val();
		var caseSelect = '${selectTabId}';

		if (caseSelect == 2) {

			vbool = removeValidation();

		}
		/* vbool = removeValidation();
		alert(vbool); */
		vbool = valOnSubmit();
		if (vbool && pageStatus == "edit") {
			removeattribute();
			
		}
		
		return vbool;

	}
	function removeValidation() {
		var valids = $("#txtaddress").attr("validarr").split("@@");
		$("#txtaddress").removeAttr("validarr");
		$("#txtaddress").attr("validarr", getNewValidAttr(valids));

		valids = $("#txtcity").attr("validarr").split("@@");
		$("#txtcity").removeAttr("validarr");
		$("#txtcity").attr("validarr", getNewValidAttr(valids));

		$("#selCountry").removeAttr("isrequired");

		$("#selState").removeAttr("isrequired");
		return true;

	}
	function getNewValidAttr(valids) {
		var str;
		var newStr = "";
		for (var i = 0; i < valids.length; i++) {
			str = valids[i];
			if (str != 'required') {
				newStr = newStr + str;
				if (i != valids.length - 1) {
					newStr = newStr + "@@";
				}
			}
		}
		return newStr;
	}

	function removeattribute() {

		$("#txtpatientcrno").removeAttr("disabled");
		$("#selrefrence").removeAttr("disabled");
		
		$("#txtfirstname").removeAttr("disabled");
		$("#txtmiddlename").removeAttr("disabled");
		$("#txtlastname").removeAttr("disabled");
		$("#txtregdate").removeAttr("disabled");
		$("#dtgender").removeAttr("disabled");
		$("#txtstartDate").removeAttr("disabled");
		$("#txtage").removeAttr("disabled");
		$("#txtrefrenceDetail").removeAttr("disabled");
		$("#selPayby").removeAttr("disabled");
		$("#selEconomic").removeAttr("disabled");
		$("#txtcountrycodemobile").removeAttr("disabled");
		$("#txtmobileno").removeAttr("disabled");
		$("#txtstartDate").removeAttr("disabled");
		$("#selconsltingDoctor").removeAttr("disabled");
		$("#txtappdate").removeAttr("disabled");

	}

	function appointmentval() {
		$("#divregdate").hide();
		$("#divAddress").hide();
		$("#divLandmark").hide();
		$("#divArea").hide();
		$("#divCountry").hide();
		$("#divState").hide();
		$("#divCity").hide();
		$("#divPincode").hide();
		$("#idLandlineNO").hide();
		$("#divReferred").hide();
		$("#divreferredDetail").hide();
		$("#divStatus").hide();
		$("#divPayby").hide();
		$("#divDiabetic").hide();
		$("#divHighbp").hide();
		$("#divAddiction").hide();
		$("#divappointment").show();
	}
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
		$(":input[type='radio']").each(function(){
			$("input[type='radio']").prop('checked', true);
		});
		
		$(":input[type='checkbox']").each(function(){
			$('input:checkbox').removeAttr('checked');
		});
		
	}
</script>
	<c:if test="${pageStatus eq  'edit'}">
	<section id="content-wrapper">

			
	<div class="site-content-title">
		<div class="col-sm-6 col-xs-12"><h2 class="float-xs-left content-title-main pull-left">Patient Registration</h2></div>
		<div class="col-sm-6 col-xs-12"><span class="small pull-right cm-field-up">All (*) marked Fields are mandatory</span></div>
	</div>
	<div class="content">
	</c:if>
		<form action="${pageContext.servletContext.contextPath}/domestic/user/SavePatient" method="post" onsubmit="return validatePatient()">
			<input type="hidden" value="" id="appoinmentPatientTabId" name="appoinmentPatientTabId">
			<input type="hidden" value="" id="newAppointmenttabid" name="newAppointmenttabid">
			
				<div class="row">
					<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
						<div class="field-set-box">
							<label>Patient CR No. <span class="cm-field">*</span></label>
							<div class="form-group">
								<div class="input-group">
						       
						      
						           <span class="input-group-addon"><i
										class="fa fa-plus-square"></i></span> <input class="form-control" validarr="required"
										value="" type="text" title ="Patient CR NO" onblur="validateTextComponent(this)"
										id="txtpatientcrno" name="txtpatientcrno" validationmsg="Allows min 3 and max. 200 characters (',- , .,space)">
						      
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
						<div class="field-set-box">
							<label>First Name <span class="cm-field">*</span></label>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user"></i></span>
									<input class="form-control" value="${patient.txtfirstname}"
										type="text" id="txtfirstname" placeholder="Enter First Name"
										name="txtfirstname"
										onblur="javascript:{if(validateTextComponent(this));}"
										validarr="required@@alphabet@@length:3,100" tovalid="true"
										onblur="validateTextComponent(this)" title="First Name"
										validationmsg="Allows min 3 and max. 200 characters (',- , .,space)">
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
						<div class="field-set-box">
							<label>Middle Name</label>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user"></i></span>
									<input class="form-control" value="${patient.txtmiddlename}"
										type="text" placeholder="Enter Middle Name" id="txtmiddlename"
										name="txtmiddlename"
										onblur="javascript:{if(validateTextComponent(this));}"
										validarr="alphabet@@length:3,100"
										onblur="validateTextComponent(this)" title="Middle Name"
										validationmsg="Allows min 3 and max. 200 characters ">
								</div>
							</div>
						</div>
					</div>
				</div>
							
				<div class="row">
																
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="field-set-box">
						<label>Last Name <span class="cm-field">*</span></label>
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<input class="form-control" value="${patient.txtlastname}"
									type="text" placeholder="Enter Last Name" id="txtlastname"
									name="txtlastname"
									onblur="javascript:{if(validateTextComponent(this));}"
									validarr="required@@alphabet@@length:3,100" tovalid="true"
									onblur="validateTextComponent(this)" title="Last Name"
									validationmsg="Allows min 3 and max. 200 characters ">
							</div>
						</div>
					</div>
				</div>			
				
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12" id="divregdate">
					<div class="field-set-box">
						<label>Registration Date</label>
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
								<c:choose>
									<c:when test="${pageStatus eq 'edit'}">
										<input class="form-control" type="text"
											value="${patient.txtregdate}" title="Registration Date"
											id="txtregdate" name="txtregdate">
									</c:when>
									<c:otherwise>
										<input class="form-control" type="text" value="${currentDate}"
											title="Registration Date" id="txtregdate" name="txtregdate"
											readonly="readonly">
									</c:otherwise>
								</c:choose>

							</div>
						</div>
					</div>
				</div>

				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="field-set-box">
						<label>Gender <span class="cm-field">*</span></label>
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<select class="form-control" id="dtgender" name="dtgender"
									onblur="javascript:{if(validateTextComponent(this));}"
									validarr="required@@alphanumspecial@@length:3,200"
									tovalid="true" onblur="validateTextComponent(this)"
									title="Gender" isrequired="true"
									validationmsg="Allows min 3 and max. 200 characters and special character (',- , .,space)">
									<option selected="selected" disabled="disabled" value="0">
										Select Gender</option>
									<option value="Male">Male</option>
									<option value="Female">Female</option>
								</select>
							</div>
						</div>
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
								placeholder="dd-MMM-yyyy" title="Date of Birth"  
								onblur="calculateAge(this.value)" value="${patient.birthdate}">
						</div>

					</div>
				</div>

				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="field-set-box">
						<label>Age</label>
						<div class="form-group">
							<input class="form-control" value="${patient.txtage}" type="text"
								id="txtage" name="txtage">
						</div>
					</div>
				</div>
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12" id="divAddress">
					<div class="field-set-box">
						<label>Address <span class="cm-field">*</span></label>
						<div class="form-group">
							<input class="form-control" type="text" id="txtaddress"
								name="txtaddress"
								onblur="javascript:{if(validateTextComponent(this));}"
								validarr="required@@alphanumspecial@@length:3,200"
								tovalid="true" onblur="validateTextComponent(this)"
								title="Address" placeholder="Address"
								validationmsg="Allows min 3 and max. 200 characters and special character (',- , .,space)"
								value="${patient.txtaddress}">
						</div>
					</div>
				</div>
				
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12" id="divLandmark">
					<div class="field-set-box">
						<label>Landmark</label>
						<div class="form-group">
							<input class="form-control" value="${patient.txtlandmark}"
								type="text"
								onblur="javascript:{if(validateTextComponent(this));}"
								validarr="alphanum@@length:3,200" class="form-control"
								name="txtlandmark" title="LandMark" id="txtlandmark"
								validationmsg="Allows min 3 and max. 200 characters and Numeric ">
						</div>
					</div>
				</div>
				
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12" id="divArea">
					<div class="field-set-box">
						<label>Area</label>
						<div class="form-group">
							<input class="form-control" value="${patient.txtarea}"
								type="text" id="txtarea"
								onblur="javascript:{if(validateTextComponent(this));}"
								validarr="alphanum@@length:3,200"
								onblur="validateTextComponent(this)" class="form-control"
								name="txtarea" title="Area"
								validationmsg="Allows min 3 and max. 200 characters and Numeric">
						</div>
					</div>
				</div>
				
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12" id="divCountry">
					<div class="field-set-box">
						<label>Country <span class="cm-field">*</span></label>
						<div class="form-group">
							<select class="form-control" id="selCountry" name="selCountry"
								isrequired="true" onchange="if(validateCombo(this)){getState()}"
								title="Country" validationmsg="Select Country">
								<option selected="selected" disabled="disabled">Select
									Country</option>
							</select>
						</div>
					</div>
				</div>
				
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12" id="divState">
					<div class="field-set-box">
						<label>State<span class="cm-field">*</span></label>
						<div class="form-group">
							<select class="form-control" id="selState" name="selState"
								placeholder="State" isrequired="true"
								onchange="if(validateCombo(this)){}" title="State"
								validationmsg="Select State">
								<option selected="selected" disabled="disabled" value="0">Select
									State</option>
							</select>
						</div>
					</div>
				</div>
				
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12" id="divCity">
					<div class="field-set-box">
						<label>City <span class="cm-field">*</span></label>
						<div class="form-group">
							<input class="form-control" value="${patient.txtcity}"
								type="text" id="txtcity" name="txtcity"
								onblur="javascript:{if(validateTextComponent(this));}"
								validarr="required@@alphabet@@length:3,100" tovalid="true"
								onblur="validateTextComponent(this)" title="City"
								isrequired="true"
								validationmsg="Allows min 3 and max. 200 characters ">
						</div>
					</div>
				</div>
				
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12" id="divPincode">
					<div class="field-set-box">
						<label>Pincode</label>
						<div class="form-group">
							<input class="form-control" value="${patient.txtpincode}"
								type="text" id="txtpincode" name="txtpincode"
								onblur="javascript:{if(validateTextComponent(this));}"
								validarr="numeric@@length:6,6"
								onblur="validateTextComponent(this)" title="Pincode"
								validationmsg="Allows 6 digit " maxlength="6">
						</div>
					</div>
				</div>

				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="field-set-box">
						<label>Mobile No. <span class="cm-field">*</span></label>
						<div class="row">
							<div class="col-sm-4 col-xs-12">
								<div class="form-group">
									<input class="form-control"
										value="${patient.txtcountrycodemobileno}" type="text"
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
									<input class="form-control" value="${patient.txtmobileno}"
										type="text" placeholder="Mobile No. :" id="txtmobileno"
										name="txtmobileno"
										onblur="javascript:{if(validateTextComponent(this));}"
										validarr="required@@numeric@@length:10,10" tovalid="true"
										onblur="validateTextComponent(this)" title="Mobile Number"
										validationmsg="Allows 10 Numeric" maxlength="10">
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12" id="idLandlineNO">
					<div class="field-set-box">
						<label>Landline No.</label>
						<div class="row">
							<div class="col-sm-3 col-xs-12">
								<div class="form-group">
									<input class="form-control"
										value="${patient.txtcountrycodelandline}" type="text"
										placeholder="Country Code :" id="txtcountrycodelandline"
										onblur="javascript:{if(validateTextComponent(this));}"
										validarr="numeric@@length:2,2"
										onblur="validateTextComponent(this)" class="form-control"
										name="txtcountrycodelandline" title="Country Code"
										validationmsg="Allows 2 Numeric" maxlength="2">
								</div>
							</div>
							<div class="col-sm-6 col-xs-12">
								<div class="form-group">
									<input class="form-control" value="${patient.txtlandlineno}"
										type="text" placeholder="City Code" id="txtlandlineno"
										onblur="javascript:{if(validateTextComponent(this));}"
										validarr="numeric@@length:3,5"
										onblur="validateTextComponent(this)" class="form-control"
										name="txtlandlineno" title="City Code"
										validationmsg="Allows Minimum 3 Numbers" maxlength="5">
								</div>
							</div>
							<div class="col-sm-3 col-xs-12">
								<div class="form-group">
									<input class="form-control"
										value="${patient.txtextentionlandline}" type="text"
										placeholder="Lendline"
										onblur="javascript:{if(validateTextComponent(this));}"
										validarr="numeric@@length:5,10"
										onblur="validateTextComponent(this)" class="form-control"
										name="txtexentionlandline" title="Lendline"
										id="txtexentionlandline"
										validationmsg="Allows Minimum 5 Numbers" maxlength="10">
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12" id="divReferred">
					<div class="row">
						<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
							<div class="field-set-box">
								<label>Referred By</label>
								<div class="form-group">
									<select class="form-control" id="selrefrence"
										name="selrefrence">
										<option selected="selected" disabled="disabled" value="0">Select
											Referred By</option>
									</select>
								</div>
							</div>
						</div>
						<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
							<div class="field-set-box">
								<label></label>
								<div class="form-group" id="divref" style="display: none;">
									<input class="form-control" value="" type="text"
										name="txtotherRef" id="txtotherRef">
								</div>
							</div>
						</div>

					</div>
				</div>
				
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12" id="divreferredDetail">
					<div class="field-set-box">
						<label>Referred Details</label>
						<div class="form-group">
							<textarea class="form-control" type="text"
								placeholder="Referred Detail" id="txtrefrenceDetail"
								name="txtrefrenceDetail"
								onblur="javascript:{if(validateTextComponent(this));}"
								validarr="required@@alphabet@@length:3,100"
								onblur="validateTextComponent(this)" title="Referred Detail"
								validationmsg="Allows min 3 and max. 200 characters (',- , .,space)">${patient.txtreferencedetail}</textarea>
						</div>
					</div>
				</div>
				
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12" id="divStatus">
					<div class="field-set-box">
						<label>Social Economic Status</label>
						<div class="form-group">
							<select class="form-control" id="selEconomic" name="selEconomic">
								<option selected="selected" disabled="disabled" value="0">Select
									Social Economic Status</option>

							</select>
						</div>
					</div>
				</div>
				
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12" id="divPayby">
					<div class="row">
						<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
							<div class="field-set-box">
								<label>Pay By</label>
								<div class="form-group">
									<select class="form-control" id="selPayby" name="selPayby">
										<option selected="selected" disabled="disabled" value="0"> Select Pay
											By</option>

									</select>
								</div>
							</div>
						</div>
						<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
							<div class="field-set-box">
								<label></label>
								<div class="form-group" id="divOther" style="display: none;">
									<input id="txtother"
										onblur="javascript:{if(validateTextComponent(this));}"
										class="form-control" name="txtother"
										validarr="required@@alphabet@@length:3,100"
										onblur="validateTextComponent(this)" title="Other"
										validationmsg="Allows min 3 and max. 200 characters "
										type="text">
								</div>
							</div>
						</div>

					</div>
				</div>
				
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
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
				
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12" id="divDiabetic">
					<div class="row">
						<div class="col-xl-4 col-lg-4 col-md-4 col-sm-4 col-xs-12">
							<div class="field-set-box">
								<label>Diabetic Patient</label>
								<div class="radio-inline">
									<div class="radio-button">
										<input value="1" id="radio-button3" name="rdisDiabetic"
											type="radio"> <label for="radio-button3"></label> <span>&nbsp;Yes</span>
									</div>
									<div class="radio-button">
										<input value="0" id="radio-button4" name="rdisDiabetic"
											type="radio" checked="checked"> <label
											for="radio-button4"></label> <span>&nbsp;No</span>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-4 col-lg-4 col-md-4 col-sm-4 col-xs-12"
							id="divHighbp">
							<div class="field-set-box">
								<label>High B.P</label>
								<div class="radio-inline">
									<div class="radio-button">
										<input value="1" id="radio-button5" name="rdisHighbp"
											type="radio"> <label for="radio-button5"></label> <span>&nbsp;Yes</span>
									</div>
									<div class="radio-button">
										<input value="0" id="radio-button6" name="rdisHighbp"
											type="radio" checked="checked"> <label
											for="radio-button6"></label> <span>&nbsp;No</span>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
				
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12"id="divAddiction">
					<div class="row">
						<div class="col-xl-7 col-lg-7 col-md-12 col-sm-12 col-xs-12">
							<div class="field-set-box">
								<label>Addiction</label>
								
									<div class="checkbox-inline">
										<c:choose>
											<c:when test="${pageStatus eq 'edit'}">
												<c:set value="" var="checkedVar"/>
												<c:forEach var="addiction" items="${addictionMap}">
													<c:set var="addictionData" value="${fn:split(addiction.value, '@@@')}" />
													 <div class="checkbox-squared">
													 	<c:choose >
													 		<c:when test="${addictionData[1]  eq  'checked'}">
													 			<input value="${addiction.key}" id="chk${addiction.key}" name="chkaddiction" type="checkbox" checked="checked" onchange="addictionother()">
													 		</c:when>
															<c:otherwise>
													 			<input value="${addiction.key}" id="chk${addiction.key}" name="chkaddiction" type="checkbox" onchange="addictionother()">
													 		</c:otherwise>													 		
													 	</c:choose>
															<label for="chk${addiction.key}"></label> 
											 				<span>${addictionData[0]}</span>
													</div>
												 </c:forEach>
											</c:when>
											<c:otherwise>
												<c:forEach items="${addictionlist}" var="addiction">
													 <div class="checkbox-squared">
													 <input value="${addiction[0]}" id="chk${addiction[0]}" name="chkaddiction"
															type="checkbox"> 
															 <label for="chk${addiction[0]}"></label> 
													 <span>${addiction[1]}</span> 
													</div>
												 </c:forEach>
											</c:otherwise>
										</c:choose>
									</div>
								</div>

							</div>
						</div>
						<div class="col-xl-5 col-lg-5 col-md-12 col-sm-12 col-xs-12">
							<div class="field-set-box">
								<label></label>
								<div class="form-group" id="divOtherAddictiob" style="display: none;">
									<input id="txtotheraddiction"
										onblur="javascript:{if(validateTextComponent(this));}"
										class="form-control" name="txtotheraddiction"
										validarr="required@@alphabet@@length:1,100"
										onblur="validateTextComponent(this)" title="Other"
										validationmsg="Allows min 1 and max. 200 characters "
										type="text" value="${patient.addictionother}">
								</div>
							</div>
						</div>
					</div>
			</div>
			
			<div class="row">
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12" id="divappointment" style="display: none;">
					<div class="field-set-box">
						<label>Appointment Date & Time</label>
						<div class="form-group">
							<input type="hidden" name="txtappdate1" id="txtappdate1"
								value='dd-MMM-yyyy'> <input type="text"
								class="form-control dateBoxappointment" name="txtappdate"
								datepicker="yes" id="txtappdate" datevalidate="lt:txtendDate"
								placeholder="dd-MMM-yyyy HH:mm" title="Date of Birth"
								onblur="validateEmptyDt(this)" value="${patient.appdatestring}">
						</div>
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

				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12" id="divCancel">
					<button type="button" class="btn btn-primary cn btn-icon-hover fa fa-ban" onclick="cancelDetails()">
						<span>Cancel</span>
					</button>
				</div>

				<input type="hidden" value="${patient.patientId}" name="hdPatientId">
				<input type="hidden" value="${patient.userdetailid}" name="userDetailId"> 
				<input type="hidden" value="${patient.appid }" name="appointmentid" style="display: none;"> 
				<input type="hidden" value="${patient.referenceid}" name="refrenceid">
					</div>
		</form>

</div>
	
</section>

<script>
function calculateAge(birthDate){
	var date = new Date ($("#txtregdate").val());
	 var dob = new Date(birthDate);
	var year = date.getFullYear() - dob.getFullYear(); 
	var month = date.getMonth() - dob.getMonth(); 
	var date =  date.getDate() - dob.getDate();
	  if(month > 0 ){
		  $("#txtage").val(year);
	  }else if(month == 0){
		  if(date >= 0){
			  $("#txtage").val(year);
		  }else{
			  $("#txtage").val(year-1);
		  }
	  }
	  else{
		  $("#txtage").val(year-1);
	  }
}
</script>

<c:if test="${pageStatus eq 'Ackedit'}">
	<%@include file="../includes/footer.jsp"%>
</c:if>