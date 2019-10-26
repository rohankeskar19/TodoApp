<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Bootstrap/css/bootstrap.min.css">
<title>Login</title>
</head>
<body>
<%
	if(session.getAttribute("user") != null){
		response.sendRedirect(request.getContextPath() + "/Dashboard.jsp");
	}

%>
	<form style="width: 50%; position: absolute; top: 30%; left: 25%" action="Login" method="post">
  <div class="form-group">
    <label for="exampleInputUsername">Username</label>
    <input type="text" class="form-control" id="exampleInputUsername" placeholder="Enter username" name="username" value=<%= request.getAttribute("username") == null ? "" : request.getAttribute("username") %>>
   	<small class="form-text text-danger"><%= request.getAttribute("error-username") == null ? "" : request.getAttribute("error-username") %></small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password" value=<%= request.getAttribute("password") == null ? "" : request.getAttribute("password") %>>
    <small class="form-text text-danger"><%= request.getAttribute("error-password") == null ? "" : request.getAttribute("error-password")%></small>
  </div>

  <button type="submit" class="btn btn-primary" style="width: 100%;">Login</button>
  <a href="Register.jsp" style="margin: 10px auto;">Create Account</a>
</form>

</body>
</html>