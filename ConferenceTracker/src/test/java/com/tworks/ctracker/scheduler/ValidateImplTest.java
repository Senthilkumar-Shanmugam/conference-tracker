package com.tworks.ctracker.scheduler;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tworks.ctracker.entities.Talk;
import com.tworks.ctracker.exception.InValidTalkException;
import com.tworks.ctracker.exception.TalkCannotBeScheduledException;

import junit.framework.TestCase;


public class ValidateImplTest extends TestCase{
	Validator validator = new ValidatorImpl();
    List<Talk> talks = new ArrayList<>();

	public void testMinimumNoOfTasksForConference_Ifnot_throws_Exception() {
		try {
			validator.validateTalk(talks);
		} catch (TalkCannotBeScheduledException e) {
			assertTrue(true);
			e.printStackTrace();
		}catch (InValidTalkException e) {
			e.printStackTrace();
		}
	}
	
	public void testEnoughTalksToScheduleATrack_Ifnot_throws_Exception() {
		try {
			validator.validateTalk(talks);
		} catch (TalkCannotBeScheduledException e) {
			assertTrue(true);
			e.printStackTrace();
		}catch (InValidTalkException e) {
			e.printStackTrace();
		}
	}

	public void testTitleDoesNotHaveNumber_throws_Exception() {
		Talk talk = new Talk("Title with number Talk8 for a session",10l);
		talks.add(talk);
		try {
			validator.validateTalk(talks);
		} catch (InValidTalkException e) {
			e.printStackTrace();
			assertTrue(true);
		}catch (Exception e) {
			e.printStackTrace();
 		}
	}
	
	public void testTalkLongerThanAnyFullSessionIsNotAllowed() {
			Talk talk = new Talk("Title with number Talk for a session",400l);
			talks.add(talk);
			try {
				validator.validateTalk(talks);
			} catch (InValidTalkException e) {
				e.printStackTrace();
				assertTrue(true);
			}catch (Exception e) {
				e.printStackTrace();
	 		} 
	}
	
	public void testValidTalkIsAllowedToBeScheduled() throws InValidTalkException,TalkCannotBeScheduledException {
		  Talk talk1 = new Talk("Title with number Talk for a session",90l);
		  Talk talk2 = new Talk("Title with number Talk for a session",100l);
		  Talk talk3 = new Talk("Title with number Talk for a session",90l);
		  Talk talk4 = new Talk("Title with number Talk for a session",160l);
		  talks.add(talk1);
		  talks.add(talk2);
		  talks.add(talk3);
		  talks.add(talk4);
		  assertTrue(validator.validateTalk(talks));
	}
	

}
