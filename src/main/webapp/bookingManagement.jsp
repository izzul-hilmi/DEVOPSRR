<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking List</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="row">
<div class="container">
<h3 class="text-center">List of Bookings</h3>
<hr>
<div class="container text-left">
<!-- Add new user button redirects to the register.jsp page -->
<a href="<%=request.getContextPath()%>/NewBooking.jsp" class="btn btn-success">Add New Booking</a>
</div>
<br>
<!-- Create a table to list out all current users information -->
<table class="table">
<thead>
<tr>
<th>Username</th>
<th>Restaurant</th>
<th>Time</th>
<th>Date</th>
<th>Actions</th>
</tr>
</thead>
<!-- Pass in the list of users receive via the Servlet response to a loop -->
<tbody>
<c:forEach var="booking" items="${listBooking}">
<!-- For each user in the database, display their information accordingly -->
<tr>
<td>
<c:out value="${booking.username}" />
</td>
<td>
<c:out value="${booking.restaurant}" />
</td>
<td>
<c:out value="${booking.date}" />
</td>
<td>
<c:out value="${booking.time}" />
</td>
<!-- For each user in the database, Edit/Delete buttons which invokes the edit/delete functions -->
<td>
<a href="edit?username=<c:out value='${booking.username}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
<a href="delete?username=<c:out value='${booking.username}' />">Delete</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>
</body>
</body>
</html>