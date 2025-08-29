package com.aurionpro.model;

import javax.swing.text.GapContent;

import com.aurionpro.properties.Gender;

public class Student {
	private int id;
	private String name;
	private String address;
	private Gender gender;
	private String city;
	private String subject;
	private String username;
	private String password;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(int id, String name, String address, Gender gender, String city, String subject, String username,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.city = city;
		this.subject = subject;
		this.username = username;
		this.password = password;
	}
	public Student(String name, String address, Gender gender, String city, String subject, String username,
			String password) {
		super();
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.city = city;
		this.subject = subject;
		this.username = username;
		this.password = password;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", gender=" + gender + ", city=" + city
				+ ", subject=" + subject + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
