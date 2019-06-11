package com.tworks.ctracker.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.tworks.ctracker.common.CTrackerConstants;
import com.tworks.ctracker.entities.Conference;
import com.tworks.ctracker.entities.Day;
import com.tworks.ctracker.entities.Session;
import com.tworks.ctracker.entities.Talk;
import com.tworks.ctracker.entities.Track;
import com.tworks.ctracker.manager.ConferenceManager;
import com.tworks.ctracker.manager.ConferenceManagerImpl;
import com.tworks.ctracker.scheduler.SchedulerImpl;

public class ConferenceManagementClient {

	public static void main(String[] args) throws Exception {
		
		String filename = args[0];
		List<Talk> talks = parseInputFile(filename);
		
		Conference conf = scheduleTalks(talks);
		
		displayConfDetails(conf);
		
	}
	
	private static List<Talk> parseInputFile(String fileName) {
	    List<Talk> talks = new ArrayList<>();	
		
		try(BufferedReader bReader = new BufferedReader(new InputStreamReader(
				ConferenceManagementClient.class.getClass().getResourceAsStream("/" + fileName)))){
		
		 String line;
		 while ((line = bReader.readLine()) != null) {
            if(line.isEmpty())
                 continue;

             String title = line.substring(0, line.lastIndexOf(" "));
             String minutes = line.substring(line.lastIndexOf(" ") + 1);
 
             String mins = line.replaceAll("\\D+", "");
             Talk talk = null;
             
             if(minutes.equals(CTrackerConstants.LIGHTNING_TALK)) {
                  talk = new Talk(title,CTrackerConstants.LIGHTNING_TALK_MINS);
             }else {
                  talk = new Talk(title, Long.parseLong(mins));
             }
             talks.add(talk);
          }
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return talks;	
	}
	
	//Schedule talks
	private  static Conference scheduleTalks(List<Talk> talks) throws Exception {
		ConferenceManager cManager = new ConferenceManagerImpl(new SchedulerImpl());
		Conference conf = cManager.scheduleTalks(talks);
		return conf;
	}
	
	//display conference schedule
	private static void displayConfDetails(Conference conf) {
		String pattern = "hh:mm a";
		int tno=1;
		  for(Day day: conf.getConfDays()) {
			  for(Track track: day.getTracks()) {
				  System.out.println("Track "+(tno++)+":");
				  System.out.println();
				  for(Session s :track.getSessions()) {
					  for(Talk talk:s.getScheduledTalks()) {
						  System.out.println(talk.getStartTime().format(DateTimeFormatter.ofPattern(pattern))+" "+talk.getTitle()+" "+talk.getTalkTime()+"min");
					  }
				  }
			  }
	}
}
}
