<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>:: LOGIN ::</title>
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/hospital/css/name.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/hospital/css/login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/hospital/css/set2.css">
  </head>
  <body>
<div class="wrapper">
<%-- <%@include file="./includes/leftaccordionWithOutLogin.jsp"%> --%>

	<div class="content-wrapper" >
	<section class="content-header">
			<h1>
				Forgot Password
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
							<form action="${pageContext.servletContext.contextPath}/postforgotpassword" method="POST" onsubmit="return validate();" >
							<div class="row">
								<div class="col-lg-12 col-md-12 col-xs-12">
									<div class="row">
										<div class="col-lg-2">
											<div class="form_filed">Email Id :</div>
										</div>
										<div class="col-lg-5">
										<input class="form-control" id="emailId" name="emailId" validarr="required@@email" tovalid="true" onblur="javascript:validateTextComponent(this)" title="Email ID"  type="text">
											<div id="emailIdError" style="color: red"></div>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-12 col-md-12 col-xs-12">
									<div class="row">
										<div class="col-lg-2">
											<div class="form_filed"></div>
										</div>
										<div class="col-lg-5"><button type="submit"  class="btn btn-submit">Send</button></div>
										</div>
									</div>
								</div>
							
							</form>
					</div>
			</div>	
			</div>
			</div>	
			</section>
	</div>
	</div>
	 <script>
	  	var contextPath = "${pageContext.servletContext.contextPath}";
// 	  	var sessionUserId= ${sessionScope.userId};
	    var CLIENT_DATE_FORMATE='<spring:message code="client_dateformate_hhmm" />';
	    var CLIENT_DATE_FORMATE_WHM='<spring:message code="client_dateformate" />';
	    var VALIDATE_MSG_INVALID_PASSWORD = '<spring:message code="password_validation_msg" />';
  	</script>
	<script src="${pageContext.servletContext.contextPath}/resources/hospital/js/jquery.min.js"></script>
	<script src="${pageContext.servletContext.contextPath}/resources/hospital/js/bootstrap.min.js"></script>
	<script src="${pageContext.servletContext.contextPath}/resources/hospital/js/default.js"></script> 
	<script src="${pageContext.servletContext.contextPath}/resources/hospital/js/validationDefault.js"></script> 
	<script src="${pageContext.servletContext.contextPath}/resources/hospital/js/headerscript.js"></script> 
	
  </body>
</html>