package com.aurionpro.streams.model;

import javax.security.auth.callback.LanguageCallback;

public class EmployeeAccount {
	private int id;
	private String fName;
	private String lName;
	private double salary;
	private static int count=0;
	
	
	public EmployeeAccount(String fName,String lName, double salary) {
		this.id = 100+count;
		count++;
		this.fName = fName;
		this.lName = lName;
		this.salary = salary;
	}


	public int getId() {
		return id;
	}
	public String getFName() {
		return fName;
	}
	public void setName(String fName) {
		this.fName= fName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "EmployeeAccount [id=" + id + ", fName=" + fName + ", lName=" + lName + ", salary=" + salary + "]";
	}


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public static int getCount() {
		return count;
	}


	public static void setCount(int count) {
		EmployeeAccount.count = count;
	}


	public void setId(int id) {
		this.id = id;
	}



	
	
	

}
