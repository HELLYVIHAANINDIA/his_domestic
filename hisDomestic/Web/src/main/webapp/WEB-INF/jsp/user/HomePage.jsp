<%@include file="../includes/header.jsp"%>
<input type="hidden" value="${tabid}" name="hdTabId" id="hdTabId"/>
<input type="hidden" value="${issuperadmin}" name="hdsuperAdmin" id="hdsuperAdmin">
<input type="hidden" value="${hdPatientId}" name="hdPatientId" id="hdPatientId">
<input type="hidden" value="${userType}" name="hdUserTypeId" id="hdUserTypeId">
<c:choose>
	<c:when test="${issuperadmin}">
		<%@include file="../includes/SuperAdminMenu.jsp"%>
	</c:when>
	<c:otherwise>
		<c:choose>
			<c:when test="${userType eq 1}">
		 		<%@include file="../includes/AdminMenu.jsp"%> 
			</c:when>
			<c:when test="${userType eq 2}">
				<%@include file="../includes/UserMenu.jsp"%>
			</c:when>
		</c:choose>
	</c:otherwise>
	
</c:choose>
<section id="main" class="container-fluid">
	<div class="row">
		<section id="content-wrapper">
		</section>
	</div>
</section>
 <%@include file="../includes/footer.jsp"%> 