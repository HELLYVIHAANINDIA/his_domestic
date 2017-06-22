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
<h4 class="loogo">Cahoot Technologies</h4>
</div>
</div>
<div class="col-xl-3 header-right">
<div class="header-inner-right">
<div class="float-default searchbox">
<div class="right-icon">
<a href="javascript:void(0)">
<i class="fa fa-search icon_search" aria-hidden="true"></i>
</a>
</div>
</div>
<div class="float-default mail">
<div class="right-icon">
<a href="javascript:void(0)" data-toggle="dropdown" data-open="true" aria-expanded="true">
<i class="fa fa-envelope icon_mail_alt" aria-hidden="true"></i>
<span>10</span>
</a>
<div class="dropdown-menu messagetoggle" role="menu">
<div class="nav-tab-horizontal">
<ul class="nav nav-tabs" role="tablist">
<li class="nav-item">
<a class="nav-link active" data-toggle="tab" href="#messages" role="tab">Message</a>
</li>
<li class="nav-item">
<a class="nav-link" data-toggle="tab" href="#resendmessage" role="tab">Resend</a>
</li>
</ul>
</div>
<div class="tab-content">
<div class="tab-pane active" id="messages" role="tabpanel" data-plugin="custom-scroll" data-height="320">
<ul class="userMessagedrop">
<li>
<a href="#">
<div class="media">
<div class="media-body">
<h6>New tasks added</h6>
<p>Dummy text of the printing and typesetting industry.</p>
<div class="meta-tag text-nowrap">
<time datetime="2016-12-10T20:27:48+07:00" class="text-muted">5 mins
</time>
</div>
</div>
</div>
</a>
</li>
<li>
<a href="#">
<div class="media">
<div class="media-body">
<h6>Successfully</h6>
<p>Dummy text of the printing and typesetting industry.</p>
<div class="meta-tag text-nowrap">
<time datetime="2016-12-10T20:27:48+07:00" class="text-muted">5 mins
</time>
</div>
</div>
</div>
</a>
</li>
<li>
<a href="#">
<div class="media">
<div class="media-body">
<h6>Warnind</h6>
<p>Dummy text of the printing and typesetting industry.</p>
<div class="meta-tag text-nowrap">
<time datetime="2016-12-10T20:27:48+07:00" class="text-muted">5 mins
</time>
</div>
</div>
</div>
</a>
</li>
<li>
<a href="#">
<div class="media">
<div class="media-body">
<h6>Add new friend</h6>
<p>Dummy text of the printing and typesetting industry.</p>
<div class="meta-tag text-nowrap">
<time datetime="2016-12-10T20:27:48+07:00" class="text-muted">5 mins
</time>
</div>
</div>
</div>
</a>
</li>
</ul>
</div>
<div class="tab-pane" id="resendmessage" role="tabpanel" data-plugin="custom-scroll" data-height="320">
<ul class="userMessagedrop">
<li>
<a href="#">
<div class="media">
<div class="media-body">
<h6>5 new members joi...</h6>
<p>Dummy text of the printing and typesetting industry.</p>
<div class="meta-tag text-nowrap">
<time datetime="2016-12-10T20:27:48+07:00" class="text-muted">2 mins
</time>
</div>
</div>
</div>
</a>
</li>
<li>
<a href="#">
<div class="media">
<div class="media-body">
<h6>You changed...</h6>
<p>Dummy text of the printing and typesetting industry.</p>
<div class="meta-tag text-nowrap">
<time datetime="2016-12-10T20:27:48+07:00" class="text-muted">5 mins
</time>
</div>
</div>
</div>
</a>
</li>
<li>
<a href="#">
<div class="media">
<div class="media-body">
<h6>5 members removed</h6>
<p>Dummy text of the printing and typesetting industry.</p>
<div class="meta-tag text-nowrap">
<time datetime="2016-12-10T20:27:48+07:00" class="text-muted">15 mins
</time>
</div>
</div>
</div>
</a>
</li>
<li>
<a href="#">
<div class="media">
<div class="media-body">
<h6>Update available</h6>
<p>Dummy text of the printing and typesetting industry.</p>
<div class="meta-tag text-nowrap">
<time datetime="2016-12-10T20:27:48+07:00" class="text-muted">5 mins
</time>
</div>
</div>
</div>
</a>
</li>
</ul>
</div>
</div>
</div>
</div>
</div>
<div class="float-default chat">
<div class="right-icon">
<a href="javascript:void(0)" data-toggle="dropdown" data-open="true" data-animation="slideOutUp" aria-expanded="false">
<i class="fa fa-comments icon_chat_alt" aria-hidden="true"></i>
<span>8</span>
</a>
<ul class="dropdown-menu userChat">
<li>
<a href="#">
<div class="media">
<div class="media-body">
<h5>Judy Fowler</h5>
<p>Dummy text of the printing...</p>
<div class="meta-tag text-nowrap">
<time datetime="2016-12-10T20:27:48+07:00" class="text-muted">5 mins
</time>
</div>
<div class="status online"></div>
</div>
</div>
</a>
</li>
<li>
<a href="#">
<div class="media">
<div class="media-body">
<h5>Judy Fowler</h5>
<p>Dummy text of the printing...</p>
<div class="meta-tag text-nowrap">
<time datetime="2016-12-10T20:27:48+07:00" class="text-muted">2
hours
</time>
</div>
<div class="status offline"></div>
</div>
</div>
</a>
</li>
<li>
<a href="#">
<div class="media">
<div class="media-body">
<h5>Judy Fowler</h5>
<p>Dummy text of the printing...</p>
<div class="meta-tag text-nowrap">
<time datetime="2016-12-10T20:27:48+07:00" class="text-muted">20 Oct
</time>
</div>
<div class="status offline"></div>
</div>
</div>
</a>
</li>
<li>
<a href="#">
<div class="media">
<div class="media-body">
<h5>Judy Fowler</h5>
<p>Dummy text of the printing...</p>
<div class="meta-tag text-nowrap">
<time datetime="2016-12-10T20:27:48+07:00" class="text-muted">20 Oct
</time>
</div>
<div class="status online"></div>
</div>
</div>
</a>
</li>
</ul>
</div>
</div>
<div class="float-default chat">
<div class="right-icon">
<a href="#" data-plugin="fullscreen">
<i class="fa fa-arrows-alt arrow_expand" aria-hidden="true"></i>
</a>
</div>
</div>
<div class="user-dropdown">
<div class="btn-group">
<a href="#" class="user-header dropdown-toggle" data-toggle="dropdown" data-animation="slideOutUp" aria-haspopup="true" aria-expanded="false">
 <img src="${pageContext.request.contextPath}/resources/hospital/images/user.jpg" alt="Profile image"/> 
</a>
<div class="dropdown-menu drop-profile">
<div class="userProfile">
 <img src="${pageContext.request.contextPath}/resources/hospital/images/user.jpg" alt="Profile image"/>
<h5>username</h5>
<p>${sessionObject.userName}</p>
</div>
<div class="dropdown-divider"></div>
<a class="btn left-spacing link-btn" href="${pageContext.servletContext.contextPath}/user/getpasswordchange/${sessionScope.userId}/${sessionObject.userTypeId}" role="button">Change Password?</a>
<a class="btn btn-primary float-xs-right right-spacing" href="${pageContext.servletContext.contextPath}/submitlogout" role="button">Logout</a>
</div>
</div>
</div>
</div>
</div>
</div>

