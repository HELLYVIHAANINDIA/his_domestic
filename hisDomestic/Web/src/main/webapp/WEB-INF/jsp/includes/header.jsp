<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<head>
<meta charset="utf-8">
<meta name="description" content="bootstrap default admin template">
<meta name="viewport" content="width=device-width">

<title>Admin/Dashboard</title>
<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/hospital/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/hospital/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/hospital/css/color-default.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/hospital/css/components.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/hospital/css/elegant.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/hospital/css/font-awesome.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/hospital/css/layout.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/hospital/css/perfect-scrollbar.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/hospital/css/layout.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/hospital/css/simplemde.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/hospital/css/jquery.datetimepicker.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/hospital/css/switchery.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/hospital/css/jquery.alerts.css">
 
</head>
<body>

<div class="wrapper">
 
<header id="header">

<div class="header-width">
<div class="col-xl-9">
<div class="logo float-xs-left">
<h4 class="loogo">Vcure Medical Clinic</h4>
</div>
</div>
<div class="col-xl-3 header-right">
<div class="header-inner-right">
<div class="user-dropdown">
<div class="btn-group">
<a style="color: #fff;
    display: inline-block;
    float: left;
    font-size: 16px;
    margin-top: 7px;"><p>${sessionObject.userName}</p></a>
<a href="${pageContext.servletContext.contextPath}/submitlogout">
<%--  <img src="${pageContext.request.contextPath}/resources/hospital/images/user.jpg" alt="Profile image"/>  --%>
<i class="fa fa-power-off lg-out-bttn" aria-hidden="true"></i>
</a>
<div class="dropdown-menu drop-profile">
<div class="userProfile">

</div>
<div class="dropdown-divider"></div>
<%-- <a class="btn left-spacing link-btn" href="${pageContext.servletContext.contextPath}/user/getpasswordchange/${sessionScope.userId}/${sessionObject.userTypeId}" role="button">Change Password?</a> --%>
<a class="btn btn-primary float-xs-right right-spacing"  role="button">Logout</a>
</div>
</div>
</div>
</div>
</div>
</div>

