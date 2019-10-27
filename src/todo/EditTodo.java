package todo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import database.Todo;

/**
 * Servlet implementation class EditTodo
 */

public class EditTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EditTodo() {
        // TODO Auto-generated constructor stub
    }

    
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	if(request.getSession().getAttribute("user") != null) {
    		
    		try {
    			
    			String body = getBody(request);
    			JSONObject jsonObject = new JSONObject(body);
    			
    			String id = jsonObject.getString("id");
    			String value = jsonObject.getString("value");
    			
    			boolean todoUpdated = Todo.editTodo(id, value);
    			
    			if(todoUpdated) {
    				response.setContentType("application/json");
    				JSONObject jsonObject1 = new JSONObject("{message: 'success'}");
    				
    				response.getWriter().print(jsonObject1);
    				response.getWriter().flush();
    			}
    		
    			
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    		}
    		}
    		else {
    			response.setContentType("application/json");
    			response.setStatus(401);
    			response.getWriter().write("{message: 'you are not authenticated to perform this request'}");
    		}

	}

	public static String getBody(HttpServletRequest request) throws IOException {

	    String body = null;
	    StringBuilder stringBuilder = new StringBuilder();
	    BufferedReader bufferedReader = null;

	    try {
	        InputStream inputStream = request.getInputStream();
	        if (inputStream != null) {
	            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	            char[] charBuffer = new char[128];
	            int bytesRead = -1;
	            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
	                stringBuilder.append(charBuffer, 0, bytesRead);
	            }
	        } else {
	            stringBuilder.append("");
	        }
	    } catch (IOException ex) {
	        throw ex;
	    } finally {
	        if (bufferedReader != null) {
	            try {
	                bufferedReader.close();
	            } catch (IOException ex) {
	                throw ex;
	            }
	        }
	    }

	    body = stringBuilder.toString();
	    return body;
	}

}
