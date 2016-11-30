<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="icon" href="../../favicon.ico">
		<title>Music Online Shop</title>
		<!-- Bootstrap core CSS -->
		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
		<!-- Custom styles for this template -->
		<link href="<c:url value="/resources/css/carousel.css" />" rel="stylesheet">
		
		<!-- Main CSS -->
    	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    	
    	
    	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.0-rc.2/angular.min.js"></script>
    	
	</head>

	<body>
		<div class="navbar-wrapper">
		    <div class="container">
		        <nav class="navbar navbar-inverse navbar-static-top">
		            <div class="container">
		                <div class="navbar-header">
		                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
		                        <span class="sr-only">Toggle navigation</span>
		                        <span class="icon-bar"></span>
		                        <span class="icon-bar"></span>
		                        <span class="icon-bar"></span>
		                    </button>
		                    <a class="navbar-brand" href="#">My Music Store</a>
		                </div>
		                <div id="navbar" class="navbar-collapse collapse">
		                    <ul class="nav navbar-nav">
		                        <li class="active"><a href="<c:url value="/" />">Home</a></li>
		                        <li><a href="<c:url value="/product"/>">Product</a></li>
		                        <li><a href="#contact">Contact</a></li>

		                    </ul>
							<ul class="nav navbar-nav pull-right">
								<li class="dropdown">
									<%-- ${ pageContext.request.userPrincipal.name != null ? 'a' : 'b' } --%>
									<c:choose>
							           
							        	<c:when test="${ pageContext.request.userPrincipal.name != null }">
							           		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${ pageContext.request.userPrincipal.name } <span class="caret"></span></a>
							           		<ul class="dropdown-menu">
												<li><a href="<c:url value="/admin"/>">Admin Page</a></li>
												<li><a href="#">Another action</a></li>
												<li><a href="#">Something else here</a></li>
												<li role="separator" class="divider"></li>
												<li class="dropdown-header">Nav header</li>
												<li><a href="#">Separated link</a></li>
												<li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
											</ul>	
							           	</c:when> 
							           	<c:otherwise>
							           		<a href="${ pageContext.request.contextPath }/login" role="button">Login</a>
										</c:otherwise>   
							        </c:choose>		
									
									
									
								</li>
							</ul>
		                </div>
		            </div>
		        </nav>
		    </div>
		</div>
