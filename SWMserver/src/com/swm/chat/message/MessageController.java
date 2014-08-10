package com.swm.chat.message;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swm.utils.AbstractController;


/**
 * Servlet implementation class MessageController
 */
@WebServlet("/msg/*")
public class MessageController extends AbstractController {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MessageController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		// here are function's code
		
		String uri = getURI(request);
		request.setCharacterEncoding("UTF-8");
		
		if ("/content/getAllContent".equals(uri)) {
			receiveMsg(request, response);
		} else if ("/content/addContent".equals(uri)) {
			sendMsg(request, response);
		} 
		else {
			// set logger
//			logger = new Logger();
//			logger.log("Exception detected in 'ContentController'");
		}
	}

	private void sendMsg(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void receiveMsg(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
