package com.jobcommit.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DailyRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalTime entranceTime;
	private LocalTime exitTime;
	private Integer breaks;
	private Double Worked;
	private Double delay;
	private Double theorical;

	
	
	public LocalTime getEntranceTime() {
		return entranceTime;
	}

	public void setEntranceTime(LocalTime entranceTime) {
		this.entranceTime = entranceTime;
	}

	public LocalTime getExitTime() {
		return exitTime;
	}

	public void setExitTime(LocalTime exitTime) {
		this.exitTime = exitTime;
	}

	public DailyRecord() {
		super();
		// this.theorical = ConfigurationService.getTheoricalTime();
		// presence and worked fields should be calculated in the default constructor so
		// they always fetched updated
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTheorical() {
		return theorical;
	}

	public void setTheorical(Double theorical) {
		this.theorical = theorical;
	}

	

	public Integer getBreaks() {
		return breaks;
	}

	public void setBreaks(Integer breaks) {
		this.breaks = breaks;
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

}
