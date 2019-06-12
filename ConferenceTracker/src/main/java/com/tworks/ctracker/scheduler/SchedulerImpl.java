package com.tworks.ctracker.scheduler;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.tworks.ctracker.entities.Conference;
import com.tworks.ctracker.entities.Day;
import com.tworks.ctracker.entities.Session;
import com.tworks.ctracker.entities.SessionType;
import com.tworks.ctracker.entities.Talk;
import com.tworks.ctracker.entities.TalkComparator;
import com.tworks.ctracker.entities.Track;

public class SchedulerImpl implements Scheduler {

	/**
	 * This solution supports only one day.
	 * Assumption is no limits on number of tracks
	 * it accomodates all talks by creating as many tracks as required. 
	 */
	@Override
	public Conference schedule(List<Talk> talks) throws Exception {
		Collections.sort(talks,new TalkComparator());
		Conference conf = scheduleTalksInConference(talks);
		return conf;
	}

	/**
	 *  Conference -> Day -> Tracks -> Sesions -> Talks
	 * @param talk
	 * @param conf
	 */
	private Conference scheduleTalksInConference(List<Talk> talks) {
		  Conference conf = new Conference();
          List<Day> days = new ArrayList<>();
          List<Track> tracks = new ArrayList<>();;
          Day day = new Day();		
          day.setConfDate(LocalDate.now()); //single day conf
          day.setTracks(tracks);
          days.add(day);
          conf.setConfDays(days);   
          
           Queue<Talk> queue = new LinkedList<>(); 
           queue.addAll(talks);
           
           while(!queue.isEmpty())
            {
        	  //create track and when its full(its sessions dont have any more capacity to assign talks) create another one
        	   Track track = new Track();
        	   tracks.add(track);
        	   List<Session> sessions = new ArrayList<>();
        	   track.setSessions(sessions);
        	   // create sessions based on the requirement but in the following order: morning-lunch-afternoon-networking
        	  // add talks to the sessions..before adding validations like max and min talk time.
         	  
        	   //morning session
        	   sessions.add(addTalksToSession(queue, SessionType.MORNING));
        	   sessions.add(addTalksToSession(queue, SessionType.LUNCH));
        	   Session afSession = addTalksToSession(queue, SessionType.AFTERNOON);
        	   sessions.add(afSession);
        	   Session nwSession = addTalksToSession(queue, SessionType.NETWORKING);
        	   
               LocalTime nwStart = getlastTalkEndTimeinAfterNoonSession(afSession);         	   
               Talk talk = new Talk("Networking Event", 0l);
               LocalTime nwCutOffTime = LocalTime.of(16,00);
               talk.setStartTime(nwStart.compareTo(nwCutOffTime) < 0 ? LocalTime.of(16,00): nwStart);
   			   nwSession.getScheduledTalks().add(talk);
        	   sessions.add(nwSession);

          }
          return conf;
	}
	
	
	private LocalTime getlastTalkEndTimeinAfterNoonSession(Session afSession) {
		//edge case
		LocalTime time = LocalTime.of(17,00);
		
		if(afSession.getScheduledTalks() != null && afSession.getScheduledTalks().size() > 0)
		 time = afSession.getScheduledTalks().get(afSession.getScheduledTalks().size()-1).getEndTime();
		return time;
	}
	
	
	private Session addTalksToSession(Queue<Talk> talksQ, SessionType sType) {
		Session session = new Session();

		switch (sType) {
		case MORNING:
		case AFTERNOON: {
			session.setSessionType(sType);
			session.setRemainingMinutes(sType.getSessionDuration());
			LocalTime startTime = sType.getSessionStartTime();
			
			while(!talksQ.isEmpty() && (session.getRemainingMinutes()- talksQ.peek().getTalkTime()) >= 0 ){
				Talk t = talksQ.poll();
				Talk assignedTalk = new Talk(t.getTitle(),t.getTalkTime());
				assignedTalk.setStartTime(startTime);
				assignedTalk.setEndTime(startTime.plusMinutes(t.getTalkTime()));
				startTime = assignedTalk.getEndTime();
				session.getScheduledTalks().add(assignedTalk);
				session.setRemainingMinutes(session.getRemainingMinutes() - assignedTalk.getTalkTime());
			}
		}
			break;
		case LUNCH: {
			session.setSessionType(sType);
			session.setRemainingMinutes(sType.getSessionDuration());

			Talk talk = new Talk("Lunch", 60l);
			talk.setStartTime(sType.getSessionStartTime());
			talk.setEndTime(sType.getSessionEndTime());
			session.getScheduledTalks().add(talk);
     		}
			break;

		case NETWORKING: {
			session.setSessionType(sType);

		}
			break;
		}
		return session;
	}

}
