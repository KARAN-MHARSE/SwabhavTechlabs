package com.aurionpro.basic.commandline;


public class Addition {

	public static void main(String[] args) {
		 int number1 = Integer.parseInt(args[0]);
		 int number2 = Integer.parseInt(args[1]);
		 
		 int sum = addition(number1,number2);
		 System.out.println("The sum is "+sum);


	}
	private static int addition(int number1, int number2) {
		return number1+number2;
	}

}
