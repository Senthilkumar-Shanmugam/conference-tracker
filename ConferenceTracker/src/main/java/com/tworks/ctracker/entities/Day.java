package com.tworks.ctracker.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

//abstraction to represent a day
@Data
public class Day {
	private List<Track> tracks = new ArrayList<>();
	private LocalDate confDate;

	
	public int getNoOfTalksFortheDay() {
		int c = 0;
		
		for(Track t:getTracks())
			c+= t.getNoOfAssignedTalks();
		
		return c;
	}
}
