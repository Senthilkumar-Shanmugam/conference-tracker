package com.tworks.ctracker.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * Abstraction to support multi-day conferences
 * currently schedules for a single day. any pending talks that after tracks been filled will be ignored.
 * @author seshshan
 *
 */
@Data
public class Conference {
	private List<Day> confDays = new ArrayList<>();
	
	public int totalNoOfTalks() {
		int c = 0;
		for(Day day: getConfDays())
			c+= day.getNoOfTalksFortheDay();
		return c;
	}
	
	


}

