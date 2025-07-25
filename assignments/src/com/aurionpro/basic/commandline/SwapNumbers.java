package com.aurionpro.basic.commandline;


public class SwapNumbers {

		private static void display(int number1, int number2) {
			System.out.println("number1=" + number1);
			System.out.println("number2=" + number2);
		}
		
		public static void main(String args[]) {
			int number1 = Integer.parseInt(args[0]);
			int number2 = Integer.parseInt(args[1]);

			
			number1 = number1 ^ number2;
			number2 = number1 ^ number2;
			number1 = number1 ^ number2;
			
			display(number1,number2);
			
		

	}

}
