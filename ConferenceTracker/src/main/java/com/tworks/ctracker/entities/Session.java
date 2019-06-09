package com.tworks.ctracker.entities;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.TemporalUnit;

public enum Session {
	MORNING(LocalTime.of(9,00),LocalTime.of(12,00)),
	LUNCH(LocalTime.of(12,00),LocalTime.of(13,00)),
	AFTERNOON(LocalTime.of(13,00),LocalTime.of(17,00));
	
	private final LocalTime sessionStartTime;
	private final LocalTime sessionEndTime;
	private final long  sessionDuration;
	
	private Session(LocalTime startTime,LocalTime endTime) {
		this.sessionStartTime = startTime;
		this.sessionEndTime = endTime;
		this.sessionDuration = Duration.between(sessionEndTime, sessionStartTime).toMinutes();
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
