package com.aurionpro.main.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.main.database.Database;

@WebServlet("/TrialController")
public class TrialController extends HttpServlet {
	int count = 0;
	private static final long serialVersionUID = 1L;
	
    public TrialController()  {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
	            Connection conn = Database.getConnection();
	            response.getWriter().println("Connection: " + conn);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
