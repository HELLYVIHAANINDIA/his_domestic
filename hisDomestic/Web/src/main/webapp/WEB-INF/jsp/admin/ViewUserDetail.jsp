<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script>
function deactiveuser(userid) {
	var search = '${search}';
			$.ajax({
				type: "POST",
				url: contextPath+"/domestic/patient/deActiveUser/"+userid+"/"+search,
				success: function success(result){
					$("#searchUser").html("");
		 			$("#searchUser").html(result);
			}
			});
	    
	
}
function activeuser(userid) {
	
	var search = '${search}';
			$.ajax({
				type: "POST",
				url: contextPath+"/domestic/patient/activeUser/"+userid+"/"+search,
				success: function success(result){
					$("#searchUser").html("");
		 			$("#searchUser").html(result);
			}
			});
	    
	
}
 function bookApp(userid){
	
 	$("#frmPatientView").submit();
} 
</script>

<div class="row">
	<div class="col-xs-12">
				<div class="basic_table table-responsive">
				<form id="frmPatientView" action="${pageContext.servletContext.contextPath}/domestic/user/dashboard" method="post">
					<table class="table table-bordered" id="tblpatient">
						<thead>
							<tr>
								
								<th></th>
								<th>Name</th>
								<th>Address</th>
								<th>Mobile NO</th>
								<th>Login Id</th>
								<th>Designation</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${empty userData}">
							<tr>
								<td colspan="7">
									<label ><spring:message code="lbl_no_record_found" /></label>
								</td>
							</tr>								
							</c:if>
							<c:forEach items="${userData}" var="dtls">
								<tr>
								
									 <td>      
										<input type="hidden" id="hduserid" name="hduserid" value="${dtls[0]}">
										 <button type="button" onclick="bookApp(${dtls[0]})">Edit</button>
										<c:choose>
										<c:when test="${dtls[8] eq 1}">
										 <button type="button" data-toggle="modal" data-target="#bordermodal${dtls[9]}">Deactive</button>
										 <div class="modal fade border-modal" id="bordermodal${dtls[9]}" tabindex="-1" role="dialog" aria-labelledby="bordermodal" aria-hidden="true">
											<div class="modal-dialog" role="dialog">
												<div class="modal-content">
													<div class="modal-body">
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>

														<h3>User</h3>
														<div>Are You sure Deactive ${dtls[1]} ${dtls[2]} ?</div>
														<button type="button" class="btn btn-danger"
															data-dismiss="modal" onclick="#">Cancel </button>
														<button type="button" class="btn btn-success" onclick="deactiveuser(${dtls[9]})">Ok</button>
													</div>
												</div>
											</div>
										</div>
										
										</c:when>
										<c:otherwise>
										 <button type="button" onclick="activeuser(${dtls[9]})">Active</button>
										</c:otherwise>
										</c:choose>
										
									</td>
									<td>${dtls[1]} ${dtls[2]}</td>
									<td>${dtls[4]}</td>
									<td>${dtls[5]}</td>
									<td>${dtls[6]}</td>
									<td>${dtls[7]}</td>
								</tr>
								
							</c:forEach>
						</tbody>
					</table>
					<input type="hidden" id="hdRecpPatFollowTabId" name="hdRecpPatFollowTabId" value="4">
					</form>
				</div>
			</div>
</div>
			