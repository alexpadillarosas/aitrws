package com.blueradix.ws.service;

import com.blueradix.ws.model.Timetable;

public interface TimetableService {

	
	
	/**
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	Timetable findByUserIdAndPassword(Long userId, String password);
}
