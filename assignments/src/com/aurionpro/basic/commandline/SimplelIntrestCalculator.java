package com.aurionpro.basic.commandline;

public class SimplelIntrestCalculator {
	private static double calculateSimpleIntrest(int principal, int time, float rateOfIntrest) {
		return (principal * rateOfIntrest * time)/100;
	}
	
	public static void main(String args[]) {
		int principal = Integer.parseInt(args[0]);
		int rateOfIntrest = Integer.parseInt(args[1]);
		int time = Integer.parseInt(args[2]);
		
		double intrest = calculateSimpleIntrest(principal, time, rateOfIntrest );
		
		System.out.println("The Simple intrest for the given details is: "+ intrest);		
	}

}
