package swm.data.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swm.utils.AbstractController;

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
			//userSignIn(request, response);
		} else if ("/user/userSignUp".equals(uri)) {
			//userSignUp(request, response);
		}
		else {
			// set Logger
//			logger = new Logger();
//			logger.log("Exception Detected in 'UserController'");
		}
	}

}
