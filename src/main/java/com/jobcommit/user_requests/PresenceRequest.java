package com.jobcommit.user_requests;

import java.time.LocalDateTime;

public class PresenceRequest {

	private Long IssuerId;
	private Location location;
	/*
	 * Despite the name, java.util.Date can be used to store both date and time (it
	 * stores UTC milliseconds offset since epoch)
	 * 
	 * I would definitely use the new API because of greater features:
	 * 
	 * Easier format/parsing. The API has its own format/parse methods The API
	 * includes addition/subtraction operation (minusMinutes, plusDays, etc) None of
	 * above are available on java.util.Date
	 * 
	 * Old Date can also be converted into LocalDateTime like this:
	 * 
	 * Date oldDate = ... LocalDateTime newDateTime =
	 * LocalDateTime.from(Instant.ofEpochMilli(oldDate.getTime()));
	 */
	private LocalDateTime requestTime;

	public PresenceRequest() {
		super();
		this.requestTime = LocalDateTime.now();
	}

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

	public LocalDateTime getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(LocalDateTime requestTime) {
		this.requestTime = requestTime;
	}

}
