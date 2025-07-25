package com.aurionpro.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.aurionpro.collections.model.Employee;
import com.aurionpro.collections.repo.EmployeesComparator;

public class Sorting {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>(
				Arrays.asList(new Employee(102, "Pratham", 60000), new Employee(108, "Rakesh", 20000),
						new Employee(101, "Prashant", 70000), new Employee(104, "Jayesh", 55000)));
		
		Collections.sort(employees,new EmployeesComparator());
		System.out.println(employees);
		
	}

}
