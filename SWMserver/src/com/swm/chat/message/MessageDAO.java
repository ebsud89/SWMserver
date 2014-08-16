package com.swm.chat.message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.swm.utils.JDBCutils;

public class MessageDAO {

	private static String GET_ALL_MSG = "SELECT * FROM message";
	
	int result = 0;
	ResultSet rs = null;
	
	
	public ArrayList<MessageVO> getAllMsg() {
		
		ArrayList<MessageVO> resultSet = new ArrayList<MessageVO>();
		
		Connection conn = null;
		PreparedStatement stmt = null;

		
		try {
		
			conn = JDBCutils.getConnection();
			
			stmt = conn.prepareStatement(GET_ALL_MSG);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				MessageVO vo = new MessageVO();
				vo.setFromid( rs.getInt("from"));
				vo.setMid( rs.getInt("id"));
				vo.setText( rs.getString("text"));
				vo.setToid( rs.getInt("to"));
				resultSet.add(vo);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return resultSet;
	}

}
