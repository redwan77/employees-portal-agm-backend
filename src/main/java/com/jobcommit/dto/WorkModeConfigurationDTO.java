package com.jobcommit.dto;

public class WorkModeConfigurationDTO {
	
	private boolean isRemote ;
	private boolean  isHoliday ;
	
	
	
	public boolean getIsRemote() {
		return isRemote;
	}



	public void setRemote(boolean isRemote) {
		this.isRemote = isRemote;
	}



	public boolean getIsHoliday() {
		return isHoliday;
	}



	public void setHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
	}



	@Override
	public String toString() {
		return "WorkModeConfigurationDTO [isRemote=" + isRemote + ", isHoliday=" + isHoliday + "]";
	}

	
}
