package com.swm.data;

import java.util.HashMap;

public class RoomOptCode {
	private HashMap<Integer, String> roomopt = new HashMap<Integer, String>();

	public RoomOptCode() {
		this.roomopt.put(1, "wifi");
		this.roomopt.put(2, "bed");
		this.roomopt.put(3, "desk");
		this.roomopt.put(4, "wardrobe");
		this.roomopt.put(5, "sofa");
		this.roomopt.put(6, "airconditioner");
		this.roomopt.put(7, "refrigerator");
		this.roomopt.put(8, "washingmachine");
		this.roomopt.put(9, "tv");
		this.roomopt.put(10, "gas stove");
		this.roomopt.put(11, "microwave");
		this.roomopt.put(12, "oven");
		this.roomopt.put(13, "bathtub");
	}
}
