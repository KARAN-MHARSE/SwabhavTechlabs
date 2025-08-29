package com.aurionpro.lms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.lms.dto.EmployeeLeaveDTO;
import com.aurionpro.lms.model.Employee;
import com.aurionpro.lms.service.LeaveService;

/**
 * Servlet implementation class AdminLeaveController
 */
@WebServlet("/AdminLeaveController")
public class AdminLeaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LeaveService leaveService;

	public AdminLeaveController() {
		super();
		leaveService = new LeaveService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		try {
			if(employee== null) {
				session.invalidate();
				response.sendRedirect("Login.jsp");
				return;
			}
			
			List<EmployeeLeaveDTO> employeeLeaves = leaveService.getAllEmployeesLeaves();
			request.setAttribute("employeeLeaves", employeeLeaves);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("AdminDashBoard.jsp");
			dispatcher.forward(request, response);
		}
		catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e1) {
				
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			String action = request.getParameter("action");
			int leaveId = Integer.parseInt(request.getParameter("leaveId"));

			if (action.equalsIgnoreCase("approved")) {
				boolean isApproved = leaveService.approveLeave(leaveId);

			} else if (action.equalsIgnoreCase("reject")) {
				boolean isRejected = leaveService.rejectLeave(leaveId);

			}
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e1) {
				
			}
		}

		doGet(request, response);
	}

}
