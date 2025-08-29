package com.aurionpro.lms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import com.aurionpro.lms.model.Employee;

@WebFilter(urlPatterns = {"/EmployeeLeaveController","/AdminLeaveController"})
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Invoked");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		HttpSession session = req.getSession(false);
		if(session == null) {
			res.sendRedirect("Login.jsp");
			return;
		}
		
		Employee employee = (Employee) session.getAttribute("employee");
		if(employee != null) {
			chain.doFilter(req, res);
		}else {
			res.sendRedirect("Login.jsp");
		}
		
		
	}
	

}
