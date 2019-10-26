package todo;


import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.User;

/**
 * Servlet implementation class Login
 */

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean error = false;
		
		
		if(username.trim().equals("")) {
			error = true;
			request.setAttribute("error-username", "Invalid username");
		}
		if(password.trim().equals("")) {
			error = true;
			request.setAttribute("error-password", "Invalid password");
		}
		
		
		if(error) {
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		else {
			String err  = User.loginUser(username, password);
			
			if(err == null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", username);
//				RequestDispatcher rd = request.getRequestDispatcher("Dashboard");
//			    rd.forward(request, response);
				response.sendRedirect(request.getContextPath() + "/Dashboard.jsp");
			}
			else {
				request.setAttribute("username", username);
				request.setAttribute("password", password);
				if(err.contains("Passwords")) {
					request.setAttribute("error-password", err);
					RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
				else if(err.contains("User")) {
					request.setAttribute("error-username", err);
					RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
				
				
			}
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect(request.getContextPath() + "/Login.jsp");		
	}
	

}
