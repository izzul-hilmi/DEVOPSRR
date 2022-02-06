<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="NewBookingServlet" method="post">
	Username: <input type="text" name="username">
	Restaurant: <input type="text" name="restaurant">
	Date: <input type="date" name="date" placeholder="DD/MM/YYYY format">
	Time: <input type="time" name="time"placeholder="Enter in 12HR format">
	<input type="submit" value="Call Servlet"/>
</form>
</body>
</html>