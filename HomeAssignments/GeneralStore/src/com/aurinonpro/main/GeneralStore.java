package com.aurinonpro.main;

import java.util.Scanner;

import com.aurinonpro.main.services.GeneralStoreServices;

public class GeneralStore {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		GeneralStoreServices.addInitialProducts();

		System.out.println("Welcome to the product store");
		start(scanner);
	}

	private static void start(Scanner scanner) {
		boolean isContinue = true;

		while (isContinue) {
			System.out.println("\n********************************************");
			System.out.println(
					"Select the choice code: \n1.See all products \n2.Add product in cart \n3.Remove product from cart \n4.View all items of cart \n5.Update the quantity of product \n6.Order the items \n9.Exit");

			int choice = scanner.nextInt();
			scanner.nextLine();
			
			try {
				switch (choice) {
				case 1: 
					GeneralStoreServices.showAllProducts();
					break;
				case 2:
					GeneralStoreServices.AddProductIntoCart(scanner);
					break;
				case 3:
					GeneralStoreServices.removeProductFromCart(scanner);
					break;
				case 4:
					GeneralStoreServices.viewAllItemsOfcart(scanner);
					break;
				case 5: 
					GeneralStoreServices.updateProductQuantity(scanner);
					break;
				case 6:
					GeneralStoreServices.doOrder(scanner);
					break;
				case 9:
					System.out.println("Thank you for visiting.");
					isContinue = false;
					break;
				default:
					System.err.println("Enter the right choice code");
				}
			} catch (Exception e) {
				e.printStackTrace();
//				System.err.println(e.getMessage());
			}
		}
	}
}
