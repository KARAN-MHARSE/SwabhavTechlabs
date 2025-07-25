package com.aurionpro.foodify;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import com.aurionpro.foodify.models.Restaurant;
import com.aurionpro.foodify.models.User;

public class FoodifyApplication {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		Map<UUID, User> users = new HashMap<>();
		Restaurant restaurant = new Restaurant("Glocal Andheri", null);

		Foodify.loadInitialData(restaurant, users);

		Foodify.startApp(scanner, users, restaurant);

		scanner.close();
	}
}
