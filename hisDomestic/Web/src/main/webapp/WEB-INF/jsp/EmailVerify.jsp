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
<%@include file="./includes/leftaccordionWithOutLogin.jsp"%>

	<div class="content-wrapper" style="height: 100vh;">
	
	<section class="content-header">
			<h1>
				 Registration Confirmation
			</h1>
			
	</section>
	<section class="content">
			<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<div class="box">
					<c:if test="${not empty successMsg}">
                    		<div class="alert alert-success"><spring:message code="${successMsg}"/></div>
                    </c:if>
                    <c:if test="${not empty errorMsg}">
                    	<div class="alert alert-danger"><spring:message code="${errorMsg}"/></div>
                     </c:if>
					<div class="box-body">
							<div class="row">
								<div class="col-lg-12 col-md-12 col-xs-12">
									<div class="row">
										<div class="col-lg-12">
											<c:if test="${isEmailVerified eq 1}">
												<div class="form_filed">Your email account is already verified.</div>
											</c:if>
											<c:if test="${isEmailVerified eq 0}">
												<div class="form_filed">Your email account is verified successfully.</div>
											</c:if>
										</div>
									</div>
								</div>
							</div>
					</div>
			</div>	
			</div>
			</div>	
			</section>
	</div>
	<!--Body Part End-->
	</div>
</body>
</html>
