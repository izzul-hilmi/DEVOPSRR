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
<br>
<br>

<a href="<%=request.getContextPath()%>/RestaurantServlet/dashboard" class="btn btn-danger">Back to all restaurants</a>
<form action="RegisterServlet" method="post">
<br>
<br>
    Name: <input type="text" name="name">
    <br>
    <br>
    Hotline: <input type="text" name="hotline">
    <br>
    <br>
    Address: <input type="text" name="address">
    <br>
    <br>
    
    <input type="submit" class="btn btn-success" id="createRestaurant" value="Create Restaurant"/>
</form>
</div>
</div>
</body>
</html>