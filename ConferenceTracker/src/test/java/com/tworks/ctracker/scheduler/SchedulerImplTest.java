package com.tworks.ctracker.scheduler;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tworks.ctracker.entities.Conference;
import com.tworks.ctracker.entities.Talk;
import com.tworks.ctracker.exception.InValidTalkException;

import junit.framework.TestCase;

public class SchedulerImplTest extends TestCase {
	private Scheduler scheduler = new SchedulerImpl();
	Conference conf = null;
	
	
	/*public void testScheduleWithNoTalks() {
	  fail();	
	}
	
	public void testScheduleWithSingleTalk() {
		fail();
		
	}*/
	public void testSchedule_with_one_task_large_enough_for_full_session() {
		List<Talk> talks = new ArrayList<>();
		
		Talk talk = new Talk("Long Talk for a session",230l);
		talks.add(talk);
		try {
			 conf = scheduler.schedule(talks);
		} catch (Exception e) {
			fail("");
		}
		assertTrue(conf.totalNoOfTalks() > 0);
	}
}
