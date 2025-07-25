package com.aurionpro.main;

import java.util.ArrayList;
import java.util.List;

public class DBLogger implements ILogger {
	List<Log> dbLogs = new ArrayList<Log>();

	@Override
	public void printCurrentLog(String message) {
		System.err.println(message);
		
		
	}

	@Override
	public Log fetchPreviousLog() {
		return dbLogs.get(dbLogs.size()-1);
		
	}

	@Override
	public void saveCurrentLog(String message) {
		Log log = new Log(message);
		dbLogs.add(log);
		
	}

}
