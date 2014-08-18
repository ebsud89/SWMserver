package com.swm.data.room;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.swm.data.user.UserVO;
import com.swm.deal.DealVO;
import com.swm.match.MatchProc;
import com.swm.utils.JDBCutils;
import com.swm.utils.JSONutils;

public class RoomDAO {

	private static String GET_ROOM_DETAIL = "SELECT * FROM room WHERE id=?";
	// private static String GET_ALL_ROOMS = "SELECT * FROM room";
	private static String REG_ROOM = "insert into room (name,hostid,station,rent,guaranty,management,options, infos, rules, styles, guarants, premium, total, avaliable, time, way, msex, wsex, msexr, wsexr)"
			+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static String REG_SAMPLE = "insert into room (name,hostid) values (?,?)";

	public ArrayList<RoomVO> getMatchRank(UserVO uvo, RoomVO rvo, int sex) {
		// TODO Auto-generated method stub

		ArrayList<RoomVO> roomList = new ArrayList<RoomVO>();

		// 자료구조 정해야함 ...
		return roomList;
	}

	// sql query statements
	public int regRoom(JSONObject obj) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		RoomVO vo = new RoomVO();

		System.out.println(obj.get("userId"));
		
		try {
		vo.setHostid(Integer.parseInt((String) obj.get("userId")));
		vo.setName((String) obj.get("name"));
//		vo.setHostid(Integer.parseInt((String) obj.get("hostid")));
//		vo.setStationCode((String) obj.get("stationCode"));
//		vo.setAvaliable(Integer.parseInt((String) obj.get("available")));
//		vo.setGuaranty(Integer.parseInt((String) obj.get("guaranty")));
//		vo.setRent(Integer.parseInt((String) obj.get("rent")));
//		vo.setManagement(Integer.parseInt((String) obj.get("management")));
//		vo.setOptions((String) obj.get("options"));
//		vo.setStyles((String) obj.get("styles"));
//		vo.setInfos((String) obj.get("infos"));
//		vo.setRules( (String) obj.get("rules"));
//		vo.setPremiumCode(Integer.parseInt((String) obj.get("premium")));
//		vo.setTotal(Integer.parseInt((String) obj.get("total")));
//		vo.setWsex(Integer.parseInt((String) obj.get("wsex")));
//		vo.setWsexr(Integer.parseInt((String) obj.get("wsexr")));
//		vo.setMsex(Integer.parseInt((String) obj.get("msex")));
//		vo.setMsexr(Integer.parseInt((String) obj.get("msexr")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {

			conn = JDBCutils.getConnection();

			pstmt = conn.prepareStatement(REG_SAMPLE);

			int idx = 1;

			// query 수정
			pstmt.setString(idx++, vo.getName());
			pstmt.setInt(idx++, vo.getHostid());
//			pstmt.setString(idx++, vo.getStationCode());
//			pstmt.setInt(idx++, vo.getRent());
//			pstmt.setInt(idx++, vo.getGuaranty());
//			pstmt.setInt(idx++, vo.getManagement());
//			pstmt.setString(idx++, vo.getOptions());
//			pstmt.setString(idx++, vo.getInfos());
//			pstmt.setString(idx++, vo.getRules());
//			pstmt.setString(idx++, vo.getStyles());
//			pstmt.setString(idx++, vo.getGuarants());
//			pstmt.setInt(idx++, vo.getPremiumCode());
//			pstmt.setInt(idx++, vo.getTotal());
//			pstmt.setInt(idx++, vo.getAvaliable());
//			pstmt.setInt(idx++, vo.getTime());
//			pstmt.setInt(idx++, vo.getWay());
//			pstmt.setInt(idx++, vo.getMsex());
//			pstmt.setInt(idx, vo.getWsex());
//			pstmt.setInt(idx++, vo.getMsexr());
//			pstmt.setInt(idx++, vo.getWsexr());

			result = pstmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCutils.close(pstmt, conn);
		}

		return result;
	}

	// public void getAR() {
	// // TODO Auto-generated method stub
	// Connection conn = null;
	// PreparedStatement stmt = null;
	// int result = 0;
	//
	// try {
	//
	// conn = JDBCutils.getConnection();
	//
	// // stmt = conn.prepareStatement(GET_ALL_ROOMS);
	//
	// result = stmt.executeUpdate();
	// } catch (Exception ex) {
	// ex.printStackTrace();
	// } finally {
	// JDBCutils.close(stmt, conn);
	// }
	// }

	public RoomVO getRoomDetail(RoomVO rvo) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		RoomVO resvo = new RoomVO();

		try {
			conn = JDBCutils.getConnection();
			stmt = conn.prepareStatement(GET_ROOM_DETAIL);

			stmt.setInt(1, rvo.getRid());

			rs = stmt.executeQuery();

			resvo.setRid(rs.getInt("id"));
			resvo.setName(rs.getString("name"));
			resvo.setStationName(rs.getString("stationName"));
			;
			resvo.setHostid(rs.getInt("hostid"));
			resvo.setDoname(rs.getString("doname"));
			resvo.setSiname(rs.getString("siname"));
			resvo.setDongname(rs.getString("dongname"));
			resvo.setStationCode(rs.getString("station"));
			resvo.setRent(rs.getInt("rent"));
			resvo.setGuaranty(rs.getInt("guaranty"));
			resvo.setManagement(rs.getInt("management"));
			resvo.setOptions(rs.getString("options"));
			resvo.setInfos(rs.getString("infos"));
			resvo.setRules(rs.getString("rules"));
			resvo.setStyles(rs.getString("styles"));
			resvo.setPremiumCode(rs.getInt("premiumCode"));
			resvo.setTotal(rs.getInt("total"));
			resvo.setAvaliable(rs.getInt("avaliable"));
			resvo.setMsex(rs.getInt("msex"));
			resvo.setWsex(rs.getInt("wsex"));
			// more attribute

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCutils.close(stmt, conn);
		}
		return resvo;
	}

	public ArrayList<RoomVO> filtering(DealVO dvo) {
		String FILTER_ROOM = "select *from dbfortest where station = "
				+ dvo.getStationName() + " and rules = " + dvo.getRules()
				+ " and rent > " + dvo.getMinRent() + " and rent < "
				+ dvo.getMaxRent() + " and guaranty > " + dvo.getMinGuaranty()
				+ " and gauranty < " + dvo.getMaxGuaranty()
				+ " and management > " + dvo.getMinManage()
				+ " and management < " + dvo.getMaxManage();
		RoomVO Rvo = new RoomVO();
		ArrayList<RoomVO> RoomList = new ArrayList<RoomVO>();
		RoomDAO Rdao = new RoomDAO();
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MatchProc mp = new MatchProc();
		try {
			conn = JDBCutils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(FILTER_ROOM);
			while (rs.next()) {
				Rvo.setName(rs.getString("name"));
				Rvo.setDoname(rs.getString("doname"));
				Rvo.setSiname(rs.getString("siname"));
				Rvo.setDongname(rs.getString("dongname"));
				Rvo.setStationName(rs.getString("station"));
				Rvo.setRent(rs.getInt("rent"));
				Rvo.setGuaranty(rs.getInt("guaranty"));
				Rvo.setManagement(rs.getInt("management"));
				Rvo.setOptions(rs.getString("options"));
				Rvo.setInfos(rs.getString("infos"));
				Rvo.setRules(rs.getString("rules"));
				Rvo.setPremiumCode(rs.getInt("premium"));
				Rvo.setTotal(rs.getInt("total"));
				Rvo.setAvaliable(rs.getInt("available"));
				Rvo.setOptions(rs.getString("options"));
				Rvo.setJaccard(mp.jaccard_index(dvo.getOptions(),
						Rvo.getOptions(), dvo.getInfos(), Rvo.getOptions()));
				RoomList.add(Rvo);// RoomList 배열에 jaccard 값 대입
			}
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			System.out.println("ERROR : " + e);
		}

		return RoomList;
	}

	@SuppressWarnings("unchecked")
	public JSONObject ArraytoJSON(ArrayList<RoomVO> RoomList) {
		JSONObject room = new JSONObject();
		JSONArray list = new JSONArray();

		for (int i = 0; i < RoomList.size(); i++) {
			try {
				JSONObject member = new JSONObject();
				member.put("name", RoomList.get(i).getName());
				member.put("doname", RoomList.get(i).getDoname());
				member.put("siname", RoomList.get(i).getSiname());
				member.put("dongname", RoomList.get(i).getDongname());
				member.put("station", RoomList.get(i).getStationName());
				member.put("rent", RoomList.get(i).getRent());
				member.put("guaranty", RoomList.get(i).getGuaranty());
				member.put("management", RoomList.get(i).getManagement());
				member.put("options", RoomList.get(i).getOptions());
				member.put("infos", RoomList.get(i).getInfos());
				member.put("rules", RoomList.get(i).getRules());
				member.put("premium", RoomList.get(i).getPremiumCode());
				member.put("total", RoomList.get(i).getTotal());
				member.put("available", RoomList.get(i).getAvaliable());
				member.put("jaccard", RoomList.get(i).getJaccard());
				list.add(member);
				// System.out.println(list);
				// System.out.println(list.get(i));
				room.put("user_" + i, list.get(i));
			} catch (Exception e) {
			}
			room.put("user_" + i, list.get(i));
		}
		System.out.println(room);

		return room;
	}

	// jaccard값으로 내링차순 소팅
	public ArrayList<RoomVO> sorting(ArrayList<RoomVO> RoomList) {
		ArrayList<RoomVO> temp = new ArrayList<RoomVO>();
		temp.add(null);
		// bubble sort
		for (int i = 0; i < RoomList.size(); i++) {
			for (int j = i; j < RoomList.size(); j++) {
				if (RoomList.get(i).getJaccard() < RoomList.get(j).getJaccard()) {
					temp.set(0, RoomList.get(i));
					RoomList.set(i, RoomList.get(j));
					RoomList.set(j, temp.get(0));
				}
			}
		}
		for (int i = 0; i < RoomList.size(); i++) {
			// System.out.println(RoomList.get(i).getName()+" "+RoomList.get(i).getOptions()+" "+RoomList.get(i).getJaccard());
		}
		return RoomList;
	}

	public ArrayList<RoomVO> getAllRooms() {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String query = "SELECT * FROM room";
		ArrayList<RoomVO> resultSet = new ArrayList<RoomVO>();

		System.out.println("in getAllRooms");

		try {
			conn = JDBCutils.getConnection();
			stmt = conn.prepareStatement(query);

			rs = stmt.executeQuery();

			while (rs.next()) {

				RoomVO rvo = new RoomVO();
				rvo.setName(rs.getString("name"));
				rvo.setHostid(rs.getInt("hostid"));
				rvo.setAvaliable(rs.getInt("available"));
				rvo.setTotal(rs.getInt("total"));
				rvo.setInfos(rs.getString("infos"));
				rvo.setRules(rs.getString("rules"));
				rvo.setStyles(rs.getString("styles"));
				rvo.setRid(rs.getInt("id"));
				rvo.setStationCode(rs.getString("station"));
				rvo.setGuaranty(rs.getInt("guaranty"));
				rvo.setManagement(rs.getInt("management"));
				rvo.setRent(rs.getInt("rent"));
				rvo.setMsex(rs.getInt("msex"));
				rvo.setWsex(rs.getInt("wsex"));
				resultSet.add(rvo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultSet;
	}

}
