<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
crossorigin="anonymous">

</head>
<body>
<a href="<%=request.getContextPath()%>/UserServlet">User</a>
<br>
<a href="<%=request.getContextPath()%>/CommentServlet/dashboard">Reviews</a>
<br>
<a href="<%=request.getContextPath()%>/BookingServlet/dashboard">Bookings</a>

<div class="row">
<div class="container">
<h3 class="text-center">List of Restaurants</h3>
<hr>
<div class="container text-left">
<!-- Add new user button redirects to the register.jsp page -->
<a href="<%=request.getContextPath()%>/register.jsp" class="btn btn-success">Add New Restaurant</a>
</div>
<br>
<!-- Create a table to list out all current users information -->
<table class="table">
<thead>
<tr>
<th>Name</th>
<th>Hotline</th>
<th>Address</th>
<th>Actions</th>
</tr>
</thead>
<!-- Pass in the list of users receive via the Servlet response to a loop
-->
<tbody>
<c:forEach var="restaurant" items="${listRestaurants}">
<!-- For each user in the database, display their
information accordingly -->
<tr>
<td>
<c:out value="${restaurant.name}" />
</td>
<td>
<c:out value="${restaurant.hotline}" />
</td>
<td>
<c:out value="${restaurant.address}" />
</td>

<!-- For each user in the database, Edit/Delete
buttons which invokes the edit/delete functions -->
<td>
<a href="edit?name=<c:out value='${restaurant.name}'
/>">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
<a href="delete?name=<c:out
value='${restaurant.name}' />">Delete</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>
</body>
</html>