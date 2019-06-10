package com.tworks.ctracker.entities;

import java.util.Collections;
import java.util.List;

public class Track {

	private long minutesRemaining;
	private Session session;
	private List<Talk> talks = Collections.EMPTY_LIST;
	
	
	public Track() {
		
	}
	public Track(Session session) {
		this.session = session;
		this.minutesRemaining = session.getSessionDuration();
	}
	
	public List<Talk> getTalks() {
		return talks;
	}
	
	public void addTalkToTheTrack(Talk talk) {
		talks.add(talk);
		this.minutesRemaining -= talk.getTalkTime();
	}
	
     //get talks by session
	
	//getalltalks
	
     public String toString() {
    	 StringBuffer track = new StringBuffer();
    	 
    	 System.out.println("Track:");
    	 System.out.println("Session ");
    	 
    	 return track.toString();
     }
}
