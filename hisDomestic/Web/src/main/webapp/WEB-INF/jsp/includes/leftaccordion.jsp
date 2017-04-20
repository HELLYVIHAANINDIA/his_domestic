<header class="main-header"> 

		<nav class="navbar navbar-static-top" role="navigation">
		 
		<!-- Sidebar toggle button-->
			<a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button"> 
			<span class="sr-only">Toggle navigation</span> </a> 
			<a onclick="window.location.href='${logourl}'" class="logo"> 
			<img src="${pageContext.servletContext.contextPath}/resources/images/bgi_logo.png" alt="Businessgateways International" />
			</a> 
			
			<c:if test="${sessionObject.userTypeId eq 2}">
      		<c:set var="logourl" value="${pageContext.servletContext.contextPath}/etender/bidder/bidderTenderListing" ></c:set>
      		</c:if>
      		
      		<c:if test="${sessionObject.userTypeId eq 1}">
 			<c:set var="logourl" value="${pageContext.servletContext.contextPath}/etender/buyer/tenderListing" ></c:set>
      		</c:if>
			
		<!-- Navbar Right Menu -->
			<div class="navbar-custom-menu">
			
			<c:choose>
      	 		<c:when test="${sessionObject.userTypeId eq 1}">
         		<c:set var="className" value="nav navbar-nav"/>
         		</c:when>
         		<c:when test="${sessionObject.userTypeId eq 1}">
         		<c:set var="className" value="navbar-nav"/>
         		</c:when>
         	</c:choose>
			
				<ul class="nav navbar-nav">
					
			    <c:choose>
            
            	<c:when test="${sessionScope.userId gt 0}">
            	
            	<c:if test="${sessionObject.userTypeId eq 2}">
            	
            	<li><a href="#"><spring:message code="lbl_last_login"/> : ${sessionObject.lastLoginDateTime}</a></li>
	            
	            <li>
	            <a href="${pageContext.servletContext.contextPath}/user/getpasswordchange/${sessionScope.userId}/${sessionObject.userTypeId}">Change password</a>
	            </li>
	            
	            <li><span class="default-profile"> <i class="fa fa-fw fa-user"></i> </span></li>
            	
            	<li>
            	<span class="welcome">Welcome </span>
	            <span class="company-name"><a href="${pageContext.servletContext.contextPath}/common/user/geteditbidder/${sessionObject.bidderId}/1">${sessionObject.fullName}</a>
	            </span>
	            </li>
	                    
	            <li>
	            <a href="${pageContext.servletContext.contextPath}/submitlogout" class="logout">
	            <span class="glyphicon glyphicon-log-out"></span> Logout
	            </a>
	            </li>
	            	
            	</c:if>
            	
            	<c:if test="${sessionObject.userTypeId eq 1}">
            	
            	<li><a href="">Last login : ${sessionObject.lastLoginDateTime}</a></li>
            	
            	<li><span class="default-profile"> <i class="fa fa-fw fa-user"></i> </span></li>
            	
            	<li>
            	<span class="welcome">Welcome </span>
				<span class="company-name">
				<a href="${pageContext.servletContext.contextPath}/common/user/geteditofficer/${sessionObject.officerId}/buyer">${sessionObject.fullName}</a>
				</span>
				</li>
				
				<li>
				<a href="${pageContext.servletContext.contextPath}/submitlogout" class="logout">
                <span class="glyphicon glyphicon-log-out"></span> Logout
                </a>
				</li>
				           		           	           		         	
            	</c:if>
            	</c:when>
            	</c:choose>
				</ul>
				
			</div>
			
		</nav> 
		
</header>
  
<script type="text/javascript">
	//$.noConflict();
    var pageContext = '${pageContext.servletContext.contextPath}';
</script>

<script type="text/javascript">
        /* function disableBtn(status){
            if(status){
                $("button[type='submit']").each(function(){               
                    $(this).attr('disabled',true);
                });
            }
            return status;
        }
    function validate(){
        var vbool = valOnSubmit();
        return disableBtn(vbool);
    } */
    
    function loginValidate(){
        var vbool = valOnSubmit();
        return disableBtn(vbool);
    }
</script>

<aside class="main-sidebar">

<section class="sidebar">
			
				<form action="#" method="get" class="sidebar-form">
					<div class="input-group">
						<input type="text" name="q" class="sdf"
							placeholder="Type Keyword..."> <span
							class="input-group-btn">
							<button type="submit" name="search" id="search-btn"
								class="btn btn-flat">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
				
				<ul class="sidebar-menu" style="height: 800px">
				
					<li class="header">OUR PRODUCTS</li>
					
					<c:if test="${sessionObject.userTypeId eq 1}">
					<li class="treeview">
						<a href="${pageContext.servletContext.contextPath}/common/user/notificationTab/${sessionObject.userId}/0">
							<i class="fa fa-envelope"></i><span> Notification <i class="fa fa-bell"></i> (<span id="notificationCount"></span>)</span>
						</a>
					</li>
					
					<li class="treeview"> 
					<a href="#">
						<i class="epro icon-admin"></i> <span>Administration</span>
						<span class="pull-right-container"><i class="fa fa-angle-left pull-right"></i></span>
					</a>
						<ul class="treeview-menu">
							<li class="active"><a href="${pageContext.servletContext.contextPath}/domestic/user/createuser"><i class="fa fa-circle-o"></i><spring:message code="lbl_create_user"/></a></li>
							<li class="active"><a href="${pageContext.servletContext.contextPath}/common/user/getmanageuser"><i class="fa fa-circle-o"></i><spring:message code="lbl_manage_user"/></a></li>
						<li class="active"><a href="${pageContext.servletContext.contextPath}/domestic/user/patientRegistation"><i class="fa fa-circle-o"></i><spring:message code="lbl_patient_registration"/></a></li>
						</ul>
						<li class="active"><a href="${pageContext.servletContext.contextPath}/domestic/user/appointment"><i class="fa fa-circle-o"></i><spring:message code="lbl_patient_appointment"/></a></li>
						</li>
						
					</c:if>
				</ul>

</section>

</aside>