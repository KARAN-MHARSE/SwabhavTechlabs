package com.aurionpro.foodify.controllers;

import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import com.aurionpro.foodify.Foodify;
import com.aurionpro.foodify.models.Restaurant;
import com.aurionpro.foodify.models.User;
import com.aurionpro.foodify.services.CustomerServices;
import com.aurionpro.foodify.services.FoodServices;
import com.aurionpro.foodify.utils.PrintDataInFormat;

public class CustomerController {
	public static void showCustomerMenu(Scanner scanner, Map<UUID, User> users, Restaurant restarunt) {
		CustomerServices customerServices = CustomerServices.getInstance();

		boolean isContinue = true;
		while (isContinue) {
			System.out.println("****************************************************");
			PrintDataInFormat.printMenu("""
					Here is menu, choose the choice code
					1. Show all food items
					2. Show cart items
					3. Add food item to cart
					4. Remove food item from cart
					5. Update quantity of food item in cart
					6. Place order
					7. View order history
					10. LogOut
					""");

			System.out.print("=> ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			try {
				switch (choice) {
				case 1:
					FoodServices.printAllFoodItems();
					break;
				case 2:
					customerServices.printCartFoodItems();
					break;
				case 3:
					customerServices.addFoodItemToCart(scanner, users);
					break;
				case 4:
					customerServices.removeFoodItemFromCart(scanner, users);
					break;
				case 5:
					customerServices.updateQauntityOfItem(scanner, users);
					break;
				case 6:
					customerServices.placeOrder(scanner, users,restarunt);
					break;
				case 7:
					customerServices.printOrderHistory(scanner, users,restarunt);
					break;
				case 10:
					Foodify.currentUser = null;
					System.out.println("User successfully logged out");
					isContinue = false;
					break;
				default:
					System.out.println("Enter valid choice code.");
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}

	}

}
