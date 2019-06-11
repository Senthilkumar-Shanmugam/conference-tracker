package com.tworks.ctracker.entities;

import java.util.Comparator;

public class TalkComparator implements Comparator<Talk> {

	@Override
	public int compare(Talk arg0, Talk arg1) {
		if(arg0.getTalkTime() < arg1.getTalkTime()){
            return 1;
        } else {
            return -1;
        }
	}

}
