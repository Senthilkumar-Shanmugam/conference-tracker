package com.tworks.ctracker.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Track {
	private List<Session> sessions = new ArrayList<>();
	
	public int getNoOfAssignedTalks() {
		int c = 0;
		
		for(Session s : getSessions())
		 c+= s.getScheduledTalks().size();
		
		return c;
	}

	public String toString() {
    	 StringBuffer track = new StringBuffer();
    	 
    	 System.out.println("Track:");
    	 System.out.println("Session ");
    	 
    	 return track.toString();
    }
}
