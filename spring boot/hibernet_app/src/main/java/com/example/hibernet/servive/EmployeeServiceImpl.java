package com.example.hibernet.servive;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hibernet.dao.EmployeeDao;
import com.example.hibernet.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Employee addNewEmployee(Employee employee) {
		return employeeDao.addNewEmployee(employee);
	}

	@Override
	public List<Employee> readAllEmployees() {
		return employeeDao.readAllEmployees();

	}

	@Override
	public Employee readEmployeeById(int employeeId) {
		return employeeDao.readEmployeeById(employeeId);

	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);

	}

	@Override
	public List<Employee> readEmployeeByName(String name) {
		return employeeDao.readEmployeeByName(name);
	}

}
