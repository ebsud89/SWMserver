package com.swm.chat.message;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// here are function's code

		String uri = getURI(request);
		request.setCharacterEncoding("UTF-8");

		if ("/msg/receiveMsg".equals(uri)) {
			receiveMsg(request, response);
		} else if ("/msg/sendMsg".equals(uri)) {
			sendMsg(request, response);
		} else if ("/msg/getMsg".equals(uri)) {
			getMsg(request, response);
		} else if ("/msg/getAllMsg".equals(uri)) {
			getAllMsg(request, response);
		} else if ("/msg/getparm".equals(uri)) {
			System.out.println("in" + uri);
			getparm(request, response);
		} else {
			// set logger
			// logger = new Logger();
			// logger.log("Exception detected in 'ContentController'");
		}
	}

	private void getparm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String resultStr = request.getParameter("msg");
		resultStr += "test";
		System.out.println("parm : ");
		System.out.println(resultStr);
		System.out.println("in getparm");

		request.setAttribute("result", resultStr);

		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/result.jsp");
		rd.forward(request, response);
	}

	private void getMsg(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void getAllMsg(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// int mid = Integer.parseInt( request.getParameter("mid"));

		MessageDAO mdao = new MessageDAO();
		ArrayList<MessageVO> resultSet = new ArrayList<MessageVO>();
		String resultStr = "";

		try {

			resultSet = mdao.getAllMsg();

			if (resultSet != null) {
				System.out.println(resultSet.toString());
				resultStr = resultSet.toString();
				resultStr = resultStr.replace("[", "");
				resultStr = resultStr.replace("]", "");
			} else
				resultStr = "fail";
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("result", resultStr);

		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/result.jsp");
		rd.forward(request, response);
	}

	private void sendMsg(HttpServletRequest request,
			HttpServletResponse response) {

		// getParameter
		int fromid = Integer.parseInt(request.getParameter("fromid"));
		int toid = Integer.parseInt(request.getParameter("toid"));
		String msg = request.getParameter("msg");

	}

	private void receiveMsg(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
