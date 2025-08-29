package com.example.hibernet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hibernet.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private EntityManager manager;

	@Override
	@Transactional
	public Employee addNewEmployee(Employee employee) {
//		TypedQuery<Employee> query = manager.createQuery("insert into Employee)
		return manager.merge(employee);
	}

	@Override
	public List<Employee> readAllEmployees() {
		TypedQuery<Employee> query = manager.createQuery("select e from Employee e",Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee readEmployeeById(int employeeId) {
		TypedQuery<Employee> query = manager.createQuery("select e from Employee e where id=:employeeId",Employee.class);
		query.setParameter("employeeId", employeeId);
		return query.getSingleResult();
	}

	@Override
	@Transactional
	public Employee updateEmployee(Employee employee) {
		
		return null;
	}

	@Override
	public List<Employee> readEmployeeByName(String name) {
		TypedQuery<Employee> query = manager.createQuery("select e from Employee e where name=:name",Employee.class);
		query.setParameter("name", name);
		return query.getResultList();
	}

}
