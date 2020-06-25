package com.jobcommit.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CompanyConfiguration {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// work modes
	private boolean isRemoteMode;
	private boolean isHolidayMode;
	// Localization
	private Double longitude;
	private Double latitude;
	// Timing
	private LocalTime startTime;
	private LocalTime endTime;
	private Byte margin; // Byte is compatible with numbers that do not exceed (2 pow 8 )
	private boolean isMarginActivated;

	public CompanyConfiguration() {
		super();
	}

	public boolean isRemoteMode() {
		return isRemoteMode;
	}

	public void setRemoteMode(boolean isRemoteMode) {
		this.isRemoteMode = isRemoteMode;
	}

	public boolean isHolidayMode() {
		return isHolidayMode;
	}

	public void setHolidayMode(boolean isHolidayMode) {
		this.isHolidayMode = isHolidayMode;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
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

	public Byte getMargin() {
		return margin;
	}

	public void setMargin(Byte margin) {
		this.margin = margin;
	}

	public boolean isMarginActivated() {
		return isMarginActivated;
	}

	public void setMarginActivated(boolean isMarginActivated) {
		this.isMarginActivated = isMarginActivated;
	}

}
