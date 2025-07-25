package com.aurionpro.collections.model;

import com.aurionpro.collections.repo.EmployeesComparator;

public class Employee  {
	private int id;
	private String name;
	private int salary;
	
	
	public Employee(int id, String name, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
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


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


//	@Override
	public int compareTo(Employee employee) {
		return this.salary-employee.getSalary();
	}


	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", salary=" + salary + "]\n";
	}
	
	
	
	
	
	
}
