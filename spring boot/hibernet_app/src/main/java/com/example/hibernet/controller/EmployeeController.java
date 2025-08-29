package com.example.hibernet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hibernet.dao.EmployeeDao;
import com.example.hibernet.entity.Employee;
import com.example.hibernet.servive.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/employeeapp")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees{name}")
	public List<Employee> readAllEmployees(@RequestParam(required = false) String name) {
		if(name!=null) return employeeService.readEmployeeByName(name);
		
		return employeeService.readAllEmployees();
	}
	
	@PostMapping("/employees")
	public Employee addNewEmployee(@RequestBody Employee employee) {
		return employeeService.addNewEmployee(employee);
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getMethodName(@PathVariable int employeeId) {
		return employeeService.readEmployeeById(employeeId);
	}
	
	
	
}
