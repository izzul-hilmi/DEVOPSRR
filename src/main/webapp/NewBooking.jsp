<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<head>
<meta charset="ISO-8859-1">
<title>Create new booking</title>
</head>
<body>
<div class="row">
<div class="container">
<h3 class="text-center">Create New Booking</h3>
<form action="NewBookingServlet" method="post">
	Username: <input type="text" name="username">
	<br>
	Restaurant: <input type="text" name="restaurant">
	<br>
	Date: <input type="date" name="date" placeholder="DD/MM/YYYY format">
	<br>
	Time: <input type="time" name="time"placeholder="Enter in 12HR format">
	<br>
	<input type="submit" class="btn btn-success" value="Create booking"/>
</form>
</div>
</div>
</body>
</html>