<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<<<<<<< HEAD
=======
    <%@page import="models.TodoModel"%> 
<%@page import="java.util.*"%>
>>>>>>> c3c6cccddaa5f5a887e84599d6fec316cc2d0196
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<<<<<<< HEAD
<title>Dashboard</title>
</head>
<body>

=======
<link rel="stylesheet" href="Bootstrap/css/bootstrap.min.css">
<title>Dashboard</title>
</head>
<body>
<jsp:include page="/Dashboard" />
	<%
		if(session.getAttribute("user") == null){
			
			response.sendRedirect(request.getContextPath() + "/Login.jsp");
		}
	  
	
	%>
	  
  
    <%
    
    if(request.getAttribute("data") == null){
    	%>
    	<div style="height: 4rem; width: 100%; background-color: #292b2c; display:felx; flex-direction: row; ">
		<h6 style="color: white; display: inline-block;"><%=session.getAttribute("user") %></h6>
		<form action="Logout" method="post" style="display: inline-block;">
		<button class="btn btn-warning" type="submit">Log out</button>
		</form>
		
	</div>
    	<h5 style="text-align: center; padding: 50px;">Your todos will be shown here</h5>
    	<table class="table table-hover table-dark" id="table" style="display: none;">
  <thead>
    <tr>
      <th scope="col">Created On.</th>
      <th scope="col">Content</th> 
      <th scope="col">Due</th>
      <th scope="col">Completed</th>
    </tr>
  </thead>
  <tbody id="table-body">
    	</tbody>
    	</table>
    	<%
    }
    else{
    	
    	%>
	<div style="height: 4rem; width: 100%; background-color: #292b2c; display:felx; flex-direction: row; ">
		<h6 style="color: white;"><%=session.getAttribute("user") %></h6>
		<form action="Logout" method="post">
		<button class="btn btn-warning" type="submit">Log out</button>
		</form>
		
	</div>
		<table class="table table-hover table-dark"  id="table" >
  <thead>
    <tr>
      <th scope="col">Created On.</th>
      <th scope="col">Content</th>
      <th scope="col">Due</th>
      <th scope="col">Completed</th>
    </tr>
  </thead>
  <tbody id="table-body">
  <%
  
    	 ArrayList<TodoModel> todos =  
    	            (ArrayList<TodoModel>)request.getAttribute("data"); 
    	    
    	    
    	        for(TodoModel todo:todos){%> 
    	       
    	            <tr id=<%=todo.getId() %>> 
    	                <td><%=todo.getCreated_at()%></td> 
    	                <td><%=todo.getContent()%></td> 
    	                <td><%=todo.getDue()%></td> 
    	                <td>
    	                <%
    	                	if(todo.getCompleted().equals("N")){%>
    	                		<input type='checkbox' class='check' id=<%=todo.getId() %> onclick="checkTodo('<%=todo.getId() %>')"/>
    	                	<% }
    	                	else{%>
    	                		<input type='checkbox' checked class='uncheck' id=<%=todo.getId() %> onclick="uncheckTodo('<%=todo.getId() %>')">
    	                	<%}
    	                %>
    	                </td>
    	                <td><button class="btn btn-danger" id=<%=todo.getId() %> onclick="deleteTodo('<%=todo.getId() %>')">Delete</button></td>
    	            </tr> 
    	            <%}
    }
   %> 
  </tbody>
</table>

	<div class="modal" tabindex="-1" role="dialog" style="display: none;" id="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" data-dismiss="modal" aria-label="Close" >
          <span aria-hidden="true" id="close-modal-cross">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="form-group">
    <label for="content">Content</label>
    <input type="text" class="form-control" id="content" placeholder="Enter content">
    
  </div>
  <div class="form-group">
    <label for="due-select">Select Due Date.</label>
    <input type="date" class="form-control" id="due-date">
  </div>
 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" id="close-modal">Close</button>
        <button type="button" class="btn btn-primary" id="add-todo-modal">Save changes</button>
      </div>
    </div>
  </div>
</div>


	<button id="add-todo-button" class="btn btn-primary" style="position: fixed; bottom: 10%; left: 50%;">Add Todo</button>
	<script>
	
	function checkTodo (id){
		const value = "Y";
		const options = {
				method: "PUT",
				body : 
					JSON.stringify({
						id,value
					})
				
				
		}
		
		fetch("/TodoApp/EditTodo",options)
		
		
	}

	function uncheckTodo (id) {
		const value = "N";
		const options = {
				method: "PUT",
				body : 
					JSON.stringify({
						id,value
					})
				
				
		}
		
		fetch("/TodoApp/EditTodo",options)
		
	}
	
	
	function deleteTodo(id) {
		const options = {
				method: "DELETE",
				body : 
					JSON.stringify({
						id
					})
				
				
		}
		fetch("/TodoApp/RemoveTodo",options)
		.then(res => {
			var row = document.getElementById(id);
		    row.parentNode.removeChild(row);
		})
	}
	</script>
	<script src="js/main.js"></script>
>>>>>>> c3c6cccddaa5f5a887e84599d6fec316cc2d0196
</body>
</html>