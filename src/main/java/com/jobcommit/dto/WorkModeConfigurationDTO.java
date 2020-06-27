package com.jobcommit.dto;

public class WorkModeConfigurationDTO {
	
	private boolean isRemote ;
	private boolean  isHoliday ;
	
	
	public boolean isRemote() {
		return isRemote;
	}
	public void setRemote(boolean isRemote) {
		this.isRemote = isRemote;
	}
	public boolean isHoliday() {
		return isHoliday;
	}
	public void setHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
	}
	public WorkModeConfigurationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
