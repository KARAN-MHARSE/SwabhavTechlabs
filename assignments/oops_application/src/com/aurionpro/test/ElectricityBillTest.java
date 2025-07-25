package com.aurionpro.test;

import java.util.Scanner;

import javax.security.auth.login.CredentialException;

import com.aurionpro.model.ElectricityBill;

public class ElectricityBillTest {

	public static ElectricityBill generateBill(Scanner scanner) {
		System.out.println("Enter the user id");
		int userId = scanner.nextInt();
		
		System.out.println("Enter the bill id");
		int billId = scanner.nextInt();
		
		System.out.println("Enter the units");
		int units = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter the user address");
		String  address = scanner.nextLine();
		
		System.out.println("Enter the bill date");
		String  date = scanner.nextLine();
		
		ElectricityBill electricityBill = new ElectricityBill(userId,billId,units,date,address);
		return electricityBill;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		ElectricityBill bill1 = generateBill(scanner);

		System.out.println("Your bill for this month is:"+bill1.calculateBill());
	}

}
