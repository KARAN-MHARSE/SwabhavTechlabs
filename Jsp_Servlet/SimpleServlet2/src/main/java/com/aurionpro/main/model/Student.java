package com.aurionpro.main.model;

import com.aurionpro.main.properties.Gender;
import com.aurionpro.main.properties.Subject;

public class Student {
	private int studentId;
	private String name;
	private String address;
	private Gender gender;
	private String city;
	private Subject subject;
	private String userName;
	private String password;
	
	public Student() {
		super();
	}
	
	public Student(int studentId, String name, String address, Gender gender, String city, Subject subject,
			String userName, String password) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.city = city;
		this.subject = subject;
		this.userName = userName;
		this.password = password;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", address=" + address + ", gender=" + gender
				+ ", city=" + city + ", subject=" + subject + ", userName=" + userName + ", password=" + password + "]";
	}

	
	
	
	
	
	

}
