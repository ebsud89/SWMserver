package com.swm.chat.message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.swm.utils.JDBCutils;

public class MessageDAO {

	private static String GET_ALL_MSG = "";
	
	
	public ArrayList<MessageVO> getAllMsg(int mid) {
		
		ArrayList<MessageVO> resultSet = new ArrayList<MessageVO>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
		
			conn = JDBCutils.getConnection();
			
			stmt = conn.prepareStatement(GET_ALL_MSG);
			
		} catch (Exception e) {
			
			
		}
		
		
		return resultSet;
	}

}
