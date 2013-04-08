<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<c:url value="/user/create" var="create_url" />
<c:url value="/user/delete" var="delete_url" />
<c:url value="/user" var="user_url" />
<c:url value="/user/profile" var="user_profile_url" />
<html>
<head>
<title>User</title>
<!-- Bootstrap -->
<link
  href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
  rel="stylesheet" media="screen">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.v_center {
	position: relative;
	top: -4px;
}

.text-center {
	text-align: center !important;
}
</style>

<script
  src="<%=request.getContextPath()%>/resources/js/jquery-1.9.1.min.js"></script>
<script
  src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<script>
	$(function() {
		toggleForms('hide');

		function toggleForms(id) {
			if (id == 'hide') {
				$('#create_container').hide();

			} else if (id == 'new') {
				$('#create_container').show();

			}
		}

		function toggleCrudButtons(id) {
			if (id == 'show') {
				$('#create_btn').removeAttr('disabled');
				$('#delete_btn').removeAttr('disabled');

			} else if (id == 'hide') {
				$('#create_btn').attr('disabled', 'disabled');
				$('#delete_btn').attr('disabled', 'disabled');
			}
		}

		function hasSelected() {
			var selected = $('input:radio[name=selected_record]:checked').val();
			if (selected == undefined) {
				alert('Select a record first!');
				return false;
			}

			return true;
		}

		function submitDeleteRecord() {
			var selected = $('input:radio[name=selected_record]:checked').val();

			$.post("${delete_url}", {
				username : selected
			}, function() {
				window.location.href = "${user_url}";
			});
		}

		$('#create_btn').click(function() {
			toggleForms('new');
			toggleCrudButtons('hide');
		});

		$('#canel_create_btn').click(function() {
			toggleForms('hide');
			toggleCrudButtons('show');
		});

		$('#delete_btn').click(function() {
			if (hasSelected()) {
				submitDeleteRecord();
			}
		});
	});
</script>
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
    <table class="table table-striped table-bordered " id="table_user">
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
            <td class="text-center">
              <input type="radio" name="selected_record"
                class='v_center' value="${document.username}" />
            </td>
            <td>
              <a
                href="${user_profile_url}?username=${document.username}">${document.username}
              </a>
            </td>
            <td>${document.alias}</td>
            <td>${document.firstname}</td>
            <td>${document.lastname}</td>
            <td>${document.authority.name}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <button id="create_btn" type="button" class="btn">Create</button>
    <button id="delete_btn" type="button" class="btn">Delete</button>
  </div>
  <div class="container" id='create_container'>
    <br />
    <form action="${create_url}" method="post">
      <fieldset>
        <legend>Create New Record</legend>
        <br />
        <label for='create_username'>Username</label>
        <input type='text' id='create_username' name='username' />
        <label for='create_password'>Password</label>
        <input type='password' id='create_password' name='password' />
        <label for='create_firstname'>First Name</label>
        <input type='text' id='create_firstname' name='firstname' />
        <label for='create_lastname'>Last Name</label>
        <input type='text' id='create_lastname' name='lastname' />
        <label for='create_alias'>Alias</label>
        <input type='text' id='create_alias' name='alias' />
      </fieldset>
      <input type='submit' class='btn' value='Submit' />
      <input type='button' class='btn' value='Cancel'
        id='canel_create_btn' />
    </form>
  </div>
</body>
</html>