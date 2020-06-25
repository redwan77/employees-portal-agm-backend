package com.jobcommit.dto;

public class UserUpdateDTO {

	private boolean markAsRemote;
	private boolean markAsHoliday;

	public UserUpdateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isMarkAsRemote() {
		return markAsRemote;
	}

	public void setMarkAsRemote(boolean markAsRemote) {
		this.markAsRemote = markAsRemote;
	}

	public boolean isMarkAsHoliday() {
		return markAsHoliday;
	}

	public void setMarkAsHoliday(boolean markAsHoliday) {
		this.markAsHoliday = markAsHoliday;
	}

}
