package com.swm.data;

import java.util.HashMap;

public class RoomInfoCode {

	private HashMap<Integer, String> roominfo = new HashMap<Integer, String>();

	public RoomInfoCode() {

		this.roominfo.put(1, "room_num");
		this.roominfo.put(2, "room_able");
		this.roominfo.put(3, "bedroom");
		this.roominfo.put(4, "livingroom");
		this.roominfo.put(5, "kitchen");
		this.roominfo.put(6, "bathroom");
		this.roominfo.put(7, "laundryroom");
		this.roominfo.put(8, "storage");
		this.roominfo.put(9, "library");
		this.roominfo.put(10, "parkingspace");
		this.roominfo.put(11, "elevator");
	}
}