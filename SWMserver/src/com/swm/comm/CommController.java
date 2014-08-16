package com.swm.comm;

import com.swm.data.room.RoomDAO;
import com.swm.data.room.RoomVO;
import com.swm.data.user.UserDAO;
import com.swm.data.user.UserVO;
import com.swm.deal.DealDAO;
import com.swm.deal.DealVO;
import com.swm.utils.AbstractController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;


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
		} else if ("/comm/requestRank".equals(uri)) {
			//compareWithRoom과 같음
		} else if ("/comm/regRoom".equals(uri)) {
			regRoom(request, response);
		} else if ("/comm/getRoomDetail".equals(uri)) {
			getRoomDetail(request, response);
		}
		
		// picture 관련
		
		
		// match 관련
		else if ("/comm/getMatchResult".equals(uri) ) {
			getMatchResult(request, response);
		}
				
		
		// deal 관련
		else if("/comm/CompareWithRoom".equals(uri)){
			//using MatchProc
			//filtering, ranking
			//sending data
			try {
				CompareWithRoom(request, response);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		// User 관련 
		else if ("/comm/regUser".equals(uri)) {
			regUser(request, response);
		} else if("/comm/UserLogin".equals(uri)){
			//Login by DB
			try {
				UserLogin(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	//
	private void regRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// getParameter
		String name = request.getParameter("name");
		int hostid = Integer.parseInt(request.getParameter("hostid"));
		String doname = request.getParameter("doname");
		String siname = request.getParameter("siname");
		String dongname = request.getParameter("dongname");
		String stationName = request.getParameter("stationName");
		int rent = Integer.parseInt(request.getParameter("rent"));
		int guaranty = Integer.parseInt(request.getParameter("guaranty"));
		int management = Integer.parseInt(request.getParameter("management"));
		String options = request.getParameter("options");
		String infos = request.getParameter("infos");
		String rules = request.getParameter("rules");
		String styles = request.getParameter("styles");
		int premiumCode = Integer.parseInt(request.getParameter("premiumCode"));
		int total = Integer.parseInt(request.getParameter("total"));
		int avaliable = Integer.parseInt(request.getParameter("avaliable"));
		int msex = Integer.parseInt(request.getParameter("msex"));
		int wsex = Integer.parseInt(request.getParameter("wsex"));
		
		
		RoomVO roomVO = new RoomVO();
		RoomDAO roomDAO = new RoomDAO();

		roomVO.setName(name);
		roomVO.setHostid(hostid);
		roomVO.setDoname(doname);
		roomVO.setSiname(siname);
		roomVO.setDongname(dongname);
		roomVO.setStationName(stationName);
		roomVO.setRent(rent);
		roomVO.setGuaranty(guaranty);
		roomVO.setManagement(management);
		roomVO.setOptions(options);
		roomVO.setInfos(infos);
		roomVO.setStyles(styles);
		roomVO.setPremiumCode(premiumCode);
		roomVO.setTotal(total);
		roomVO.setAvaliable(avaliable);
		roomVO.setMsex(msex);
		roomVO.setWsex(wsex);
		roomVO.setJaccard(0);
		
		//
		int result = roomDAO.regRoom(roomVO);
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
		
		ArrayList<RoomVO> resultSet = new ArrayList<RoomVO>();
		RoomDAO rdao = new RoomDAO();
		
		resultSet = rdao.getAllRooms();
		String resultStr = "";
		
		if (resultSet != null) {
			resultStr = resultSet.toString();
		} else {
			resultStr = "fail";
		}
		
		request.setAttribute("result", resultStr);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/result.jsp");
		rd.forward(request, response);
		
	}
	
	private void CompareWithRoom(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, JSONException{
	
		String jsonparam = request.getParameter("json");
		JSONObject jsonobj = new JSONObject(jsonparam);
		
		DealDAO Ddao = new DealDAO();
		RoomDAO Rdao = new RoomDAO();
		
		DealVO Dvo = new DealVO();
		ArrayList<DealVO> member = new ArrayList<DealVO>();

		request.setAttribute("result", Rdao.ArraytoJSON(Rdao.sorting(Rdao.filtering(Ddao.JSONParsing(jsonobj, Dvo)))));

		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/result.jsp");
		rd.forward(request, response);
	}
	
	private void UserLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, SQLException{
		String fbid = request.getParameter("fbid");
		String uname = request.getParameter("uname");
		
		UserVO userVo = new UserVO();
		UserDAO userDao = new UserDAO();

		userVo.setFbid(fbid);
		userVo.setUname(uname);
		
		int result = userDao.Login(userVo);
		
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
}
