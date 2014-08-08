package swm.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import swm.utils.*;

public class LifeStyleCode {

	private HashMap<Integer, String> lifestyle = new HashMap<Integer, String>(); 
	
	public LifeStyleCode() {
		// TODO Auto-generated constructor stub
		
		this.lifestyle.put(1, "music");
		this.lifestyle.put(2, "movie");
		this.lifestyle.put(3, "reading");
		this.lifestyle.put(4, "exercise");
		this.lifestyle.put(5, "cook");
		this.lifestyle.put(6, "fasion");
		this.lifestyle.put(7, "interior");
		this.lifestyle.put(8, "sports");
		this.lifestyle.put(9, "travel");
		this.lifestyle.put(10, "game");
		this.lifestyle.put(11, "arts");
		this.lifestyle.put(12, "pictures");
		this.lifestyle.put(13, "talk");
		this.lifestyle.put(14, "study");
		this.lifestyle.put(15, "wellbeing");
		this.lifestyle.put(16, "loving");
		this.lifestyle.put(17, "career");
		this.lifestyle.put(18, "owl");
		
		/*
		// DB connect & synchronize

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
				
		try {
			
			conn = JdbcUtil.getConnection();
			
			stmt = conn.prepareStatement(CONTENT_ALL);
			
			rs = stmt.executeQuery();
			
			while ( rs.next() ) {
				this.lifestye.put(rs.getInt("id"), rs.getString("name");
			}
			
		} catch ( Exception e ) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
		 */
		
	}
}
