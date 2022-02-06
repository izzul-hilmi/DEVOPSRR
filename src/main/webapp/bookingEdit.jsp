
<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>User Management Application</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-light">
<div>
<a class="navbar-brand"> Booking Management </a>
</div>
<ul class="navbar-nav">
<li><a href="<%=request.getContextPath()%>/BookingServlet/dashboard"
class="nav-link">Back to Dashboard</a></li>
</ul>
</nav>
<div class="container col-md-6">
<div class="card">
<div class="card-body">
<c:if test="${booking != null}">
<form action="update" method="post">
</c:if>
<c:if test="${booking == null}">
<form action="insert" method="post">
</c:if>
<caption>
<h2>
<c:if test="${booking != null}">
Edit User
</c:if>
<c:if test="${booking == null}">
Add New User
</c:if>
</h2>
</caption>
<c:if test="${booking != null}">
<input type="hidden" name="oriName" value="<c:out value='${booking.username}' />" />
</c:if>
<fieldset class="form-group">
<label>User Name</label> <input type="text" value="<c:out value='${booking.username}' />" class="form-control" name="username" required="required">
</fieldset>
<fieldset class="form-group">
<label>Restaurant</label> <input type="text" value="<c:out value='${booking.restaurant}' />" class="form-control" name="restaurant" required="required">
</fieldset>
<fieldset class="form-group">
<label>Date</label> <input type="date" value="<c:out value='${booking.date}' />" class="form-control" name="date"  required="required">
</fieldset>
<fieldset class="form-group">
<label>Time</label> <input type="time" value="<c:out value='${booking.time}' />" class="form-control" name="time">
</fieldset>
<button type="submit" class="btn btn-success">Save</button>
</form>
</div>
</div>
</div>
</body>
</html>