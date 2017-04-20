<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="now" class="java.util.Date" />
<%@include file="./includes/headerWithoutLogin.jsp"%>
<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
 <script src="${pageContext.servletContext.contextPath}/resources/js/jQuery/jquery.datetimepicker.js"></script>
 <spring:message code="lbl_important_message" var="lbl_important_message"/>
 <script type="text/javascript">
 function validate(){
 	var vbool = valOnSubmit();
 	return disableBtn(vbool);
 }
 </script>
</head>

<body class="skin-blue sidebar-mini">  
<div class="wrapper">
<%@include file="./includes/leftaccordion.jsp"%>

	<div class="content-wrapper">
	
	<section class="content-header">
		<h1>Change password</h1>
	</section>
	
				<section class="content">
				<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<c:if test="${not empty message}">
								<div class="alert alert-success">${message}</div>
							</c:if>
							<c:if test="${not empty param.successMsg}">
								<div class="alert alert-success">
											<spring:message code="${param.successMsg}" />
										</div>
							</c:if>
							<c:if test="${not empty successMsg}">
								<c:choose>
									<c:when test="${fn:contains(successMsg, '_')}">
										<div class="alert alert-success">
											<spring:message code="${successMsg}" />
										</div>
									</c:when>
									<c:otherwise>
										<div class="alert alert-success">${successMsg}</div>
									</c:otherwise>
								</c:choose>
							</c:if>
							<c:if test="${not empty errorMsg}">
								<c:choose>
									<c:when test="${fn:contains(errorMsg, '_')}">
										<div class="alert alert-danger">
											<spring:message code="${errorMsg}" />
										</div>
									</c:when>
									<c:otherwise>
										<div class="alert alert-danger">${errorMsg}</div>
									</c:otherwise>
								</c:choose>
							</c:if>
					<div class="box-body">
							<div class="row">
								<div class="col-lg-12 col-md-12 col-xs-12">
									<div class="row">
										<div class="col-lg-12">
												<div class="form_filed">Your password has been changed.To continue with
												 the application <a href="${pageContext.servletContext.contextPath}/etender/buyer/tenderListing" >Click here</a> 
												 or   <a href="${pageContext.servletContext.contextPath}/submitlogout" >Logout</a></div>
										</div>
									</div>
								</div>
							</div>
					</div>
			</div>	
			</div>	
			</section>
	
	</div>
</div>
	<!--Body Part End-->
</body>
</html>
