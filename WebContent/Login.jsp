<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="/Login.jsp" method="post">
		<label for="username">Username:</label>
		<input type="text" id="username" name="username"/>
		<label for="">Password:</label>
		<input type="password" id="password" name="password"/>
		<button type="submit">Login</button>
	</form>
</body>
</html>