package com.swm.utils;

import org.json.simple.*;

public class JSONutils {

	public static JSONObject strToObj(String str){
		JSONObject obj = new JSONObject();
		obj = (JSONObject) JSONValue.parse(str);
		return obj;
	}
	
}