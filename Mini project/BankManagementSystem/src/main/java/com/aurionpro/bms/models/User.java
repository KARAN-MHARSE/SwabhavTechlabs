package com.aurionpro.bms.models;

import java.sql.Timestamp;
import java.util.List;

import com.aurionpro.bms.properties.Gender;
import com.aurionpro.bms.properties.Role;

public class User {
	private int id;
	private String name;
	private Gender gender;
	private String address;
	private String email;
	private long mobile;
	private long adharNo;
	private String panNo;
	private Role role;
	private List<Document> documents;
	private String password;
	private boolean isActive;
	private Timestamp timestamp;

	public User() {
	}

	public User(int id, String name, Gender gender, String address, String email, long mobile, long adharNo,String panNo, Role role,
			String password, Timestamp timestamp) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
		this.adharNo = adharNo;
		this.panNo = panNo;
		this.role = role;
		this.password = password;
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}
	
	

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public long getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(long adharNo) {
		this.adharNo = adharNo;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	@Override
	public String toString() {
		return "User{id=" + id + ", name='" + name + "', email='" + email + "', role='" + role + "'}";
	}
}
