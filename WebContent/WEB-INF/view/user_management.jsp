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
}
</style>
</head>
<body>
  <div class="container">
    <table class="table table-striped table-bordered ">
      <caption>Spy Information</caption>
      <thead>
        <tr>
          <th></th>
          <th>Username</th>
          <th>Alias</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Authority</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${userList}" var="document" varStatus="row">
          <tr>
            <td>
              <input type="checkbox" />
            </td>
            <td>${document.username}</td>
            <td>${document.alias}</td>
            <td>${document.firstname}</td>
            <td>${document.lastname}</td>
            <td>${document.authority.name}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
  <script
    src="<%=request.getContextPath()%>/resources/js/jquery-1.9.1.min.js"></script>
  <script
    src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>