package com.swm.utils;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


public class JSONutils {

	public static JSONObject strToObj(String str){
		System.out.println(str);
		JSONObject obj;
		obj = new JSONObject();
		System.out.println("in utils");
		obj = (JSONObject) JSONValue.parse(str);
		return obj;
	}
	
}
