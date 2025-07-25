package com.aurionpro.functionalinterface;

import java.util.Scanner;

public class ProductTest {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		ProductService productService =new ProductService();
		
		boolean isContinue = true;
		while(isContinue) {
			System.out.println("\n******************************************");
			System.out.println("Enter the choice code \n1.Show all products \n2.Get Product price after discount \n3.Print original and discount price \n10.exit");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			try {
				switch (choice) {
				case 1: 
					productService.getAllProducts();
					break;
				case 2:
					productService.getProductPriceAfterDiscountById(scanner);
					break;
				case 3:
					productService.printOriginalAndDiscountPrice(scanner);
					break;
				case 10:
					isContinue = false;
					break;
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}

	}
}
