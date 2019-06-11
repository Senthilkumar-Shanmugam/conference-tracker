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
		}
		return true;
	}

	@Override
	public boolean validateTalk(Talk talk, SessionType sType) throws TalkCannotBeScheduledException {
		return false;
	}

}
