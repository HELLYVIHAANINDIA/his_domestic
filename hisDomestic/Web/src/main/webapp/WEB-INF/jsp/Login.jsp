<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
  
  <div id="login-main-wrapper">
  	<div class="container">
  		
  		<div class="row">
        	<div class="col-sm-12">
            	<center><img src="${pageContext.request.contextPath}/resources/hospital/images/logo.png" alt="V-Cure" style="margin-top:50px;"/></center>
            </div>
        </div>
  	
    	<div class="row">
        	<div id="login-wrapper">
            	<div class="col-sm-12">
            <c:if test="${not empty message}">
			<script>
				$(".alert-danger").html("");
				$(".alert-danger").hide();
			</script>
				<c:choose>
					<c:when test="${fn:contains(message, '_')}">
						<div class="alert alert-success">
							<spring:message code="${message}" />
						</div>
					</c:when>
					<c:otherwise>
						<div class="alert alert-success">${message}</div>
					</c:otherwise>
				</c:choose>
			</c:if>

			<c:if test="${not empty errorMsg}">
			<script>
				$(".alert-success").html("");
				$(".alert-success").hide();
			</script>
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
                	<div class="login-header">
                    	<h1>LOGIN</h1>
                    </div>             
                </div>
                <div class="col-sm-12 col-xs-12">
                    	<div class="login-container">
                    	<form name="formLogin" id="formLogin" action="${pageContext.servletContext.contextPath}/submitLogin" method="POST">
                        	<div class="row">
                            	<div class="col-xs-12">                               	
                					<span class="input input--chisato">
										<input class="input__field input__field--chisato" type='text' name='j_username' id="j_username" validarr="required@@email" tovalid="true" onblur="validateTextComponent(this)">
										<label class="input__label input__label--chisato" for="j_username">
											<span class="input__label-content input__label-content--chisato" data-content="Enter Username">Enter Username</span>
										</label>
									</span>
                                </div>
                                <div class="col-xs-12">
                                	<span class="input input--chisato">
										<input type='password' class="input__field input__field--chisato" name='j_password' id="j_password" validarr="required@@password@@checkloginidpwd:EmailId@@length:4,25" tovalid="true" onblur="validateTextComponent(this)" title="Password">
										<label class="input__label input__label--chisato" for="j_password">
											<span class="input__label-content input__label-content--chisato" data-content="Enter Password">Enter Password</span>
										</label>
									</span>
                                </div>
                                <div class="col-sm-6 col-xs-12">
<!--                                 	<a href="#" class="login-button">Login</a> -->
                                	 <input class="login-button" name="submit" value="Login" type="submit" onclick="return loginValidate()"/>
                                </div>
<%--                                 <div class="col-sm-6 col-xs-12"><a href="${pageContext.servletContext.contextPath}/getforgotpassword" class="forgot-password" data-toggle="modal" data-target="#forgot">Forgot Password?</a></div> --%>
                                
                                <!-- Modal -->
							  <div class="modal fade" id="forgot" role="dialog">
							    <div class="modal-dialog modal-md">
							      <div class="modal-content">
							        <div class="modal-header">
							          <button type="button" class="close" data-dismiss="modal">&times;</button>
							          <h4 class="modal-title"><a href="${pageContext.servletContext.contextPath}/getforgotpassword" >Forgot Password</a></h4>
							        </div>
							        <div class="modal-body">
							          <div class="row">
							          	<div class="col-xs-12">
							            	<label class="lbl-1">Enter Your Email</label>
							                <input type="email" class="form-control">
							            </div>
							          </div>
							        </div>
							        <div class="modal-footer">
							          <button type="button" class="btn btn-default">Submit</button>
							        </div>
							      </div>
							    </div>
							  </div>
							</div>
                           </form>     
                            </div>
                        </div>
                <div class="col-xs-12">
            	<div class="powered-by">Powered By : <a href="http://cahoot-technologies.com/" target="_blank"><span style="color:#c42b3d;">Cahoot</span> <span style="color:#205090;">Technologies</span></a></div>
            </div>
            </div>            
        </div>
    </div>
  </div><!--login-main-wrapper-->
  
  <script>
			(function() {
				// trim polyfill : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/Trim
				if (!String.prototype.trim) {
					(function() {
						// Make sure we trim BOM and NBSP
						var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
						String.prototype.trim = function() {
							return this.replace(rtrim, '');
						};
					})();
				}

				[].slice.call( document.querySelectorAll( 'input.input__field' ) ).forEach( function( inputEl ) {
					// in case the input is already filled..
					if( inputEl.value.trim() !== '' ) {
						classie.add( inputEl.parentNode, 'input--filled' );
					}

					// events:
					inputEl.addEventListener( 'focus', onInputFocus );
					inputEl.addEventListener( 'blur', onInputBlur );
				} );

				function onInputFocus( ev ) {
					classie.add( ev.target.parentNode, 'input--filled' );
				}

				function onInputBlur( ev ) {
					if( ev.target.value.trim() === '' ) {
						classie.remove( ev.target.parentNode, 'input--filled' );
					}
				}
			})();
		</script>
  
  <script>
			(function() {
				// trim polyfill : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/Trim
				if (!String.prototype.trim) {
					(function() {
						// Make sure we trim BOM and NBSP
						var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
						String.prototype.trim = function() {
							return this.replace(rtrim, '');
						};
					})();
				}

				[].slice.call( document.querySelectorAll( 'input.input__field' ) ).forEach( function( inputEl ) {
					// in case the input is already filled..
					if( inputEl.value.trim() !== '' ) {
						classie.add( inputEl.parentNode, 'input--filled' );
					}

					// events:
					inputEl.addEventListener( 'focus', onInputFocus );
					inputEl.addEventListener( 'blur', onInputBlur );
				} );

				function onInputFocus( ev ) {
					classie.add( ev.target.parentNode, 'input--filled' );
				}

				function onInputBlur( ev ) {
					if( ev.target.value.trim() === '' ) {
						classie.remove( ev.target.parentNode, 'input--filled' );
					}
				}
			})();
		</script>
  <script>
	  	var contextPath = "${pageContext.servletContext.contextPath}";
// 	  	var sessionUserId= ${sessionScope.userId};
	    var CLIENT_DATE_FORMATE='<spring:message code="client_dateformate_hhmm" />';
	    var CLIENT_DATE_FORMATE_WHM='<spring:message code="client_dateformate" />';
	    var VALIDATE_MSG_INVALID_PASSWORD = '<spring:message code="password_validation_msg" />';
  	</script>
	<script src="${pageContext.servletContext.contextPath}/resources/hospital/js/jquery.min.js"></script>
	<script src="${pageContext.servletContext.contextPath}/resources/hospital/js/bootstrap.min.js"></script>
	<script src="${pageContext.servletContext.contextPath}/resources/hospital/js/classie.js"></script>
	<script src="${pageContext.servletContext.contextPath}/resources/hospital/js/default.js"></script> 
	<script src="${pageContext.servletContext.contextPath}/resources/hospital/js/validationDefault.js"></script> 
	<script src="${pageContext.servletContext.contextPath}/resources/hospital/js/headerscript.js"></script> 
	<script src="${pageContext.servletContext.contextPath}/resources/hospital/js/classie.js"></script> 
	
  </body>
</html>