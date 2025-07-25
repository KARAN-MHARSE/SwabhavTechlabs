package com.aurionpro.main;

import java.util.ArrayList;
import java.util.List;

public class LocalLogger implements ILogger {
	List<Log> localList = new ArrayList<Log>();
	
	@Override
	public void printCurrentLog(String message) {
		System.err.println(message);
		
		
	}

	@Override
	public Log fetchPreviousLog() {
		return localList.get(localList.size()-1);
		
	}

	@Override
	public void saveCurrentLog(String message) {
		Log log = new Log(message);
		localList.add(log);
		
	}


}
