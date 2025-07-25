package com.aurionpro.main;

public class Main {
	public static void main(String args[]) {
		ILogger databaseLogger = new DBLogger();
		ILogger localLogger = new LocalLogger();
		
		boolean isDatabaseLive = true;
		
		if(isDatabaseLive) {
			TaxCalculator taxCalculator = new TaxCalculator(databaseLogger);
			taxCalculator.calculateTax(10233, 0);
		}else {
			TaxCalculator taxCalculator = new TaxCalculator(localLogger);
			taxCalculator.calculateTax(10233, 2);
		}
	}
}
