<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>User Management Application</title>
 <link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<nav class="navbar navbar-expand-md navbar-light">
<div>
<a class="navbar-brand"> User Management Application </a>
</div>
<ul class="navbar-nav">
<li><a href="<%=request.getContextPath()%>/CommentServlet/dashboard"
class="nav-link">Back to Dashboard</a></li>
</ul>
</nav>
<div class="container col-md-6">
<div class="card">
<div class="card-body">
<c:if test="${review != null}">
<form action="update" method="post">
</c:if>
<c:if test="${review == null}">
<form action="insert" method="post">
</c:if>
<caption>
<h2>
<c:if test="${review != null}">
Edit User
</c:if>
<c:if test="${review == null}">
Add New User
</c:if>
</h2>
</caption>
<c:if test="${review != null}">
<input type="hidden" name="oriName" value="<c:out
value='${review.name}' />" />
</c:if>
<fieldset class="form-group">
<label> Name</label> <input type="text" value="<c:out
value='${review.name}' />" class="form-control" name="name" required="required">
</fieldset>
<fieldset class="form-group">
<label>Review</label> <input type="text" value="<c:out
value='${review.review}' />" class="form-control" name="review">
</fieldset>

<button id="editC" type="submit" class="btn btn-success">Save</button>
</form>
</div>
</div>
</div>



</body>
</html>