<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<html>
<head>
<title>Login</title>

<!-- Bootstrap -->
<link
  href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
  rel="stylesheet" media="screen" />
<link
  href="<%=request.getContextPath()%>/resources/css/bootstrap-responsive.min.css"
  rel="stylesheet" media="screen" />
<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-login {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-login .form-login-heading,.form-login .checkbox {
	margin-bottom: 10px;
}

.form-login input[type="text"],.form-login input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
</style>
</head>
<body>
  <div class="container">
    <form class="form-login" method="post"
      action="<c:url value="/j_spring_security_check" />">
      <h2 class="form-login-heading">Please Login</h2>
      <input type="text" class="input-block-level" name="j_username"
        placeholder="Username" />
      <input type="password" class="input-block-level"
        placeholder="Password" name="j_password" />
      <label class="checkbox">
        <input type="checkbox" value="remember-me"
          name="_spring_security_remember_me" />
        Remember me
      </label>
      <button class="btn btn-large btn-primary" type="submit">login</button>
    </form>
  </div>
  <script
    src="<%=request.getContextPath()%>/resources/js/jquery-1.9.1.min.js"></script>
  <script
    src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>