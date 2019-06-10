package com.tworks.ctracker.scheduler;

import com.tworks.ctracker.entities.Conference;

@FunctionalInterface
public interface Scheduler {
   public Conference schedule() throws Exception;
}
