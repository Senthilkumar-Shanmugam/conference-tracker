package com.tworks.ctracker.entities;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

/**
 * Abstraction to support multi-day conferences
 * currently schedules for a single day. any pending talks that after tracks been filled will be ignored.
 * @author seshshan
 *
 */
public class Conference {
	private List<Day> confDays;
	
	
	
	//abstraction to represent a day
	@Data
	static class Day{
	   private List<Track> tracks;
	   private LocalDate confDate;
	   
	   
	   
	} 

}
