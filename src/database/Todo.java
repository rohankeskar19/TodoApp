package database;
import java.util.*;
import java.util.Date;

import models.TodoModel;

import java.sql.*;

public class Todo {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/todoapp";
	   
	   static final String USER = "root";
	   static final String PASS = "root";

	   public static ArrayList<TodoModel> getTodos(String username){
		   ArrayList<TodoModel> todos = new ArrayList<>();
		   
		   try {
			   Connection conn  = DriverManager.getConnection(DB_URL,USER,PASS);
			   Statement st = conn.createStatement();
			   
			   String sql = "SELECT * FROM todo WHERE username = '" + username + "' ORDER BY created_at DESC;";
			   
			   ResultSet rs = st.executeQuery(sql);
			 
			   
			   
			   
				 
				   while(rs.next()) {
					  
					   String id = rs.getString("id");
					   
					   
					   String created_at = rs.getString("created_at");
					   String content = rs.getString("content");
					   String due = rs.getString("due");
					   String completed = rs.getString("completed");
					   
					   TodoModel todo = new TodoModel(id,created_at,content,due,completed);
					   todos.add(todo);
					   
				   }
				    
				   conn.close();
				   return todos;
				   
				  
			   
			   
			   
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   return todos;
		   
		   
		   
	   }
	   
	   public static boolean addTodo(String id,String content,String username,String due) {
		   try {
			   String sql = "INSERT INTO todo values('" + id + "','" + username + "',NOW(),'" + content + "','N','" + due + "');";
			   System.out.println(sql);
			   
			   
			   Connection conn  = DriverManager.getConnection(DB_URL,USER,PASS);
			   Statement st = conn.createStatement();
			   
			   int result = st.executeUpdate(sql);
			   
			   if(result > 0) {
				   return true;
			   }
			   else {
				   return false;
			   }
			   
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
		   
		   return false;
	   }
	   
	   
	   public static boolean removeTodo(String id) {
		   try {
			   
			   String sql = "DELETE FROM todo WHERE id ='" + id + "';";
			   
			   
			   
			   Connection conn  = DriverManager.getConnection(DB_URL,USER,PASS);
			   Statement st = conn.createStatement();
			   
			   int result = st.executeUpdate(sql);
			   
			   if(result > 0) {
				   return true;
			   }
			   else {
				   return false;
			   }
			   
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
		   
		   return false;
	   }
	   
	   public static boolean editTodo(String id,String value) {
		   try {
			   
			   String sql = "UPDATE todo SET completed = '" + value + "' WHERE id = '" + id + "';";
			   System.out.println(sql);
			   
			   
			   Connection conn  = DriverManager.getConnection(DB_URL,USER,PASS);
			   Statement st = conn.createStatement();
			   
			   int result = st.executeUpdate(sql);
			   
			   if(result > 0) {
				   return true;
			   }
			   else {
				   return false;
			   }
			   
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
		   
		   return false;
	   }
	   
	   
}
