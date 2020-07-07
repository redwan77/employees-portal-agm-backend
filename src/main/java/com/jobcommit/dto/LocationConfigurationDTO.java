package com.jobcommit.dto;

public class LocationConfigurationDTO {
	private Double langitude;
	private Double atitude;
	private Double distance;

	public LocationConfigurationDTO() {
		super();
	}

	public Double getLangitude() {
		return langitude;
	}

	public void setLangitude(Double langitude) {
		this.langitude = langitude;
	}

	public Double getAtitude() {
		return atitude;
	}

	public void setAtitude(Double atitude) {
		this.atitude = atitude;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "LocationConfigurationDTO [langitude=" + langitude + ", atitude=" + atitude + ", distance=" + distance
				+ "]";
	}
	
	
	

}
