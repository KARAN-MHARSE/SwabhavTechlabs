package com.aurionpro.foodify.controllers;

import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import com.aurionpro.foodify.Foodify;
import com.aurionpro.foodify.models.Restaurant;
import com.aurionpro.foodify.models.RestaurantManager;
import com.aurionpro.foodify.models.User;
import com.aurionpro.foodify.services.CustomerServices;
import com.aurionpro.foodify.services.FoodServices;
import com.aurionpro.foodify.services.RestaruntManagerServices;
import com.aurionpro.foodify.utils.PrintDataInFormat;

public class RestaruntManagerController {
	public static void showRestaruntManagerMenu(Scanner scanner, Map<UUID, User> users,Restaurant restarunt) {


		
		System.out.println("Welcome managaer "+ Foodify.currentUser.getName()+ " in the Foodify");
		boolean isContinue = true;
		while (isContinue) {
			System.out.println("****************************************************");
			PrintDataInFormat.printMenu("Here is menu, choose the choice code \n1.Show all food items \n2.Add new food Item to menu \n3.Remove food item from menu \n4.Update price of food item in menu \n5.See new orders \n6.Add new delivery agent \n10.LogOut");
			int choice = scanner.nextInt();
			scanner.nextLine();

			try {
				switch (choice) {
				case 1:
					FoodServices.printAllFoodItems();
					break;
				case 2:
					FoodServices.addNewFoodItemToMenu(scanner);
					break;
				case 3:
					FoodServices.removeFoodItemFromMenu(scanner);
					break;
				case 4:
					FoodServices.updatePriceOfFoodItem(scanner);
					break;
				case 5:
					RestaruntManagerServices.checkNewOrders(scanner,users,restarunt);
					break;
				case 6: 
					RestaruntManagerServices.addNewDeliveryAgent(scanner,users);
					break;
				case 10:
					Foodify.currentUser = null;
					isContinue = false;
					
				default:
					System.out.println("Enter valid choice code.");
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
	}

}
