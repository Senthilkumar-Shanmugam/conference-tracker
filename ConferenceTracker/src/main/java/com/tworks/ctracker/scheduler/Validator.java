package com.tworks.ctracker.scheduler;

import java.util.List;

import com.tworks.ctracker.entities.SessionType;
import com.tworks.ctracker.entities.Talk;
import com.tworks.ctracker.exception.InValidTalkException;
import com.tworks.ctracker.exception.TalkCannotBeScheduledException;

public interface Validator {
   public boolean validateTalk(List<Talk> talks) throws InValidTalkException;
   public boolean validateTalk(Talk talk,SessionType sType) throws TalkCannotBeScheduledException;
}
