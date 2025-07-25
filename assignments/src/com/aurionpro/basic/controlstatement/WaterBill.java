package com.aurionpro.basic.controlstatement;

import java.util.Scanner;

public class WaterBill {
	
	private static int calculateBill(int units) {
		int meter_charge = 75;
		int charge = 0;
		
		
			if(units <100) {
				return (units * 5) + meter_charge;
			}
			else {
				charge = 100*5;
				units = units-100;
				if(units<= 150) {
					charge  += 150 * 10;
					units -= 150;
				}
				else {
					charge += units * 20;
					units = 0;
				}
			}
			

		
		
		
		return charge + meter_charge;

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the Number of units:");
		int units = scanner.nextInt();
		
		int billAmount = calculateBill(units);
		System.out.println("Electricity bill for "+ units + "is " + billAmount);

	}

}
