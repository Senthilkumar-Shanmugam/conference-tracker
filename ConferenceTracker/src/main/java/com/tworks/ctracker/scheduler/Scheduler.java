package com.tworks.ctracker.scheduler;

import java.util.List;

import com.tworks.ctracker.entities.Conference;
import com.tworks.ctracker.entities.Talk;

@FunctionalInterface
public interface Scheduler {
   public Conference schedule(List<Talk> talks) throws Exception;
}
