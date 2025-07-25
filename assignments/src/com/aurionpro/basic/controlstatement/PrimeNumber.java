package com.aurionpro.basic.controlstatement;

public class PrimeNumber {

	static boolean checkPrime(int number) {
//		for(int i=2; i< Math.sqrt(number) ; i++) {
//			if(number%i ==0) {
//				return false;
//			}
//		}
		
		int start = 2;
		while(start < Math.sqrt(number)) {
			if(number % start ==0) {
				return false;
				
			}
			start++;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int number = 11;
		
		boolean isPrime = checkPrime(number);
		if(isPrime) {
			System.out.println("yes number is prime");
		}else {
			System.out.println("No number is not prime");
		}
	}

}
