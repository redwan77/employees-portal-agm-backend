package com.jobcommit.user_requests;

import java.time.LocalTime;

public class EntranceRequest {

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
	private LocalTime requestTime;

	public EntranceRequest() {
		super();
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

	public LocalTime getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(LocalTime requestTime) {
		this.requestTime = requestTime;
	}

	@Override
	public String toString() {
		return "EntranceRequest [IssuerId=" + IssuerId + ", location=" + location + ", requestTime=" + requestTime
				+ "]";
	}

}
