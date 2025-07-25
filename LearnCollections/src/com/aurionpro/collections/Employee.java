package com.aurionpro.collections;

public class Employee {
	private int employeeId;
	private String employeeName;
	private String department;
	public Employee(int employeeId, String employeeName, String department) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", department=" + department
				+ "]";
	}
	
	

}
