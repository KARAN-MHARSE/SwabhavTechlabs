package com.aurionpro.main;

public interface ILogger {

	void printCurrentLog(String message);
	Log fetchPreviousLog();
	void saveCurrentLog(String message);
	
}
