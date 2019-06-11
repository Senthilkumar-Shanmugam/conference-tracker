package com.tworks.ctracker.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Session {
	private SessionType sessionType;
	List<Talk> scheduledTalks = new ArrayList<>();
	private long remainingMinutes;
	
	

}
