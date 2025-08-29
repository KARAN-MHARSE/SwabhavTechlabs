package com.aurionpro.lms.dao;

import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.xml.crypto.Data;
import javax.xml.crypto.dsig.dom.DOMValidateContext;

import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;

import com.aurionpro.lms.db.Database;
import com.aurionpro.lms.dto.EmployeeLeaveDTO;
import com.aurionpro.lms.exceptions.DatabaseException;
import com.aurionpro.lms.properties.Leave;
import com.aurionpro.lms.properties.LeaveStatus;
import com.aurionpro.lms.util.DateCalculator;

public class LeaveDao {
	private Connection connection;

	public LeaveDao() {
		this.connection = Database.getConnection();
	}

	public List<Leave> getLeaveSummaryByEmployeeID(int employeeId) throws SQLException {
		List<Leave> leaves = new ArrayList<Leave>();
		String sql = "select * from leave where employee_id = ?;";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, employeeId);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				int leaveId = result.getInt("id");
				Date startDate = result.getDate("start_date");
				Date endDate = result.getDate("end_date");
				String reason = result.getString("reason");
				LeaveStatus status = LeaveStatus.valueOf(result.getString("status"));

				Leave leave = new Leave(leaveId, startDate, endDate, reason, status, employeeId);
				leaves.add(leave);
			}
		}

		return leaves;
	}

	public List<EmployeeLeaveDTO> getAllEmployeesLeaves() {
		List<EmployeeLeaveDTO> leaves = new ArrayList<>();

		String sql = "select\r\n" + "	e.id as employee_id, \r\n" + "	e.name as employee_name,\r\n"
				+ "	e.available_leaves,\r\n" + "	l.id as leave_id,\r\n" + "	l.start_date,\r\n" + "	l.end_date,\r\n"
				+ "	l.reason,\r\n" + "	l.status\r\n" + "from employee e join leave l on e.id=l.employee_id\r\n"
//				+ "where l.status = 'Pending'\r\n"
				+ ";";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				EmployeeLeaveDTO dto = new EmployeeLeaveDTO();
				dto.setEmployeeId(result.getInt("employee_id"));
				dto.setEmployeeName(result.getString("employee_name"));
				dto.setAvailableLeaves(result.getInt("available_leaves"));
				dto.setLeaveId(result.getInt("leave_id"));
				dto.setStartDate(result.getDate("start_date"));
				dto.setEndDate(result.getDate("end_date"));
				dto.setReason(result.getString("reason"));
				dto.setStatus(LeaveStatus.valueOf(result.getString("status")));

				leaves.add(dto);

			}
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		}

		return leaves;

	}

	public boolean applyLeave(Leave leave) throws SQLException {
		try {
			connection.setAutoCommit(false);

			String getUserDate = "select * from employee where id= ?";
			PreparedStatement statement = connection.prepareStatement(getUserDate);
			statement.setInt(1, leave.getEmployeeId());

			ResultSet employeeDetails = statement.executeQuery();
			if (!employeeDetails.next()) {
				throw new RuntimeException("User not found");
			}
			int availableCount = employeeDetails.getInt("available_leaves");

			int requiredLeaves = DateCalculator.findDaysDifference(leave.getStartDate(), leave.getEndDate());

			if (availableCount < requiredLeaves)
				throw new RuntimeException("You dont have balanace leaves");

			String updateLeaveTable = "INSERT INTO leave (start_date, end_date, reason, employee_id) VALUES (?, ?, ?, ?);";
			PreparedStatement updateStatement = connection.prepareStatement(updateLeaveTable);
			updateStatement.setDate(1, leave.getStartDate());
			updateStatement.setDate(2, leave.getEndDate());
			updateStatement.setString(3, leave.getReason());
			updateStatement.setInt(4, leave.getEmployeeId());

			int updatedRows2 = updateStatement.executeUpdate();
			if (updatedRows2 <= 0)
				throw new RuntimeException("Something went wrong ");

			connection.commit();
			return true;

		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public boolean approveLeave(int leaveId) throws SQLException {
//		1.check connection is null or not
		if (connection == null)
			throw new DatabaseException("Connection is null");
		connection.setAutoCommit(false);

		Leave leave = new Leave();
		int availableLeaves = 0;

		try {
			String getLeaveTableQuery = "select * from leave where id = ? and status='Pending';";
			try (PreparedStatement getStatement = connection.prepareStatement(getLeaveTableQuery)) {
				getStatement.setInt(1, leaveId);

				ResultSet leaveResult = getStatement.executeQuery();
				if (!leaveResult.next())
					throw new RuntimeException("Leave not found");

				leave.setEmployeeId(leaveResult.getInt("employee_id"));
				leave.setStatus(LeaveStatus.valueOf(leaveResult.getString("status")));
				leave.setStartDate(leaveResult.getDate("start_date"));
				leave.setEndDate(leaveResult.getDate("end_date"));

				if (leave.getStatus() == LeaveStatus.Approved || leave.getStatus() == LeaveStatus.Rejected) {
					throw new RuntimeException("Leave is already accepted or rejected");
				}
			}

			String getEmployeeQuery = "select * from employee where id = ?";
			try (PreparedStatement getEmployeeStatement = connection.prepareStatement(getEmployeeQuery)) {
				getEmployeeStatement.setInt(1, leave.getEmployeeId());
				ResultSet employeeDetails = getEmployeeStatement.executeQuery();
				if (!employeeDetails.next())
					throw new RuntimeException("Employee details not found");
				availableLeaves = employeeDetails.getInt("available_leaves");
			}
			
			int totalAppliedLeaves = DateCalculator.findDaysDifference(leave.getStartDate(), leave.getEndDate());			
			if(availableLeaves < totalAppliedLeaves) {
				rejectLeave(leaveId);
			}

			String updateLeaveTableQuery = "update leave set status='Approved' where id =?;";
			try (PreparedStatement updateLeaveTableStatement = connection.prepareStatement(updateLeaveTableQuery)) {
				updateLeaveTableStatement.setInt(1, leaveId);
				int updatedRows = updateLeaveTableStatement.executeUpdate();
				if (updatedRows <= 0)
					throw new RuntimeException("Leaves not updated");
			}

			String updateEmployeeTableQuery = "update employee set available_leaves = ? where id=?;";
			try (PreparedStatement updateEmployeeTableStatement = connection
					.prepareStatement(updateEmployeeTableQuery)) {
				updateEmployeeTableStatement.setInt(1, availableLeaves - totalAppliedLeaves);
				updateEmployeeTableStatement.setInt(2, leave.getEmployeeId());
				int updatedRows = updateEmployeeTableStatement.executeUpdate();
				if (updatedRows <= 0)
					throw new RuntimeException("Employee leaves not updated, Try again");

			}

			connection.commit();
			return true;

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		} finally {
			connection.setAutoCommit(true);
		}
	}

	
	public boolean rejectLeave(int leaveId) throws SQLException {
		if(connection == null) throw new DatabaseException();
		
		String sql = "update leave set status='Rejected' where id =? and status='Pending';";
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1, leaveId);
			
			int updatedRows = statement.executeUpdate();
			if(updatedRows<=0) throw new RuntimeException("Status not updated, try again");
			return true;
		}
		
	}
}
