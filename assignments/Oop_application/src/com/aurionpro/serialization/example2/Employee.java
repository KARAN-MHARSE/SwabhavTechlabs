package com.aurionpro.serialization.example2;

public abstract class Employee {
	private int id;
	private String name;
	

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
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


	public abstract double calculateSalary();
	public abstract void printDetails();
}
