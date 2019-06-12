package com.tworks.ctracker.scheduler;

import java.util.List;

import com.tworks.ctracker.common.CTrackerConstants;
import com.tworks.ctracker.entities.SessionType;
import com.tworks.ctracker.entities.Talk;
import com.tworks.ctracker.exception.InValidTalkException;
import com.tworks.ctracker.exception.TalkCannotBeScheduledException;

public class ValidatorImpl implements Validator {

	@Override
	public boolean validateTalk(List<Talk> talks) throws InValidTalkException,TalkCannotBeScheduledException {
		
		long totalTalkTime = 0l;
		if(talks ==null || talks.size() < CTrackerConstants.MIN_TALKS_IN_CONFERENCE)
			throw new TalkCannotBeScheduledException("Minimum "+ CTrackerConstants.MIN_TALKS_IN_CONFERENCE + " Talks required to schedule a conference");


		for(Talk talk:talks) {
			if(talk.getTitle().matches(".*\\d+.*"))
				throw new InValidTalkException("Talk "+ talk.getTitle() + " cannot have numbers in title");
			
			if(talk.getTalkTime() > SessionType.MORNING.getSessionDuration() || talk.getTalkTime() > SessionType.AFTERNOON.getSessionDuration())
				throw new InValidTalkException("Talk time bigger for any entire session to hold");
			
			totalTalkTime += talk.getTalkTime();
		}
		
		if(totalTalkTime < SessionType.MORNING.getSessionDuration() + SessionType.AFTERNOON.getSessionDuration())
			throw new TalkCannotBeScheduledException("Minimum talk time required to conduct 2 sessions");
		
		return true;
	}
}
