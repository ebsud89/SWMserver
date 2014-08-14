package com.swm.data;

import java.util.HashMap;

public class JobCode {
	
	private HashMap<Integer, String> jobCode = new HashMap<Integer, String>();

	public JobCode() {

		this.jobCode.put(1, "학생");
		this.jobCode.put(2, "직장인");
		this.jobCode.put(3, "프리랜서");
		
	}
}
