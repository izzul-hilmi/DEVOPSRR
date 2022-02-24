<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<form action="UserServlet" method="post">
		Name: <input type="text" name="name" size="20">
		<br>
		Password: <input type="password" name="password" size="20">
		<br>
		Email: <input type="text" name="email" size="20">
		<br>
		<input id="submit_" type="submit" value="Register" />
	</form>

</body>

<script>
console.log(loggedIn);
sessionStorage.setItem(name,name);

</script>

</html>