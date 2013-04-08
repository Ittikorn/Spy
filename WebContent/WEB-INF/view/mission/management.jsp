<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<c:url value="/mission/create" var="create_url" />
<c:url value="/mission/delete" var="delete_url" />
<c:url value="/mission" var="mission_url" />
<c:url value="/user/profile" var="user_profile_url" />
<html>
<head>
<title>Mission</title>
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
				id : selected
			}, function() {
				window.location.href = "${mission_url}";
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
      <caption>Mission Information</caption>
      <thead>
        <tr>
          <th></th>
          <th>Name</th>
          <th>Description</th>
          <th>Spy</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${missionList}" var="document" varStatus="row">
          <tr>
            <td class="text-center">
              <input type="radio" name="selected_record"
                class='v_center' value="${document.missionID}" />
            </td>
            <td>${document.missionName}</td>
            <td>${document.missionDescription}</td>
            <td>
              <a href="${user_profile_url}?username=${document.username}">${document.username}</a>
            </td>
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
        <label for='create_username'>Name</label>
        <input type='text' id='create_name' name='name' />
        <label for='create_description'>Description</label>
        <textarea id='create_description' name='description' rows="3"></textarea>
        <label for='create_spy'>Spy</label>
        <select id='create_spy' name='username'>
          <c:forEach items="${userList}" var="document" varStatus="row">
            <option value="${document.username}">${document.username}
              / ${document.alias}</option>
          </c:forEach>
        </select>
      </fieldset>
      <input type='submit' class='btn' value='Submit' />
      <input type='button' class='btn' value='Cancel'
        id='canel_create_btn' />
    </form>
  </div>
</body>
</html>