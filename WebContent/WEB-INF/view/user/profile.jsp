<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<c:url value="/user" var="user_url" />
<c:url value="/user/update/profile" var="update_profile_url" />
<c:url value="/user/update/password" var="update_password_url" />
<html>
<head>
<title>Spy</title>
<!-- Bootstrap -->
<link
  href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
  rel="stylesheet" media="screen">
<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
<script
  src="<%=request.getContextPath()%>/resources/js/jquery-1.9.1.min.js"></script>
<script
  src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<link
  href="<%=request.getContextPath()%>/resources/css/bootstrap-responsive.min.css"
  rel="stylesheet" media="screen">
</head>
<body>
  <div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
      <div class="container">
        <button type="button" class="btn btn-navbar"
          data-toggle="collapse" data-target=".nav-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="brand" href="<%=request.getContextPath()%>">Spy</a>
        <div class="nav-collapse collapse">
          <ul class="nav">
            <li class="active">
              <a href="<%=request.getContextPath()%>/user">User</a>
            </li>
            <li>
              <a href="<%=request.getContextPath()%>/mission">Mission</a>
            </li>
            <li>
              <a href="<%=request.getContextPath()%>/logout">Logout</a>
            </li>
          </ul>
        </div>
        <!--/.nav-collapse -->
      </div>
    </div>
  </div>
  <div class="container">
    <h1>${user.username } / ${user.alias }</h1>
    <br />
    <ul class="nav nav-tabs">
      <li class="active">
        <a href="#profile" data-toggle="tab">Profile</a>
      </li>
      <li>
        <a href="#password" data-toggle="tab">Password</a>
      </li>
      <li>
        <a href="#mission" data-toggle="tab">Mission</a>
      </li>
    </ul>
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="profile">
        <form id="tab1" method="post" action="${update_profile_url }">
          <label>Username</label>
          <input type="text" value="${user.username }"
            class="input-xlarge" disabled="disabled" >
          <label>First Name</label>
          <input type="text" value="${user.firstname }"
            class="input-xlarge" name="firstname">
          <label>Last Name</label>
          <input type="text" value="${user.lastname }"
            class="input-xlarge" name="lastname">
          <label>Alias</label>
          <input type="text" value="${user.alias }" class="input-xlarge"
            name="alias">
          <div>
            <br />
            <button class="btn btn-primary">Update</button>
          </div>
          <input type="hidden" name="username"  value="${user.username }"/>
        </form>
      </div>
      <div class="tab-pane fade" id="password">
        <form id="tab2" method="post" action="${update_password_url }">
          <label>Old Password</label>
          <input type="password" class="input-xlarge" name="old_password">
          <label>New Password</label>
          <input type="password" class="input-xlarge" name="new_password">
          <input type="hidden" name="username"  value="${user.username }"/>
          <div>
            <br />
            <button class="btn btn-primary">Update</button>
          </div>
        </form>
      </div>
      <div class="tab-pane fade" id="mission">
        <table class="table table-striped table-bordered " id="tab3">
          <caption>Assigned Mission</caption>
          <thead>
            <tr>
              <th>Name</th>
              <th>Description</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${missionList}" var="document"
              varStatus="row">
              <tr>
                <td>${document.missionName}</td>
                <td>${document.missionDescription}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
</body>
</html>