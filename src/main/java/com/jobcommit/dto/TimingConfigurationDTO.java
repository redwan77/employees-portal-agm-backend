package com.jobcommit.dto;

import java.time.LocalTime;

public class TimingConfigurationDTO {

	private LocalTime startTime;
	private LocalTime endTime;
	private Float margin;
	private Float theorical ;

	public Float getTheorical() {
		return theorical;
	}

	public void setTheorical(Float theorical) {
		this.theorical = theorical;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public Float getMargin() {
		return margin;
	}

	public void setMargin(Float margin) {
		this.margin = margin;
	}

	public TimingConfigurationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
