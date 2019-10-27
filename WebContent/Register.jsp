<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<<<<<<< HEAD
<title>Register</title>
</head>
<body>
	<form action="/Register" method="post">
		<label for="username">Username:</label>
		<input type="text" id="username" name="username"/>
		<label for="">Password:</label>
		<input type="password" id="password" name="password"/>
		<button type="submit">Login</button>
	</form>
=======
<link rel="stylesheet" href="Bootstrap/css/bootstrap.min.css">
<title>Register</title>
</head>
<body>

<%
	if(session.getAttribute("user") != null){
		response.sendRedirect(request.getContextPath() + "/Dashboard.jsp");
	}

%>
	<form style="width: 50%; position: absolute; top: 30%; left: 25%" action="Register" method="post">
  <div class="form-group">
    <label for="exampleInputUsername">Username</label>
    <input type="text" class="form-control" id="exampleInputUsername" placeholder="Enter username" name="username" value=<%= request.getAttribute("username") == null ? "" : request.getAttribute("username")%>>
   <small class="form-text text-danger"><%= request.getAttribute("error-username") == null ? "" : request.getAttribute("error-username")%></small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password" value=<%= request.getAttribute("password") == null ? "" : request.getAttribute("password") %>>
    <small class="form-text text-danger"><%= request.getAttribute("error-password") == null ? "" : request.getAttribute("error-password")%></small>
  </div>
  
  <div class="form-group">
    <label for="exampleInputPassword2">Confirm Password</label>
    <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Confirm Password" name="confirm-password" value=<%= request.getAttribute("confirmpassword") == null ? "" : request.getAttribute("confirmpassword") %>>
    <small class="form-text text-danger"><%= request.getAttribute("error-confirmpassword") == null ? "" : request.getAttribute("error-confirmpassword")%></small>
  </div>

  <button type="submit" class="btn btn-primary" style="width: 100%;">Create Account</button>
 <a href="Login.jsp" style="margin: 10px auto;">Login</a>
</form>
>>>>>>> c3c6cccddaa5f5a887e84599d6fec316cc2d0196
</body>
</html>