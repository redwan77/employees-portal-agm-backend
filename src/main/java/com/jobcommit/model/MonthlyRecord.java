package com.jobcommit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MonthlyRecord {
	
	@Id
	private Long id ;
	
	private Double Worked;
	private Double delay;
	private Double theorical;
	private Double verified;
	@ManyToOne
	@JoinColumn(name = "user")
	@JsonIgnore
	private User user ;
	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	public MonthlyRecord() {
		
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
