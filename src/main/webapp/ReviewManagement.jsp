<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<div class="row">
<div class="container">
<h3 class="text-center">List of Users</h3>

<div class="container text-left">
<!-- Add new user button redirects to the register.jsp page -->
<a href="<%=request.getContextPath()%>/review.jsp" class="btn-success">Add New User</a>
</div>

<!-- Create a table to list out all current users information -->
<table class="table">
<thead>
<tr>
<th>Name</th>
<th>Comment</th>
<th>Actions</th>

</tr>
</thead>
<!-- Pass in the list of users receive via the Servlet response to a loop -->
<tbody>
<c:forEach var="review" items="${listComment}">
<!-- For each user in the database, display their information accordingly -->
<tr>
<td>
<c:out value="${review.name}" />
</td>
<td>
<c:out value="${review.review}" />
</td>

<!-- For each user in the database, Edit/Delete buttons which invokes the edit/delete functions -->
<td>
<a href="edit?name=<c:out value='${review.name}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
<a href="delete?name=<c:out value='${review.name}' />">Delete</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>	
</div>
</div>
</body>
</html>