package com.jobcommit.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DailyRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalTime entranceTime;
	private LocalTime exitTime;
	private LocalDate date;
	private LocalTime latestEntranceTime;

	private Integer breaks;
	private Double Worked;
	private Double delay;
	private Double theorical;

	@ManyToOne
	@JoinColumn(name = "user")
	@JsonIgnore
	private User user;

	/*
	 * ******** IF WE WANTED TO USER A ENUM INSTEAD OF VALUES FROM DB *******
	 * 
	 * @ElementCollection(targetClass = ExitReason.class)
	 * 
	 * @Enumerated(EnumType.STRING) // Possibly optional (I'm not sure) but defaults
	 * to ORDINAL.
	 * 
	 * @CollectionTable(name = "daily_exitsReasons")
	 * 
	 * @Column(name = "reasons") // Column name in person_interest private
	 * Set<ExitReason> exitReasons;
	 */
	@OneToMany
	Set<ExitReason> exitReasons;

	public DailyRecord() {
		super();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

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

	public Set<ExitReason> getExitReasons() {
		return exitReasons;
	}

	public void setExitReasons(Set<ExitReason> exitReasons) {
		this.exitReasons = exitReasons;
	}

	public LocalTime getLatestEntranceTime() {
		return latestEntranceTime;
	}

	public void setLatestEntranceTime(LocalTime latestEntranceTime) {
		this.latestEntranceTime = latestEntranceTime;
	}

	@Override
	public String toString() {
		return "DailyRecord [id=" + id + ", entranceTime=" + entranceTime + ", exitTime=" + exitTime + ", date=" + date
				+ ", breaks=" + breaks + ", Worked=" + Worked + ", delay=" + delay + ", theorical=" + theorical
				+ ", exitReasons=" + exitReasons + "]";
	}

}
