package com.aurionpro.serialization.example2;

public class PartTimeEmployee extends Employee {
	private double hoursWorked;
	private double rateForHours;
	

	public PartTimeEmployee(int id, String name, double hoursWorked, double rateForHour) {
		super(id, name);
		this.hoursWorked = hoursWorked;
		this.rateForHours = rateForHour;
	}


	@Override
	public double calculateSalary() {
		double salary = hoursWorked*rateForHours;
		return salary;
	}
	
	@Override
	public void printDetails() {
		System.out.println("EmployeeID: "+getId()+"\nEmployeeName: "+getName()+"\nSalary: "+ calculateSalary());;
	}
}
