package com.tworks.ctracker.manager;

import java.util.List;

import com.tworks.ctracker.entities.Conference;
import com.tworks.ctracker.entities.Talk;

public interface ConferenceManager {
	public Conference scheduleTalks(List<Talk> input) throws Exception;
	
	//remove talks
	//cancel conference
	//reschedule or move talks
}
