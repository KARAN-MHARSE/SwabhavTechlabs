package com.aurionpro.collections.repo;

import java.util.Comparator;

import com.aurionpro.collections.model.Employee;

public class EmployeesComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getSalary()-o2.getSalary();
	}

}
