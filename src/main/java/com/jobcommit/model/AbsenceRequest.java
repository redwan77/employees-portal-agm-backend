package com.jobcommit.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "absence_Requests")
public class AbsenceRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate absenceDate;
	private LocalTime absenceStart;
	private LocalTime absenceEnd;
	private String reason;
	private String description;
	private Boolean isSettled;
	private Boolean accepted  ;
	private Boolean verified;

	@ManyToOne
	@JoinColumn(name = "user")
	@JsonIgnoreProperties({"dailyRecords","monthlyRecord","weeklyRecord"})
	private User user;

	public AbsenceRequest() {
		accepted =null;
		// TODO Auto-generated constructor stub
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getAbsenceDate() {
		return absenceDate;
	}

	public void setAbsenceDate(LocalDate absenceDate) {
		this.absenceDate = absenceDate;
	}

	public LocalTime getAbsenceStart() {
		return absenceStart;
	}

	public void setAbsenceStart(LocalTime absenceStart) {
		this.absenceStart = absenceStart;
	}

	public LocalTime getAbsenceEnd() {
		return absenceEnd;
	}

	public void setAbsenceEnd(LocalTime absenceEnd) {
		this.absenceEnd = absenceEnd;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getIsSettled() {
		return isSettled;
	}

	public void setIsSettled(boolean isSettled) {
		this.isSettled = isSettled;
	}

	public Boolean getAccepted() {
		return accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public void setIsSettled(Boolean isSettled) {
		this.isSettled = isSettled;
	}
	
	
	
	

}
