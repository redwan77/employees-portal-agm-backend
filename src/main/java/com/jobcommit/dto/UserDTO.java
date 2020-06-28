package com.jobcommit.dto;

public class UserDTO {

	public void setRemote(boolean isRemote) {
		this.isRemote = isRemote;
	}
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", adress=" + adress + ", isRemote=" + isRemote + "]";
	}

	private Long id;
	private String name;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String adress;
	private boolean isRemote;
	
	
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
	public boolean getIsRemote() {
		return isRemote;
	}
	public void setIsRemote(boolean isRemote) {
		this.isRemote = isRemote;
	}
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
