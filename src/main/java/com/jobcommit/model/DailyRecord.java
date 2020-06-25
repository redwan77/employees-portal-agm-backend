package com.jobcommit.model;

import java.time.LocalTime;

public class DailyRecord {

	private LocalTime entrance;
	private LocalTime exit;
	private Integer breaks;
	private Float Worked  ;

	public DailyRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocalTime getEntrance() {
		return entrance;
	}

	public void setEntrance(LocalTime entrance) {
		this.entrance = entrance;
	}

	public LocalTime getExit() {
		return exit;
	}

	public void setExit(LocalTime exit) {
		this.exit = exit;
	}

	public Integer getBreaks() {
		return breaks;
	}

	public void setBreaks(Integer breaks) {
		this.breaks = breaks;
	}

}
