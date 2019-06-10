package com.tworks.ctracker.entities;

import java.time.LocalTime;

import lombok.Data;

@Data
public class Talk {
	private String title;
	private long talkTime;
	private LocalTime startTime;
	private LocalTime endTime;
}
