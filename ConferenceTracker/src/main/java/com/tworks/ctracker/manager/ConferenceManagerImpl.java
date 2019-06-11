package com.tworks.ctracker.manager;

import java.util.List;

import com.tworks.ctracker.entities.Conference;
import com.tworks.ctracker.entities.Talk;
import com.tworks.ctracker.scheduler.Scheduler;
import com.tworks.ctracker.scheduler.Validator;
import com.tworks.ctracker.scheduler.ValidatorImpl;

public class ConferenceManagerImpl implements ConferenceManager {
	
	private Scheduler confScheduler;
	
	
	public ConferenceManagerImpl(Scheduler confScheduler) {
		this.confScheduler = confScheduler;
	}

	@Override
	public Conference scheduleTalks(List<Talk> talks) throws Exception {
		Conference conf = new Conference();
		Validator validator = new ValidatorImpl();
		
		if(talks == null || talks.size() == 0)
			throw new Exception("No talks to schedule");
		
		if(validator.validateTalk(talks)) {
			conf = confScheduler.schedule(talks);
		}else {
			//throw exception
		}
		return conf;
	}

}
