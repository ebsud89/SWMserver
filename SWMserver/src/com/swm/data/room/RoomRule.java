package com.swm.data.room;

import java.util.HashMap;

public class RoomRule {

	private HashMap<Integer, String> roomrule = new HashMap<Integer, String>();
	
	public RoomRule() {
		this.roomrule.put(1, "invite");
		this.roomrule.put(2, "pet");
		this.roomrule.put(3, "private");
		this.roomrule.put(4, "smoke");
		this.roomrule.put(5, "drink");
		
	}
}
