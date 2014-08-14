package com.swm.comm;

import com.swm.data.room.RoomDAO;
import com.swm.data.room.RoomVO;
import com.swm.data.user.UserDAO;
import com.swm.data.user.UserVO;
import com.swm.utils.AbstractController;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommController
 */
@WebServlet("/comm/*")
public class CommController extends AbstractController {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CommController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String uri = getURI(request);
		request.setCharacterEncoding("UTF-8");

		// Room 관련
		if ("/comm/getAllRooms".equals(uri)) {
			getAllRooms(request, response);
		} else if ("/comm/reauestRank".equals(uri)) {
			
		} else if ("/comm/regRoom".equals(uri)) {
			
		} else if ("/comm/getRoomDetail".equals(uri)) {
			getRoomDetail(request, response);
		}
		
		// picture 관련
		
		
		// match 관련
		else if ("/comm/getMatchResult".equals(uri) ) {
			getMatchResult(request, response);
		}
				
		
		// deal 관련
		
				
		// User 관련 
		else if ("/comm/regUser".equals(uri)) {
			regUser(request, response);
		} else {
			// set logger
			// logger = new Logger();
			// logger.log("Exception detected in 'ContentController'");
		}
		
		

	}

	private void getRoomDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// get parameter
		int rid = Integer.parseInt( request.getParameter("rid") );
		
		RoomVO rvo = new RoomVO();
		RoomDAO rdao = new RoomDAO();
		
		rvo.setRid(rid);
		
		RoomVO resvo = new RoomVO();
		String resultStr = "";
		
		resvo = rdao.getRoomDetail(rvo);
		
		if (resvo != null)
			resultStr = resvo.toString();
		else 
			resultStr = "fail";
		
		request.setAttribute("result", resultStr);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/result.jsp");
		rd.forward(request, response);
	}

	private void getMatchResult(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// 성별, 나이 구분 필요 !
		String fbid = request.getParameter("fbid");
		String styles = request.getParameter("styles");
		String rules = request.getParameter("rules");
		int ageRange = Integer.parseInt( request.getParameter("ageRange"));
		int allowsex = Integer.parseInt( request.getParameter("allowSex"));
		
		UserVO uvo = new UserVO();
		UserDAO udao = new UserDAO();
		RoomVO rvo = new RoomVO();
		RoomDAO rdao = new RoomDAO();
		
		uvo.setFbid(fbid);
		uvo.setStyles(styles);
		uvo.setRules(rules);
		uvo.setAllowsex(allowsex);
		
		rvo.setRules(rules);
		rvo.setStyles(styles);
		
		ArrayList<RoomVO> roomList = new ArrayList<RoomVO>();
		String resultStr = "";
		int resultInt = 0;
		
		try {
			roomList = rdao.getMatchRank(uvo, rvo, allowsex);
			resultInt = udao.setUserMatchInfo(uvo);
			
			if ((roomList != null) || (resultInt == 1)) 
				resultStr = roomList.toString();
			else
				resultStr = "fail";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("result", resultStr);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/result.jsp");
		rd.forward(request, response);
		
	}

	private void regUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// getParameter
		// 직업, 나이, 성별, 이름
		String fbid = request.getParameter("fbid");
		String uname = request.getParameter("uname");
		int age = Integer.parseInt(request.getParameter("age"));
		int sex = Integer.parseInt(request.getParameter("sex"));
		int job = Integer.parseInt(request.getParameter("job"));
		int opt = Integer.parseInt(request.getParameter("opt"));

		UserVO userVo = new UserVO();
		UserDAO userDao = new UserDAO();

		userVo.setFbid(fbid);
		userVo.setUname(uname);
		userVo.setAge(age);
		userVo.setJob(job);
		userVo.setSex(sex);
		userVo.setOpt(opt);

		int result = userDao.regUser(userVo);
		String resultStr = null;

		if (result == 1) {
			resultStr = "success";
		} else {
			resultStr = "fail";
		}

		request.setAttribute("result", resultStr);

		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/result.jsp");
		rd.forward(request, response);
	
	}

	private void getAllRooms(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
