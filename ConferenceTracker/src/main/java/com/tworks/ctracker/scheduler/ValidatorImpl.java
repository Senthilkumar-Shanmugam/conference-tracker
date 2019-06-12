package com.tworks.ctracker.scheduler;

import java.util.List;

import com.tworks.ctracker.entities.SessionType;
import com.tworks.ctracker.entities.Talk;
import com.tworks.ctracker.exception.InValidTalkException;
import com.tworks.ctracker.exception.TalkCannotBeScheduledException;

public class ValidatorImpl implements Validator {

	@Override
	public boolean validateTalk(List<Talk> talks) throws InValidTalkException {

		for(Talk talk:talks) {
			if(talk.getTitle().matches(".*\\d+.*"))
				throw new InValidTalkException("Talk "+ talk.getTitle() + " cannot have numbers in title");
			
			if(talk.getTalkTime() > SessionType.MORNING.getSessionDuration() || talk.getTalkTime() > SessionType.AFTERNOON.getSessionDuration())
				throw new InValidTalkException("Talk time bigger for any entire session to hold");
		}
		return true;
	}

	@Override
	public boolean validateTalk(Talk talk, SessionType sType) throws TalkCannotBeScheduledException {
		return false;
	}

}
