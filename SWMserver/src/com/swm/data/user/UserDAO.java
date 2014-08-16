package com.swm.data.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.swm.utils.JDBCutils;

public class UserDAO {

	// sql query statements
	private static String REG_USER = "insert into member (name, age, sex, job, opt) values (?,?,?,?,?,?,?,?,?)";
	public int regUser(UserVO vo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		int result = 0;
		
		try {
			
			conn = JDBCutils.getConnection();
			
			stmt = conn.prepareStatement(REG_USER);
			
			int idx = 1;
			
			// query 수정 
			stmt.setString(idx++, vo.getFbid());
			stmt.setInt(idx++, vo.getAge());
			stmt.setInt(idx++, vo.getSex());
			stmt.setInt(idx++, vo.getJob());
			stmt.setInt(idx++, vo.getOpt());

			result = stmt.executeUpdate();
			
		} catch ( Exception ex ) {
			ex.printStackTrace();
		} finally {
			JDBCutils.close(stmt, conn);
		}
		
		
		return result;
	}

	public int Login(UserVO vo) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int result = 0;
		String LOGIN = "select password from member where id = " + vo.getUid()
										+", password = "+ vo.getPassword();
		try {
			
			conn = JDBCutils.getConnection();
			stmt = conn.prepareStatement(LOGIN);
			rs = stmt.executeQuery(LOGIN);
			if(rs.next()){
				return 1;
			}		
//			result = stmt.executeUpdate();
		} catch ( Exception ex ) {
			ex.printStackTrace();
		} finally {
			JDBCutils.close(stmt, conn);
		}
		rs.close();
		stmt.close();
		conn.close();
		return 0;
	}
	
	public int setUserMatchInfo(UserVO uvo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
