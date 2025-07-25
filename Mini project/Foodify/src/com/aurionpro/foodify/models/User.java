package com.aurionpro.foodify.models;

import java.util.UUID;

public class User {
	private UUID id;
	private String name;
	private Address address;
	private String email;
	private Long mobileNumber;
	private String password;
	
	
	
	public User(String name, Address address, String email, Long mobileNumber,String password) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.address = address;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAdress() {
		return address;
	}
	public void setAdress(Address address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", adress=" + address + ", email=" + email + ", mobileNumber="
				+ mobileNumber + "]";
	}
	
	
	
	
}
