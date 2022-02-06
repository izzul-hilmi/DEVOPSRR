<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "ReviewServlet" method = "post">
		Name: <input type="text" name="name">
		<br></br>
		Comment: <input type="text" name="review">

		<input type="submit" value= "Call Servlet"/>
	</form>

</body>
</html>