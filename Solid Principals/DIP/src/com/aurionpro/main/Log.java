package com.aurionpro.main;

import java.time.LocalDate;

public class Log {
	private String logName;
	private LocalDate date;

	public Log(String logName) {
		super();
		this.logName = logName;
		this.date = LocalDate.now();
	}

	public String getLogName() {
		return logName;
	}

	public void setLogName(String logName) {
		this.logName = logName;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Log [logName=" + logName + ", date=" + date + "]";
	}

}
