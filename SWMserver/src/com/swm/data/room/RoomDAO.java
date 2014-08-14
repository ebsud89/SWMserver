package com.swm.data.room;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.swm.data.user.UserVO;
import com.swm.deal.DealVO;
import com.swm.match.MatchProc;
import com.swm.utils.JDBCutils;

public class RoomDAO {

	private static String GET_ROOM_DETAIL = "SELECT * FROM room WHERE id=?";
	private static String GET_ALL_ROOMS = "SELECT * FROM room";
	private static String REG_USER = "insert into room (name,hostid,station, rent, guaranty, management, options, infos, rules, premium, total, available, styles, time, way) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public ArrayList<RoomVO> getMatchRank(UserVO uvo, RoomVO rvo, int sex) {
		// TODO Auto-generated method stub

		ArrayList<RoomVO> roomList = new ArrayList<RoomVO>();

		// 자료구조 정해야함 ...
		return roomList;
	}

	// sql query statements
	public int regRoom(RoomVO vo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		int result = 0;

		try {

			conn = JDBCutils.getConnection();

			stmt = conn.prepareStatement(REG_USER);

			int idx = 1;

			// query 수정
			stmt.setInt(idx++, vo.getRid());

			result = stmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCutils.close(stmt, conn);
		}

		return result;
	}
	public void getAR() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		int result = 0;

		try {

			conn = JDBCutils.getConnection();

			stmt = conn.prepareStatement(GET_ALL_ROOMS);

			result = stmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCutils.close(stmt, conn);
		}
	}
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
			resvo.setInfos(rs.getString("infos"));
			resvo.setRules(rs.getString("rules"));
			resvo.setStyles(rs.getString("styles"));
			resvo.setRent(rs.getInt("rent"));
			resvo.setGuaranty(rs.getInt("rent:"));
			resvo.setAvaliable(rs.getInt("availiable"));
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
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/web_java", "root", "mh0329");
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

}
