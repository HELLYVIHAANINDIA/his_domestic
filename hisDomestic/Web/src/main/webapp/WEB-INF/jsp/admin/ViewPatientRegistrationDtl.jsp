<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script>
function newAppointment(patientid) {
	
	
			$.ajax({
				type: "POST",
				url: contextPath+"/domestic/user/tabcontent/7/"+patientid,
				success: function success(result){
					/* $("#viewRegister").html("");
		 			$("#viewRegister").html(result); */
			}
			});
	    
	
}
 function bookApp(patientid){
	$("#hdPatientId1").val(patientid);
	$("#frmPatientView").submit();
} 
</script>

<section id="content-wrapper">
	<div class="site-content-title">
		<h2 class="float-xs-left content-title-main">Patient Registration
			- View</h2>
	</div>
	<div class="content">
		<h4 class="page-content-title b-bottom">
			<span class="small pull-right cm-field">All (*) marked Fields
				are mandatory</span>
			<div class="clear"></div>
		</h4>
		<div class="row">
			<div class="col-xs-12">
				<div class="basic_table table-responsive">
				<form id="frmPatientView" action="${pageContext.servletContext.contextPath}/domestic/user/dashboard" method="post">
					<table class="table table-bordered" id="tblpatient">
						<thead>
							<tr>
								
								<th>CR No.</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Registration Date</th>
								<th>Date of Birth</th>
								<th>Address</th>
								<th>Mobile NO</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${empty patientData}">
							<tr>
								<td colspan="7">
									<label ><spring:message code="lbl_no_record_found" /></label>
								</td>
							</tr>								
							</c:if>
							<c:forEach items="${patientData}" var="dtls">
								<tr>
									<%-- <td width="7%">
									<a
										href="${pageContext.servletContext.contextPath}/domestic/user/tabcontent/6/${dtls[0]}"
										class="tag square-tag tag-success">Edit</a> 
										<c:choose>
											<c:when test="${serchstatus ne 'search'}">
												<a href="#" class="tag square-tag tag-danger"
													data-toggle="modal" data-target="#bordermodal">De-Active</a>
											</c:when>
										</c:choose>

										<div class="modal fade border-modal" id="bordermodal"
											tabindex="-1" role="dialog" aria-labelledby="bordermodal"
											aria-hidden="true">
											<div class="modal-dialog" role="document">
												<div class="modal-content">
													<div class="modal-body">
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>

														<h3>Modal title</h3>
														<p>Are You sure De-Active User ${dtls[2]}?</p>
														<button type="button" class="btn btn-danger"
															data-dismiss="modal" onclick="#">Cancel</button>
														<button type="button" class="btn btn-success"
															data-dismiss="modal" onclick="deletePatient(${dtls[8]})">Ok</button>
													</div>
												</div>
											</div>
										</div></td> --%>
										
<%-- 									<td><a href="${pageContext.servletContext.contextPath}/domestic/user/tabcontent/7/${dtls[0]}" >${dtls[1]}</a></td> --%>
									<td>
										<input type="hidden" id="hdPatientId1" name="hdPatientId" value="">
										<button type="button" onclick="bookApp(${dtls[0]})">${dtls[1]}</button>
									</td>
									<td>${dtls[2]}</td>
									<td>${dtls[3]}</td>
									<td><fmt:formatDate type="date" pattern="dd-MMM-yyyy"
											value="${dtls[4]}"></fmt:formatDate></td>
									<td><fmt:formatDate type="date" pattern="dd-MMM-yyyy"
											value="${dtls[5]}"></fmt:formatDate></td>
									<td>${dtls[6]}</td>
									<td>${dtls[7]}</td>
								</tr>
								
							</c:forEach>
						</tbody>
					</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>