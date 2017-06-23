<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<section id="content-wrapper">
	<div class="site-content-title">
		<h2 class="float-xs-left content-title-main">Patient Report</h2>
	</div>
		<div class="row">
       
			<div class="col-xs-12">
				<div class="basic_table table-responsive">
				<form id="frmcancleAppointment" action="${pageContext.servletContext.contextPath}/domestic/user/cancleAppointment" method="post">
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
							</tr>
						</thead>
						<tbody>
							<c:if test="${empty patient}">
							<tr>
								<td colspan="10">
									<label><spring:message code="lbl_no_record_found" /></label>
								</td>
							</tr>								
							</c:if>
							<c:forEach items="${patient}" var="patient" varStatus="cnt">
								<tr>
								
									
									<td>${patient.txtpatientcrno}</td>
									<td>${patient.txtfirstname} ${patient.txtmiddlename}  ${patient.txtlastname}</td>
									<td><fmt:formatDate type="date" pattern="dd-MMM-yyyy"
											value="${patient.txtbod}"></fmt:formatDate></td>
									<td>${patient.txtage}</td>
									<td>${patient.txtcountrycodemobileno}-${patient.txtmobileno}</td>
									<td>${patient.txtcity}</td>
									<td>${patient.consltingDoctorName}</td>
<%-- 									<td><fmt:formatDate type="date" pattern="dd-MMM-yyyy HH:mm" --%>
<%-- 											value="${patient.appdatestring}"></fmt:formatDate></td> --%>
                                     <td>${patient.appdatestring}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</form>	
				</div>
			</div>
			
		</div>
	      
</section>



