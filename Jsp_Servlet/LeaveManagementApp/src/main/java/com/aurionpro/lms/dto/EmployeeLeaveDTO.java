package com.aurionpro.lms.dto;

import java.sql.Date;

import com.aurionpro.lms.properties.LeaveStatus;

public class EmployeeLeaveDTO {
	private int employeeId;
	private String employeeName;
	private int availableLeaves;
	private int totalLeaves;

	private int leaveId;
	private Date startDate;
	private Date endDate;
	private String reason;
	private LeaveStatus status;
	
	public EmployeeLeaveDTO() {
		super();
	}

	public EmployeeLeaveDTO(int employeeId, String employeeName, int availableLeaves, int totalLeaves, int leaveId,
			Date startDate, Date endDate, String reason, LeaveStatus status) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.availableLeaves = availableLeaves;
		this.totalLeaves = totalLeaves;
		this.leaveId = leaveId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.status = status;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getAvailableLeaves() {
		return availableLeaves;
	}

	public void setAvailableLeaves(int availableLeaves) {
		this.availableLeaves = availableLeaves;
	}

	public int getTotalLeaves() {
		return totalLeaves;
	}

	public void setTotalLeaves(int totalLeaves) {
		this.totalLeaves = totalLeaves;
	}

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public LeaveStatus getStatus() {
		return status;
	}

	public void setStatus(LeaveStatus status) {
		this.status = status;
	}
	
	
}
