package com.jobcommit.user_requests;

import java.time.LocalTime;

import com.jobcommit.model.ExitReason;

public class ExitRequest {
	
	private Long IssuerId;
	private Location location;
	private LocalTime requestTime;
	
	private ExitReason reason ;
	
	
	public Long getIssuerId() {
		return IssuerId;
	}
	public void setIssuerId(Long issuerId) {
		IssuerId = issuerId;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public LocalTime getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(LocalTime requestTime) {
		this.requestTime = requestTime;
	}
	public ExitRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExitReason getReason() {
		return reason;
	}
	public void setReason(ExitReason reason) {
		this.reason = reason;
	}
	
}
