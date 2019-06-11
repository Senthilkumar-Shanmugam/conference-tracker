package com.tworks.ctracker.entities;

import java.time.Duration;
import java.time.LocalTime;

/**
 * Enum type to represent Differnt sessions of conferences
 * @author seshshan
 *
 */
public enum SessionType {
	MORNING(LocalTime.of(9,00),LocalTime.of(12,00)),
	LUNCH(LocalTime.of(12,00),LocalTime.of(13,00)),
	AFTERNOON(LocalTime.of(13,00),LocalTime.of(17,00)),
	NETWORKING();
	
	private final LocalTime sessionStartTime;
	private final LocalTime sessionEndTime;
	private final long  sessionDuration;
	
	private SessionType() {
		sessionStartTime = null;
		sessionEndTime = null;
		sessionDuration = 0;
	}
	
	private SessionType(LocalTime startTime,LocalTime endTime) {
		this.sessionStartTime = startTime;
		this.sessionEndTime = endTime;
		this.sessionDuration = Duration.between(sessionStartTime,sessionEndTime).toMinutes();
	}
	
	public LocalTime getSessionStartTime() {
		return sessionStartTime;
	}

	public LocalTime getSessionEndTime() {
		return sessionEndTime;
	}

	public long getSessionDuration() {
		return sessionDuration;
	}
	
	@Override
	public String toString() {
		return this.name() + " Session starts at "+  this.getSessionStartTime() +" ends at "+ this.getSessionEndTime() 
		+ " for a duration of "+this.getSessionDuration() + " minutes";
	}


}
