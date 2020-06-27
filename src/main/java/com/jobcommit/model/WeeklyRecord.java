package com.jobcommit.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WeeklyRecord {

	@Id
	private Long id;
	private Double Worked;
	private Double delay;
	private Double theorical;
	private Double verified;

	public WeeklyRecord() {
		// this.theorical = ConfigurationService.getTheoricalTime();
		// presence and worked fields should be calculated in the default constructor so
		// they always fetched updated
	}

	public Double getWorked() {
		return Worked;
	}

	public void setWorked(Double worked) {
		Worked = worked;
	}

	public Double getDelay() {
		return delay;
	}

	public void setDelay(Double delay) {
		this.delay = delay;
	}

	public Double getTheorical() {
		return theorical;
	}

	public void setTheorical(Double theorical) {
		this.theorical = theorical;
	}

	public Double getVerified() {
		return verified;
	}

	public void setVerified(Double verified) {
		this.verified = verified;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
