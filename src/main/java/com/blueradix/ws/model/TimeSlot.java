package com.blueradix.ws.model;

import java.io.Serializable;
import java.util.Date;

public class TimeSlot implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String subject;
	String classroom;
	Date start;
	Date end;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "TimeSlot [subject=" + subject + ", classroom=" + classroom + ", start=" + start + ", end=" + end + "]";
	}
	
	
}
