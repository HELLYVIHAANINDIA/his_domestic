<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
			
				<div class="basic_table table-responsive">
				<form id="frmcancleAppointment" action="${pageContext.servletContext.contextPath}/domestic/user/cancleAppointment" method="post">
				<div class="patient-box">
					<div class="field-set-box"><label>Appointment Report</label></div>
					<table class="table table-bordered">
						<thead>
							<tr>
							   
								<th>CR No.</th>
								<th>Name</th>
								<th>DOB</th>
								<th>Age</th>
								<th>Mobile No.</th>
								<th>City</th>
								<th>Consulting Doctor</th>
								<th>Appointment Date & Time</th>
								<th>Status of Appointment</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${empty appointment}">
							<tr>
								<td colspan="10">
									<label><spring:message code="lbl_no_record_found" /></label>
								</td>
							</tr>								
							</c:if>
							<c:forEach items="${appointment}" var="appointment" varStatus="cnt">
								<tr>
								
									
									<td>${appointment.txtpatientcrno}</td>
									<td>${appointment.txtfirstname} ${appointment.txtmiddlename}  ${appointment.txtlastname}</td>
									<td><fmt:formatDate type="date" pattern="dd-MMM-yyyy"
											value="${appointment.txtbod}"></fmt:formatDate></td>
									<td>${appointment.txtage}</td>
									<td>${appointment.txtcountrycodemobileno}-${appointment.txtmobileno}</td>
									<td>${appointment.txtcity}</td>
									<td>${appointment.consltingDoctorName}</td>
<%-- 									<td><fmt:formatDate type="date" pattern="dd-MMM-yyyy HH:mm" --%>
<%-- 											value="${patient.appdatestring}"></fmt:formatDate></td> --%>
                                     <td>${appointment.appdatestring}</td>
                                     
                                     <td> <c:choose>
							 <c:when test="${appointment.appStatus eq 0}">
							     Pending
							 </c:when>
							  <c:when test="${appointment.appStatus eq 1}">
							       Aknowledge
							 </c:when>
							 <c:otherwise>
							           Cancel
							 </c:otherwise>
							 </c:choose>
                                    </td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</div>
					</form>	
				</div>
			


