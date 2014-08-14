package com.swm.match;

import java.util.ArrayList;
import java.util.StringTokenizer;

import com.swm.data.room.RoomVO;
import com.swm.data.user.UserVO;

public class MatchProc {
	
	public MatchProc (ArrayList<RoomVO> rvo, UserVO uvo) {
		
	}
	
	//jaccard 
	public float jaccard_index(String new_option, String options, String new_infos, String infos){
		StringTokenizer db_tokenOpt = new StringTokenizer(options);
		StringTokenizer user_tokenOpt = new StringTokenizer(new_option);
		StringTokenizer db_tokenInfo = new StringTokenizer(infos);
		StringTokenizer user_tokenInfo = new StringTokenizer(new_infos);
		int elem11 = 0, elem10 = 0, elem01 = 0, elem00 = 0;
		String db_str, user_str;
		while(db_tokenOpt.hasMoreTokens() && user_tokenOpt.hasMoreTokens()){
			db_str = db_tokenOpt.nextToken("|");
			user_str = user_tokenOpt.nextToken("|");
			if(db_str.equals("1") && user_str.equals("1"))
				elem11++;
			if(db_str.equals("1") && user_str.equals("0"))
				elem10++;
			if(db_str.equals("0") && user_str.equals("1"))
				elem01++;
			if(db_str.equals("0") && user_str.equals("0"))
				elem00++;
		}
		while(db_tokenInfo.hasMoreTokens() && user_tokenInfo.hasMoreTokens()){
			db_str = db_tokenInfo.nextToken("|");
			user_str = user_tokenInfo.nextToken("|");
			if(db_str.equals("1") && user_str.equals("1"))
				elem11++;
			if(db_str.equals("1") && user_str.equals("0"))
				elem10++;
			if(db_str.equals("0") && user_str.equals("1"))
				elem01++;
			if(db_str.equals("0") && user_str.equals("0"))
				elem00++;
		}
		return ((float)elem11/(float)(elem11+elem10+elem01));
	}
}