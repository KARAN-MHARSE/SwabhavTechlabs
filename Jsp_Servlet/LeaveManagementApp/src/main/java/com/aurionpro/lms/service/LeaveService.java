package com.aurionpro.lms.service;

import java.sql.SQLException;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.aurionpro.lms.dao.LeaveDao;
import com.aurionpro.lms.dto.EmployeeLeaveDTO;
import com.aurionpro.lms.exceptions.DatabaseException;
import com.aurionpro.lms.properties.Leave;

public class LeaveService {
	private LeaveDao leaveDao;
	
	public LeaveService() {
		this.leaveDao = new LeaveDao();
	}
	
	public boolean applyLeave(Leave leave)  {
		try {
			if(leave.getEndDate().before(leave.getStartDate())) {
				throw new RuntimeException("End date should be later than start date");
			}
			return leaveDao.applyLeave(leave);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public List<Leave> getLeaveSummaryByEmployeeID(int employeeId){
		try {
			return leaveDao.getLeaveSummaryByEmployeeID(employeeId);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public List<EmployeeLeaveDTO> getAllEmployeesLeaves(){
		return leaveDao.getAllEmployeesLeaves();
	}
	
	public boolean approveLeave(int leaveId) {
		try {
			return leaveDao.approveLeave(leaveId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public boolean rejectLeave(int leaveId) {
		try {
			return leaveDao.rejectLeave(leaveId);
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

}
