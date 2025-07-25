package com.aurionpro.foodify.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

import com.aurionpro.foodify.Foodify;
import com.aurionpro.foodify.enumproperties.OrderStatus;
import com.aurionpro.foodify.exceptions.CustomException;
import com.aurionpro.foodify.exceptions.OrderNotFoundException;
import com.aurionpro.foodify.exceptions.UserNotFoundException;
import com.aurionpro.foodify.models.DeliveryAgent;
import com.aurionpro.foodify.models.Order;
import com.aurionpro.foodify.utils.PrintDataInFormat;

public class DeliveryAgentServices {

	public static void showNewOrders() {
		DeliveryAgent deliveryAgent = (DeliveryAgent) Foodify.currentUser;
		if (deliveryAgent == null)
			throw new UserNotFoundException();

		List<Order> orders = deliveryAgent.getOrders();
		if (orders == null || orders.isEmpty())
			throw new OrderNotFoundException();

		List<Order> newOrders = orders.stream()
				.filter(order -> order.getOrderStatus().equals(OrderStatus.DelieveryBoyAssign))
				.collect(Collectors.toList());

		if (newOrders == null || newOrders.isEmpty())
			throw new CustomException("New orders not assigned yet");

		System.out.println("The list of new orders are:");
		PrintDataInFormat.printOrderSummaryTable(newOrders);

	}

	public static void showCompletedOrders() {
		DeliveryAgent deliveryAgent = (DeliveryAgent) Foodify.currentUser;
		if (deliveryAgent == null)
			throw new UserNotFoundException();

		List<Order> orders = deliveryAgent.getOrders();
		if (orders == null || orders.isEmpty())
			throw new OrderNotFoundException();

		List<Order> newOrders = orders.stream().filter(order -> order.getOrderStatus().equals(OrderStatus.Completed))
				.collect(Collectors.toList());

		if (newOrders == null || newOrders.isEmpty())
			throw new OrderNotFoundException();

		System.out.println("The list of deliverd orders are:");
		PrintDataInFormat.printOrderSummaryTable(newOrders);

	}

	public static void updateDeliveryStatus(Scanner scanner) {
		DeliveryAgent deliveryAgent = (DeliveryAgent) Foodify.currentUser;
		if (deliveryAgent == null)
			throw new UserNotFoundException();

		showNewOrders();


		System.out.println("Enter the order id to update the status");

		UUID orderId = null;

		try {
			orderId = UUID.fromString(scanner.nextLine().trim());
		} catch (Exception e) {
			System.err.println("Wrong order id");
			return;
		}
		
		if (deliveryAgent.getOrders() == null || deliveryAgent.getOrders().isEmpty()) {
	        System.err.println("No orders found for this delivery agent.");
	        return;
	    }
		
		Order order = null;
		for(Order o : deliveryAgent.getOrders()) {
			if(o.getId().equals(orderId)) {
				order = o;
				break;
			}
		}

//		Order order = deliveryAgent.getOrders().stream()
//				.filter(o -> o.getId().equals(orderId))
//				.findFirst()
//				.orElse(null);

		if (order == null)
			throw new OrderNotFoundException();

		

		boolean isUpdated = false;
		while (!isUpdated) {
			System.out.println("Enter choice code to set orderset" + "\n1.Completed" + "\n2.Failed \n3.Go Back");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
			case 1:
				order.setOrderStatus(OrderStatus.Completed);
				System.out.println("Order status successfully updated");
				isUpdated = true;
				break;
			case 2:
				order.setOrderStatus(OrderStatus.Failed);
				System.out.println("Order status successfully updated");
				isUpdated=true;
				break;
			case 3:
				System.out.println("Returning to previous menu.");
				isUpdated = false;
				break;
			default:
				System.err.println("Wrong choice code");
			}
		}

	}

	public static void viewTodaysEarning() {
		DeliveryAgent deliveryAgent = (DeliveryAgent) Foodify.currentUser;
		if (deliveryAgent == null)
			throw new UserNotFoundException();

		List<Order> orders = deliveryAgent.getOrders();
		if (orders == null || orders.isEmpty())
			throw new OrderNotFoundException();
		
		List<Order> todaysCompletedOrders = deliveryAgent.getOrders().stream()
				.filter(o-> o.getLocalDate().equals(LocalDate.now()) && o.getOrderStatus().equals(OrderStatus.Completed))
				.collect(Collectors.toList());
		
		if(todaysCompletedOrders == null || todaysCompletedOrders.isEmpty()) throw new CustomException("No orders have been delivered today.");
		
		double earning = todaysCompletedOrders.size()*100;
		
		System.out.println("Today's Earning is: "+ earning);
		
	}

	public static void viewLifetimeEarning() {
		DeliveryAgent deliveryAgent = (DeliveryAgent) Foodify.currentUser;
		if (deliveryAgent == null)
			throw new UserNotFoundException();

		List<Order> orders = deliveryAgent.getOrders();
		if (orders == null || orders.isEmpty())
			throw new OrderNotFoundException();
		
		List<Order> todaysCompletedOrders = orders.stream()
				.filter(o-> o.getOrderStatus().equals(OrderStatus.Completed))
				.collect(Collectors.toList());
		
		if(todaysCompletedOrders == null || todaysCompletedOrders.isEmpty()) throw new CustomException("No orders have been delivered today.");
		
		double earning = todaysCompletedOrders.size()*100;
		
		System.out.println("Today's Earning is: "+ earning);
		
	}

}
