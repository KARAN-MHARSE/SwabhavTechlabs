package com.aurionpro.main;

public class TaxCalculator {
	private ILogger iLogger;

	public TaxCalculator(ILogger iLogger) {
		this.iLogger = iLogger;
	}
	
	public void calculateTax(double amount, double rate) {
		double tax =0;
		try {
			if(rate <=0) throw new RuntimeException("Rate intrest should be greatter than 0");
			tax = amount/rate;
			System.out.println("The tax is: " + tax);
		} catch (Exception e) {
			iLogger.saveCurrentLog(e.getMessage());
			iLogger.printCurrentLog(e.getMessage());
			iLogger.fetchPreviousLog();
		}
	}
	
}
