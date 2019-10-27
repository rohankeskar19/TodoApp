package todo;


import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.User;

/**
 * Servlet implementation class Register
 */

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Register() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect(request.getContextPath() + "/Register.jsp");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirm-password");
		boolean errorOccured = false;
		
		
		if(username.trim().equals("")) {
			errorOccured = true;
			request.setAttribute("error-username", "Invalid username");
		}
		if(password.trim().equals("")) {
			errorOccured = true;
			request.setAttribute("error-password", "Invalid password");
		}
		if(confirmPassword.trim().equals("")) {
			errorOccured = true;
			request.setAttribute("error-confirmpassword", "Invalid password");
		}
		
		if(!password.trim().equals(confirmPassword.trim())) {
			errorOccured = true;
			request.setAttribute("error-password", "Passwords do not match");
		}
		
if(errorOccured) {
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.setAttribute("confirmpassword", confirmPassword);
			RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
			
			rd.forward(request, response);
		}
else {
	String error = User.addUser(username, password);
	
	if(error != null) {
		
		request.setAttribute("password", password);
		request.setAttribute("confirmpassword", confirmPassword);
		request.setAttribute("error-username", error);
		System.out.print(request.getAttribute("error-username"));
		RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
		
		rd.forward(request, response);	
	}
	else {
		response.sendRedirect(request.getContextPath() + "/Login.jsp");	
	}
}
		
	}

}
