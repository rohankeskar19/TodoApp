package database;
import java.sql.*;


public class User {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/todoapp";
	   
	   static final String USER = "root";
	   static final String PASS = "root";
	   
	public static String addUser(String username, String password) {
		String error = "";
		
		Connection conn = null;
		
		Statement st = null;
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			st = conn.createStatement();
			
			String sql = "SELECT * FROM users WHERE username = '" + username + "'";
			
			ResultSet rs = st.executeQuery(sql);
			
			
			
			if(rs.next()) {
				error = "username already taken";
				conn.close();
				return error;
			}
			else {
				String addUserSql = "INSERT INTO users values('" + username + "','" + password +  "')";
				
				int result = st.executeUpdate(addUserSql);
				
				if(result > 0) {
					conn.close();
					return null;
				}
			}
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		return error;
	}
	
	public static String loginUser(String username,String password) {
		String error = "";
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			st = conn.createStatement();
			
			String sql = "SELECT * FROM users WHERE username = '" + username + "'";	
			
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				String passwordDB = rs.getString("password");
				
				if(password.equals(passwordDB)) {
					conn.close();
					return null;
				}
				else {
					error = "Passwords do not match";
					conn.close();
					return error;
					
					
				}
				
			}
			else {
				error = "User does not exists";
				conn.close();
				return error;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return error;
	}
	
	
	public static boolean changePassword(String username,String currentPassword,String newPassword) {
		
		
		return false;
	}
	
	
	
}
