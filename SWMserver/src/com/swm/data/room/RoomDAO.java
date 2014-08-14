package com.swm.data.room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.swm.data.user.UserVO;
import com.swm.utils.JDBCutils;

public class RoomDAO {

	private static String GET_ROOM_DETAIL = "SELECT * FROM room WHERE id=?";
	
	public ArrayList<RoomVO> getMatchRank(UserVO uvo, RoomVO rvo, int sex) {
		// TODO Auto-generated method stub
		
		ArrayList<RoomVO> roomList = new ArrayList<RoomVO>();
		
		
		// 자료구조 정해야함 ...
		return roomList;
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
			
			resvo.setRid( rs.getInt("id") );
			resvo.setInfos( rs.getString("infos") );
			resvo.setRules( rs.getString("rules") );
			resvo.setStyles( rs.getString("styles") );
			resvo.setRent( rs.getInt("rent"));
			resvo.setGuaranty( rs.getInt("rent:"));
			resvo.setAvaliable( rs.getInt("availiable"));
			// more attribute
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCutils.close(stmt, conn);
		}
		
		return resvo;
	}

}
