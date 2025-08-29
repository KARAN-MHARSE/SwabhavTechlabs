package com.aurionpro.lms.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.lang.jstl.EnumeratedMap;

import com.aurionpro.lms.model.Employee;
import com.aurionpro.lms.properties.Leave;
import com.aurionpro.lms.properties.LeaveStatus;
import com.aurionpro.lms.service.LeaveService;

/**
 * Servlet implementation class EmployeeLeaveController
 */
@WebServlet("/EmployeeLeaveController")
public class EmployeeLeaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LeaveService leaveService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeLeaveController() {
		super();
		this.leaveService = new LeaveService();
	}

	/**
	 * @throws IOException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		Employee employee = (Employee) session.getAttribute("employee");

		try {

			if (employee == null) {
				response.sendRedirect("login.jsp");
				return;
			}

			List<Leave> leaves = leaveService.getLeaveSummaryByEmployeeID(employee.getId());
			request.setAttribute("leaves", leaves);

			for (Leave leave : leaves) {
				System.out.println(leave);
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeDashBoard.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			java.util.Date utilStart = sdf.parse(request.getParameter("startDate"));
			java.util.Date utilEnd = sdf.parse(request.getParameter("endDate"));

			Date startDate = new Date(utilStart.getTime()); // convert util.Date → sql.Date
			Date endDate = new Date(utilEnd.getTime());

			String reason = request.getParameter("reason");

			HttpSession session = request.getSession();
			Employee employee = (Employee) session.getAttribute("employee");
			System.out.println(employee);

			Leave leave = new Leave();
			leave.setEmployeeId(employee.getId());
			leave.setStartDate(startDate);
			leave.setEndDate(endDate);
			leave.setReason(reason);

			boolean isApplied = leaveService.applyLeave(leave);
//			if (isApplied) {
//				response.getWriter().append("Applied");
//			} else {
//				response.getWriter().append("Failed");
//			}
			doGet(request, response);

		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e1) {

			}
		}

	}

}
