package com.example.hibernet.dao;

import java.util.List;

import com.example.hibernet.entity.Employee;

public interface EmployeeDao {
	Employee addNewEmployee(Employee employee);
	List<Employee> readAllEmployees();
	Employee readEmployeeById(int employeeId);
	Employee updateEmployee(Employee employee);
	List<Employee> readEmployeeByName(String name);

}
