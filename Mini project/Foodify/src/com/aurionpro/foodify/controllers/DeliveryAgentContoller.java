package com.aurionpro.foodify.controllers;

import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import com.aurionpro.foodify.Foodify;
import com.aurionpro.foodify.models.Restaurant;
import com.aurionpro.foodify.models.User;
import com.aurionpro.foodify.services.DeliveryAgentServices;
import com.aurionpro.foodify.services.FoodServices;
import com.aurionpro.foodify.services.RestaruntManagerServices;

public class DeliveryAgentContoller {

	public static void showDeliveryAgentMenu(Scanner scanner, Map<UUID, User> users, Restaurant restarunt) {
		System.out.println("Welcome " + Foodify.currentUser.getName() + " in the Foodify");
		boolean isContinue = true;
		while (isContinue) {
			System.out.println("****************************************************");
			System.out.println(
					"Here is menu, choose the choice code \n1.Show new orders \n2.Show delivered orders \n3.Update delivery status \n4.View today's earning \n5.Lifetime earning \n10.LogOut");
			int choice = scanner.nextInt();
			scanner.nextLine();

			try {
				switch (choice) {
				case 1:
					DeliveryAgentServices.showNewOrders();
					break;
				case 2:
					DeliveryAgentServices.showCompletedOrders();
					break;
				case 3:
					DeliveryAgentServices.updateDeliveryStatus(scanner);
					break;
				case 4:
					DeliveryAgentServices.viewTodaysEarning();
					break;
				case 5:
					DeliveryAgentServices.viewLifetimeEarning();
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
