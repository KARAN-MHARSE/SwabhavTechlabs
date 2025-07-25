package com.aurionpro.foodify.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import com.aurionpro.foodify.Foodify;
import com.aurionpro.foodify.exceptions.CustomException;
import com.aurionpro.foodify.exceptions.FoodItemNotFoundException;
import com.aurionpro.foodify.interfaces.FoodType;
import com.aurionpro.foodify.models.FoodItem;
import com.aurionpro.foodify.models.RestaurantManager;
import com.aurionpro.foodify.models.User;
import com.aurionpro.foodify.models.foodTypes.ChineseFood;
import com.aurionpro.foodify.models.foodTypes.IndianFood;
import com.aurionpro.foodify.models.foodTypes.ItalianFood;
import com.aurionpro.foodify.utils.PrintDataInFormat;

public class FoodServices {
	private static Map<Integer, FoodItem> foodItems = new HashMap<>();

	public static void loadFoodItems() {
		IndianFood indian = new IndianFood();
		ChineseFood chinese = new ChineseFood();
		ItalianFood italian = new ItalianFood();

		FoodItem paneerButterMasala = new FoodItem("Paneer Butter Masala",
				"Soft paneer cubes cooked in a rich and creamy tomato gravy", indian, 1020);
		foodItems.put(paneerButterMasala.getId(), paneerButterMasala);

		FoodItem choleBhature = new FoodItem("Chole Bhature",
				"Spicy chickpea curry served with fluffy deep-fried bread", indian, 700);
		foodItems.put(choleBhature.getId(), choleBhature);

		FoodItem biryani = new FoodItem("Biryani", "Aromatic basmati rice cooked with meat and spices", indian, 350);
		foodItems.put(biryani.getId(), biryani);

		FoodItem alooParatha = new FoodItem("Aloo Paratha", "Whole wheat flatbread stuffed with spiced mashed potatoes",
				indian, 150);
		foodItems.put(alooParatha.getId(), alooParatha);

		FoodItem masalaDosa = new FoodItem("Masala Dosa",
				"Thin crispy crepe filled with spiced mashed potatoes, served with chutneys", indian, 100);
		foodItems.put(masalaDosa.getId(), masalaDosa);

		// Italian Food Items
		FoodItem margheritaPizza = new FoodItem("Margherita Pizza",
				"Classic pizza topped with tomato, mozzarella, and basil", italian, 540);
		foodItems.put(margheritaPizza.getId(), margheritaPizza);

		FoodItem pastaAlfredo = new FoodItem("Pasta Alfredo",
				"Creamy pasta with a rich Alfredo sauce made from butter, cream, and parmesan", italian, 350);
		foodItems.put(pastaAlfredo.getId(), pastaAlfredo);

		FoodItem lasagna = new FoodItem("Lasagna",
				"Layers of pasta, ricotta, marinara sauce, and mozzarella, baked to perfection", italian, 800);
		foodItems.put(lasagna.getId(), lasagna);

		FoodItem focaccia = new FoodItem("Focaccia",
				"Soft and flavorful Italian bread, seasoned with olive oil and rosemary", italian, 489);
		foodItems.put(focaccia.getId(), focaccia);

		// Chinese Food Items
		FoodItem springRolls = new FoodItem("Spring Rolls",
				"Crispy rolls filled with a mix of vegetables and served with sweet chili sauce", chinese, 398);
		foodItems.put(springRolls.getId(), springRolls);

	}

	public static List<FoodItem> getAllFoodItems() {
		if (foodItems.isEmpty())
			return null;

		Collection<FoodItem> foodItemCollection = foodItems.values();
		return new ArrayList<>(foodItemCollection);
	}

	public static FoodItem getFoodItemByName(String foodItemName) {
		if (foodItems.isEmpty())
			return null;

		for (Map.Entry<Integer, FoodItem> foodItem : foodItems.entrySet()) {
			if (foodItem.getValue().getName().trim().equalsIgnoreCase(foodItemName)) {
				return foodItem.getValue();
			}
		}
		return null;

	}

	public static FoodItem getFoodItemById(int  foodItemId) {
		if (foodItems.isEmpty())
			return null;

		for (Map.Entry<Integer, FoodItem> foodItem : foodItems.entrySet()) {
			if (foodItem.getValue().getId() == (foodItemId)) {
				return foodItem.getValue();
			}
		}
		return null;

	}

	public static void printAllFoodItems() {
		List<FoodItem> storedFoodItems = getAllFoodItems();
		if (storedFoodItems == null )
			throw new FoodItemNotFoundException();
//		System.out.println("Here is the list of food menu:");
//		storedFoodItems.forEach(System.out::println);
		PrintDataInFormat.printFoodItemsTable(storedFoodItems);
	}

	public static void addNewFoodItemToMenu(Scanner scanner) {
		System.out.println("Enter the food item name");
		String foodItemName = scanner.nextLine();

		System.out.println("Enter the description of food item");
		String description = scanner.nextLine();

		FoodType foodType = null;
		while (true) {
			System.out.println("Select the type of food. Choose \n1.IndianFood \n2.Italian Food \n3.Chinese food");
			int foodTypeChoice = scanner.nextInt();
			scanner.nextLine();

			switch (foodTypeChoice) {
			case 1:
				foodType = new IndianFood();
				break;
			case 2:
				foodType = new ItalianFood();
				break;
			case 3:
				foodType = new ChineseFood();
				break;
			default:
				System.err.println("Wrong choice code, choose again");
			}

			if (foodType != null)
				break;
		}

		
		double price= 0;
		while(true) {
			System.out.println("Enter the price of food item");
			 price = scanner.nextDouble();
			scanner.nextLine();
			if(price < 0) {
				System.err.println("Price should be greatter than 0");
			}
			else {
				break;
			}
		}
		
//		

		FoodItem foodItem = new FoodItem(foodItemName, description, foodType, price);
		foodItems.put(foodItem.getId(), foodItem);

		System.out.println("Food item created succesfully");
	}

	public static void removeFoodItemFromMenu(Scanner scanner) {
		User currentUser = Foodify.currentUser;
		if (currentUser == null || !(currentUser instanceof RestaurantManager))
			throw new CustomException("UnAuthorized user");

		System.out.println("Enter the food id");
//		UUID foodItemId = UUID.fromString(scanner.nextLine());
		int foodItemId = scanner.nextInt();
		scanner.nextLine();

		FoodItem foodItem = getFoodItemById(foodItemId);
		if (foodItem == null)
			throw new FoodItemNotFoundException();
		

		foodItems.remove(foodItem.getId());
		System.out.println("Food item successfully removed");
	}

	public static void updatePriceOfFoodItem(Scanner scanner) {

		User currentUser = Foodify.currentUser;
		if (currentUser == null || !(currentUser instanceof RestaurantManager))
			throw new CustomException("UnAuthorized user");

		System.out.println("Enter the food id to update price");
//		UUID foodItemId = UUID.fromString(scanner.nextLine());
		int foodItemId = scanner.nextInt();
		scanner.nextLine();

		FoodItem foodItem = getFoodItemById(foodItemId);
		if (foodItem == null)
			throw new FoodItemNotFoundException();
		
		double newPrice =0;
		while(true) {
			System.out.println("The old price is :"+foodItem.getPrice() +"\nEnter the new price:");
			newPrice = scanner.nextDouble();
			scanner.nextLine();
			
			if(newPrice < 0) System.err.println("Price should be greater than 0");
			else {
				break;
			}
		}
		
		if(newPrice <0) throw new CustomException("Price should be greatter than 0");
		
		foodItem.setPrice(newPrice);
		System.out.println("Food item  price successfully updated");
	}

}
