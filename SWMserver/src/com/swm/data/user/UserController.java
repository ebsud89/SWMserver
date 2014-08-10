package com.swm.data.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swm.utils.AbstractController;


/**
 * Servlet implementation class UserController
 */
@WebServlet("/user/*")
public class UserController extends AbstractController {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	String uri = getURI(request);
		
		
		
		if ("/user/userSignIn".equals(uri)) {
			userFbRegister(request, response);
		} else if ("/user/userAuth".equals(uri)) {
			userAuth(request, response);
		}
		else {
			// set Logger
//			logger = new Logger();
//			logger.log("Exception Detected in 'UserController'");
		}
	}

	private void userFbRegister(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String resultStr = "";
		
		try {
			
			
			
			resultStr = "success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resultStr = "fail";
		}
		
		request.setAttribute("result", resultStr);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/result.jsp");
		rd.forward(request, response);	
	}

	private void userAuth(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String resultStr = "";
		
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		

		request.setAttribute("result", resultStr);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/result.jsp");
		rd.forward(request, response);	
	}

}
