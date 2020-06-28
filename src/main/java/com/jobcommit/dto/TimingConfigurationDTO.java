package com.jobcommit.dto;

import java.time.LocalTime;

public class TimingConfigurationDTO {

	private LocalTime startTime;
	private LocalTime endTime;
	private Float margin;
	private Boolean isMarginActivated;
	private Float theoricalDailyWorkedTime;
	private Float theoricalMonthlyWorkedTime;
	private Float theoricalWeeklyWorkedTime;

	public TimingConfigurationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Float getTheoricalDailyWorkedTime() {
		return theoricalDailyWorkedTime;
	}

	public void setTheoricalDailyWorkedTime(Float theoricalDailyWorkedTime) {
		this.theoricalDailyWorkedTime = theoricalDailyWorkedTime;
	}

	public Float getTheoricalMonthlyWorkedTime() {
		return theoricalMonthlyWorkedTime;
	}

	public void setTheoricalMonthlyWorkedTime(Float theoricalMonthlyWorkedTime) {
		this.theoricalMonthlyWorkedTime = theoricalMonthlyWorkedTime;
	}

	public Float getTheoricalWeeklyWorkedTime() {
		return theoricalWeeklyWorkedTime;
	}

	public void setTheoricalWeeklyWorkedTime(Float theoricalWeeklyWorkedTime) {
		this.theoricalWeeklyWorkedTime = theoricalWeeklyWorkedTime;
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

	public Boolean getIsMarginActivated() {
		return isMarginActivated;
	}

	public void setIsMarginActivated(Boolean isMarginActivated) {
		this.isMarginActivated = isMarginActivated;
	}

}







