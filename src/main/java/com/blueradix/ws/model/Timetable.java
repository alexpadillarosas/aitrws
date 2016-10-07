package com.blueradix.ws.model;

import java.util.ArrayList;
import java.util.List;

public class Timetable {

	String username;
	List<TimeSlot> slots = new ArrayList<TimeSlot>();

	public List<TimeSlot> getSlots() {
		return slots;
	}

	public void setSlots(List<TimeSlot> slots) {
		this.slots = slots;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Timetable [username=" + username + ", slots=" + slots + "]";
	}

	
	
	
}
