package com.aurionpro.foodify;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import com.aurionpro.foodify.controllers.Authentication;
import com.aurionpro.foodify.controllers.CustomerController;
import com.aurionpro.foodify.controllers.DeliveryAgentContoller;
import com.aurionpro.foodify.controllers.RestaruntManagerController;
import com.aurionpro.foodify.models.Customer;
import com.aurionpro.foodify.models.DeliveryAgent;
import com.aurionpro.foodify.models.Restaurant;
import com.aurionpro.foodify.models.RestaurantManager;
import com.aurionpro.foodify.models.User;
import com.aurionpro.foodify.services.CustomerServices;
import com.aurionpro.foodify.services.FoodServices;
import com.aurionpro.foodify.utils.PrintDataInFormat;

public class Foodify {
	public static User currentUser = null;

	

	public static void loadInitialData(Restaurant restaurant, Map<UUID, User> users) {
		Customer customer = new Customer("Ram", null, "user@gmail.com", 1236637675574L, "1234");
		RestaurantManager manager = new RestaurantManager("Ramesh Patil", null, "manager@gmail.com", 12345678901L,
				"1234", restaurant.getId());
		restaurant.setRestaurantManager(manager);

		DeliveryAgent deliveryAgent1 = new DeliveryAgent("Jayesh", null, "delivery1@gmail.com", 1234567890L, "1234");
		DeliveryAgent deliveryAgent2 = new DeliveryAgent("Ramesh", null, "delivery2@gmail.com", 1234567890L, "1234");

		users.put(customer.getId(), customer);
		users.put(manager.getId(), manager);
		users.put(deliveryAgent1.getId(), deliveryAgent1);
		users.put(deliveryAgent2.getId(), deliveryAgent2);
	}

	public static void startApp(Scanner scanner, Map<UUID, User> users, Restaurant restarunt) {
		boolean isContinue = true;
		FoodServices.loadFoodItems();

		PrintDataInFormat.printWelcomeMessage();
		while (isContinue) {

			try {
//				System.out.println("Please Login/Register first. Choose \n1.Login \n2.Register \n4.Exit");
				PrintDataInFormat.printLoginMenu();
				System.out.print("=> ");
				int choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1:
					boolean isLoggedUser = Authentication.login(scanner, users);
//					boolean isLoggedUser = true;
					if (isLoggedUser && currentUser instanceof Customer) {
						CustomerController.showCustomerMenu(scanner, users, restarunt);
					}
					if (isLoggedUser && currentUser instanceof RestaurantManager) {
						RestaruntManagerController.showRestaruntManagerMenu(scanner, users, restarunt);
					}
					if(isLoggedUser && currentUser instanceof DeliveryAgent) {
						DeliveryAgentContoller.showDeliveryAgentMenu(scanner, users, restarunt);
					}
					break;
				case 2:
					Authentication.register(scanner, users);
					break;
				case 4:
					isContinue = false;
					System.out.println("Thank you for visiting Foodify");
					break;
				default:
					System.out.println("Enter right choice code");
				}
			} 
			catch (InputMismatchException e) {
				System.err.println("Invalid input! Please enter a number (1, 2, or 4).");
				scanner.nextLine();
			}
			catch (Exception e) {
				PrintDataInFormat.printError("Error: "+e.getMessage());
			}
		}
	}

}
