package com.aurionpro.serialization.example2;

public class FullTimeEmployee extends Employee {
	private double basicSalary;
	private double homeRentAllowance;
	private double dailyAllowance;

	public FullTimeEmployee(int id, String name, double basicSalary, double homeRentAllowance, double dailyAllowance) {
		super(id, name);
		this.basicSalary = basicSalary;
		this.homeRentAllowance = homeRentAllowance;
		this.dailyAllowance = dailyAllowance;
	}


	@Override
	public double calculateSalary() {
		double salary = (basicSalary+homeRentAllowance+dailyAllowance);
		return salary;
	}
	
	@Override
	public void printDetails() {
		System.out.println("EmployeeID: "+ getId());
		System.out.println("EmployeeName: "+ getName());
		System.out.println("Salary: "+ calculateSalary());
	}

}
