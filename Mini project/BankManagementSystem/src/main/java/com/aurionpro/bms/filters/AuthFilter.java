package com.aurionpro.bms.filters;

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

import com.aurionpro.bms.models.User;

@WebFilter(urlPatterns = {"/AdminDashboardController","/CustomerDashboardController"})
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		HttpSession session = req.getSession(false);
		if(session == null) {
			res.sendRedirect(req.getContextPath()+"/LoginController");
			return;
		}
		
		User user = (User) session.getAttribute("user");
		System.out.println(req.getContextPath());
		if(user==null) {
			res.sendRedirect(req.getContextPath()+"/LoginController");
			return;
		}
		
		chain.doFilter(req, res);
		
	}
	

}
