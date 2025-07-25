package com.aurionpro.serialization.example2;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
//		System.out.println("Choose code: \nCreate Employee \nPrint Employee Details \nPrint Employee Salary");
//		int choice = scanner.nextInt();
		
		boolean isContinue = true;
//		while(isContinue) {
//			switch(choice) {
//			case 1:
//				createEmployee(scanner);
//				break;
//			case 2:
//				printEmployeeDetails(scanner);
//				break;
//			case 3:
//				printSalary(scanner);
//				break;
//			case 4:
//				isContinue = false;
//				break;
//			}
//		}
		
		
		
		Employee employee1 = new FullTimeEmployee(101, "Prathamesh",25000,15000,1000);
		Employee employee2 = new PartTimeEmployee(1, "Ramesh",210,100);
		
		employee1.calculateSalary();
		employee2.calculateSalary();
		
		employee1.printDetails();

	}

}
