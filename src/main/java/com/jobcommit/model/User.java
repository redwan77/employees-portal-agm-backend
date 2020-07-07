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
	private boolean isHoliday;
	private boolean isOut;

	// security
	private String login;
	private String password;

	public void setPassword(String password) {
		this.password = password;
	}

	@Enumerated(EnumType.STRING)
	private Role role;

	/*
	 * orphalanRemoval mens that in an In memory operation if we remove a child
	 * entity from the collection of the parent entity (set to null or remove) and
	 * apply saver to the parent that should affect the DB to remove the child
	 * entity (it is an ORM specification)
	 */
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	List<DailyRecord> dailyRecords;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	List<MonthlyRecord> monthlyRecord;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	List<WeeklyRecord> weeklyRecord;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<DailyRecord> getDailyRecords() {
		return dailyRecords;
	}

	public void setDailyRecords(List<DailyRecord> dailyRecords) {
		this.dailyRecords = dailyRecords;
	}

	public List<MonthlyRecord> getMonthlyRecord() {
		return monthlyRecord;
	}

	public void setMonthlyRecord(List<MonthlyRecord> monthlyRecord) {
		this.monthlyRecord = monthlyRecord;
	}

	public List<WeeklyRecord> getWeeklyRecord() {
		return weeklyRecord;
	}

	public void setWeeklyRecord(List<WeeklyRecord> weeklyRecord) {
		this.weeklyRecord = weeklyRecord;
	}

	public boolean getIsRemote() {
		return isRemote;
	}

	public void setIsRemote(boolean isRemote) {
		this.isRemote = isRemote;
	}

	public boolean getIsHoliday() {
		return isHoliday;
	}

	public void setIsHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
	}

	public boolean getIsOut() {
		return isOut;
	}

	public void setIsOut(boolean isOut) {
		this.isOut = isOut;
	}

}
