package com.tworks.ctracker.scheduler;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tworks.ctracker.entities.Talk;
import com.tworks.ctracker.exception.InValidTalkException;

import junit.framework.TestCase;


public class ValidateImplTest extends TestCase{
	Validator validator = new ValidatorImpl();

	@Test(expected=InValidTalkException.class)
	public void testTitleDoesNotHaveNumber_throws_Exception() throws Exception {
        List<Talk> talks = new ArrayList<>();
		
		Talk talk = new Talk("Long Talk8 for a session",10l);
		talks.add(talk);
		validator.validateTalk(talks);
	}
	
	
	public void testTalkLongerThanAnyFullSessionIsNotAllowed() {
		fail();
	}
	

}
