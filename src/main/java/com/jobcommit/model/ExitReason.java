package com.jobcommit.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExitReason {

	//BREAKFAST, DINNER, PRIVATE, URGENCE
	
	@Id
	private Long id ;
	private String name;
	
	
	public ExitReason() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
