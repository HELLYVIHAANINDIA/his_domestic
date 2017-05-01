<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/hospital/css/jquery.datetimepicker.css">
<script
		src="${pageContext.servletContext.contextPath}/resources/hospital/js/jquery.min.js"></script>
		<script
		src="${pageContext.servletContext.contextPath}/resources/hospital/js/jquery.datetimepicker.js"></script>
<script>
function cancleAppointment(hdAppointmentId){
	$("#hdAppointmentId").val(hdAppointmentId);
	$("#frmcancleAppointment").submit();
} 
function reseduleAppointment(hdAppointmentId)
{
	$("#hdAppointmentId").val(hdAppointmentId);
	$("#frmcancleAppointment").submit();
	}
function arrivedAppointment(patientId,hdAppointmentId){
   
	$("#hdAppointmentId").val(hdAppointmentId);
	$("#hdPatientid").val(patientId);
	$("#frmcancleAppointment").submit();
	
}
$(document).ready(function() {
	
	$(".dateBoxappointment").each(function(){
		
		$(this).datetimepicker({
			format:'d-M-Y H:i',
			minDate: 0
		});
	});
})
</script>
<section id="content-wrapper">
	<div class="site-content-title">
		<h2 class="float-xs-left content-title-main">User DashBoad</h2>
	</div>
		<div class="row">
       
			<div class="col-xs-12">
				<div class="basic_table table-responsive">
				<form id="frmcancleAppointment" action="${pageContext.servletContext.contextPath}/domestic/user/cancleAppointment" method="post">
					<table class="table table-bordered">
						<thead>
							<tr>
							   
								<th></th>
								<th>Case Type</th>
								<th>CR No.</th>
								<th>Date&Time</th>
								<th>Name</th>
								<th>DOB</th>
								<th>Age</th>
								<th>Mobile No.</th>
								<th>Consulting Doctor</th>
								<th>Appointment Date & Time</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${empty appointmentList}">
							<tr>
								<td colspan="10">
									<label><spring:message code="lbl_no_record_found" /></label>
								</td>
							</tr>								
							</c:if>
							<c:forEach items="${appointmentList}" var="appdata" varStatus="cnt">
								<tr>
								
									<td>
									 <c:if test="${appdata[11] eq 0}">
									<a href="#" class="tag square-tag tag-danger" data-toggle="modal" data-target="#bordermodal${appdata[12]}">Cancel</a>
									  	<div class="modal fade border-modal" id="bordermodal${appdata[12]}" tabindex="-1" role="dialog" aria-labelledby="bordermodal" aria-hidden="true">
											<div class="modal-dialog" role="document">
												<div class="modal-content">
													<div class="modal-body">
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>

														<h3>User</h3>
														<div>Are You sure Cancel User ${appdata[2]} ${appdata[3]} ?</div>
														<button type="button" class="btn btn-danger"
															data-dismiss="modal" onclick="#">Cancel </button>
														<button type="button" class="btn btn-success" data-dismiss="modal" data-toggle="modal" data-target="#appointmentCancle${appdata[12]}">Ok</button>
													</div>
												</div>
											</div>
										</div>
										
										
											<div class="modal fade" id="appointmentCancle${appdata[12]}" role="dialog">
												<div class="modal-dialog modal-md">
													<div class="modal-content">
														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal">&times;</button>
														</div>
														<div class="modal-body">
															<div class="row">
																<div class="col-xs-12">
																	<label class="lbl-1">Enter Reason for Cancellation </label> 
																	<input type="text" name="txtreason${appdata[12]}" value="" id="txtreason${appdata[12]}" class="form-control">
																	<input type="hidden" name="hdAppointmentId" value="" id="hdAppointmentId" class="form-control">
																</div>
															</div>
														</div>
														<div class="modal-footer">
															<button  type="button" class="btn btn-default"  onclick="cancleAppointment(${appdata[12]})">Submit</button> 
				
														</div>
													</div>
												</div>
											</div>
											
										
									
										<a href="#" class="tag square-tag tag-warning"data-dismiss="modal" data-toggle="modal" data-target="#appointmentReschedule${appdata[12]}">Reschedule</a>
										<div class="modal fade" id="appointmentReschedule${appdata[12]}" role="dialog" >
												<div class="modal-dialog modal-md">
													<div class="modal-content">
														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal">&times;</button>
														</div>
														<div class="modal-body">
															<div class="row">
																<div class="col-xs-12">
																	<label class="lbl-1">Enter Reschedule Date </label> 
																	  <input type="hidden" name="txtappdate1" id="txtappdate1" value='dd-MMM-yyyy'>
												         	<input type="text" class="form-control dateBoxappointment"
															name="txtappdate${appdata[12]}" datepicker="yes" id="txtappdate${appdata[12]}"
															datevalidate="lt:txtendDate"
															placeholder="dd-MMM-yyyy HH:mm" 
															title="Date of appointment" 
															onblur="validateEmptyDt(this)" value="<fmt:formatDate type="date" pattern="dd-MMM-yyyy HH:mm"
											value="${appdata[9]}"/>">
																	<input type="hidden" name="hdAppointmentId" value="" id="hdAppointmentId" class="form-control">
																</div>
															</div>
														</div>
														<div class="modal-footer">
															<button  type="button" class="btn btn-default"  onclick="reseduleAppointment(${appdata[12]})">Submit</button> 
				
														</div>
													</div>
												</div>
											</div>
										
										
										    <input type="hidden" id="hdPatientid" name="hdPatientid">
										    <input type="hidden" name="hdAppointmentId" value="" id="hdAppointmentId" class="form-control">
											<a href="#" class="tag square-tag tag-success" onclick="arrivedAppointment(${appdata[10]} , ${appdata[12]})">Arrived</a>
									   </c:if>
									</td>
									
									<td>${appdata[0]}</td>
									<td>${appdata[1]}</td>
									<td></td>
									<td>${appdata[2]} ${appdata[3]}</td>
									<td><fmt:formatDate type="date" pattern="dd-MMM-yyyy"
											value="${appdata[4]}"></fmt:formatDate></td>
									<td>${appdata[5]}</td>
									<td>${appdata[6]}  ${appdata[7]}</td>
									<td>${appdata[8]}</td>
									<td><fmt:formatDate type="date" pattern="dd-MMM-yyyy HH:mm"
											value="${appdata[9]}"></fmt:formatDate></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</form>	
				</div>
			</div>
			
		</div>
	      
</section>
