package com.tworks.ctracker.entities;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Talk {
	@NonNull
	private String title;
	@NonNull
	private long talkTime;
	private LocalTime startTime;
	private LocalTime endTime;
}
