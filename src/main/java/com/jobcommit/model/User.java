package com.jobcommit.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String adress;
	// state
	private boolean isRemote;
	private boolean isInHoliday;
	private boolean isOut;

	@Enumerated(EnumType.STRING)
	private Role role;

	/*
	 * orphalanRemoval mens that in an In memory operation if we remove a child
	 * entity from the collection of the parent entity (set to null or remove) and
	 * apply saver to the parent that should affect the DB to remove the child
	 * entity (it is an ORM specification)
	 */
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	List<DailyRecord> dailyRecords;
	@OneToMany(cascade = CascadeType.ALL)
	List<MonthlyRecord> monthlyRecord;
	@OneToMany(cascade = CascadeType.ALL)
	List<WeeklyRecord> weeklyRecord;

	public User() {
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isRemote() {
		return isRemote;
	}

	public void setRemote(boolean isRemote) {
		this.isRemote = isRemote;
	}

	public boolean isInHoliday() {
		return isInHoliday;
	}

	public void setInHoliday(boolean isInHoliday) {
		this.isInHoliday = isInHoliday;
	}

	public boolean isOut() {
		return isOut;
	}

	public void setOut(boolean isOut) {
		this.isOut = isOut;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

}
