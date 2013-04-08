<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
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

    <h1>Hello, Spy !!</h1>
    <p>
      Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam
      dapibus bibendum ligula, in lobortis magna mollis a. Maecenas
      semper justo at quam vestibulum vitae ultricies lorem vestibulum.
      Fusce facilisis aliquet eleifend. Quisque vulputate faucibus nibh
      id condimentum. Nam elementum placerat eros ut dictum. Sed ornare
      molestie sem et feugiat. Aliquam placerat aliquet vehicula.
      <br />
    </p>

  </div>
  <script
    src="<%=request.getContextPath()%>/resources/js/jquery-1.9.1.min.js"></script>
  <script
    src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>