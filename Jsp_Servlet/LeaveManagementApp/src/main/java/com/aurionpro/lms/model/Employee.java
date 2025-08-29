package com.aurionpro.lms.model;

import com.aurionpro.lms.properties.Role;

public class Employee {
	private int id;
	private String name;
	private String email;
	private int totalLeaves;
	private int availableLeaves;
	private Role role;
	private String password;
	public Employee() {
		super();
	}
	public Employee(int id, String name, String email, int totalLeaves, int availableLeaves, Role role,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.totalLeaves = totalLeaves;
		this.availableLeaves = availableLeaves;
		this.role = role;
		this.password = password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTotalLeaves() {
		return totalLeaves;
	}
	public void setTotalLeaves(int totalLeaves) {
		this.totalLeaves = totalLeaves;
	}
	public int getAvailableLeaves() {
		return availableLeaves;
	}
	public void setAvailableLeaves(int availableLeaves) {
		this.availableLeaves = availableLeaves;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", totalLeaves=" + totalLeaves
				+ ", availableLeaves=" + availableLeaves + ", role=" + role + ", password=" + password + "]";
	}
	
	
	
	
	

}
