<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>Bootstrap Login Form</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<spring:url value="/resources/css/styles.css" var="styleCss"></spring:url>
<spring:url value="/resources/css/bootstrap.min.css" var="animatedCss"></spring:url>
<spring:url value="/resources/js/bootstrap.min.js" var="bootJss"></spring:url>

<link rel="stylesheet" href="${styleCss}">
<link rel="stylesheet" href="${animatedCss}">
    </head>
	<body>
<!--login modal-->
<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
  <div class="modal-content">
      <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">TBanque</button>
          <h1 class="text-center">Login</h1>
      </div>
      <div class="modal-body">
          <form class="form col-md-12 center-block"  action="j_spring_security_check" method="post">
            <div class="form-group">
              <input type="text" class="form-control input-lg" placeholder="username" name="j_username">
            </div>
            <div class="form-group">
              <input type="password" class="form-control input-lg" placeholder="Password" name="j_password">
           
            </div>
           
             <c:if test="${param.error != null }">
             <div class="text text-danger text-center">Utilisateur inconnu ou mot de passe erroné</div>
             </c:if>
            <div class="form-group">
              <button class="btn btn-primary btn-lg btn-block">Sign In</button>
              <span class="pull-right"></span>
            </div>
          </form>
      </div>
      <div class="modal-footer">
          <div class="col-md-12">
         
		  </div>	
      </div>
  </div>
  </div>
</div>
	<!-- script references -->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src="${bootJss}"></script>
	</body>
</html>