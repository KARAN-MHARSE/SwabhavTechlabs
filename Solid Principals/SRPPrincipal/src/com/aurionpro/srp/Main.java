package com.aurionpro.srp;

import java.util.PrimitiveIterator;
import java.util.Scanner;

import com.aurionpro.srp.model.Invoice;
import com.aurionpro.srp.service.PrinterService;

public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome");
		
		boolean isCountinue = true;
		while(isCountinue) {
			System.out.println("\n*************************************");
			System.out.println("Enter the choice code: \n1.Print Invoice \n10.Exit");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
			case 1: 
				Invoice invoice = new Invoice(1, "Samsung s25", "The new S mobile", 82000, 8, 2);
				PrinterService.printInvoice(invoice);
				break;
			case 10:
				isCountinue = false;
				System.out.println("Thank you for visiting");
			default:
				System.out.println("Wrong choice code");
			}
		}
	}

}
