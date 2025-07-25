package com.aurionpro.foodify.services;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import com.aurionpro.foodify.builder.UserBuilder;
import com.aurionpro.foodify.enumproperties.OrderStatus;
import com.aurionpro.foodify.exceptions.CustomException;
import com.aurionpro.foodify.exceptions.OrderNotFoundException;
import com.aurionpro.foodify.exceptions.UserNotFoundException;
import com.aurionpro.foodify.models.DeliveryAgent;
import com.aurionpro.foodify.models.Order;
import com.aurionpro.foodify.models.Restaurant;
import com.aurionpro.foodify.models.User;
import com.aurionpro.foodify.utils.CustomerUtility;
import com.aurionpro.foodify.utils.InputValidator;
import com.aurionpro.foodify.utils.OrderUtility;
import com.aurionpro.foodify.utils.PrintDataInFormat;
import com.aurionpro.foodify.utils.UserUtility;

public class RestaruntManagerServices {

	private static void AssignDeliveryBoy(Scanner scanner,Map<UUID,User> users,List<Order> orders) {
		List<Order> processOrders = OrderUtility.getProcessOrders(orders);
		List<User> deliveryAgents = UserUtility.getDelieveryBoysList(users);
		
		if(processOrders.isEmpty()) {
			System.err.println("No process order found");
			return;
		}
		
//		System.out.println("The list of non-delivery  assign orders are:");
//		processOrders.forEach(System.out::println);
		PrintDataInFormat.printOrderSummaryTable(processOrders);
		
		System.out.println("Enter the orderCode to assign delivery boy");
		String orderId = scanner.nextLine().trim();
		
		Order order = OrderUtility.getOrderById(processOrders, UUID.fromString(orderId));
		if(order == null) throw new OrderNotFoundException();
		
//		System.out.println("The list of delivery agents");
//		deliveryAgents.forEach(System.out::println);
		PrintDataInFormat.printDeliveryAgents(deliveryAgents);
		
		System.out.println("Enter the delivery agent id to assign order");
		String deliveryAgentId = scanner.nextLine().trim();
		
		DeliveryAgent deliveryAgent = (DeliveryAgent)UserUtility.getDeliveryAgentById(users, UUID.fromString(deliveryAgentId));
		if(deliveryAgent == null) throw new UserNotFoundException();
		
		order.setOrderStatus(OrderStatus.DelieveryBoyAssign);
		deliveryAgent.getOrders().add(order);
		
		System.out.println("Delivery agent successfully assign");
		

	}

	public static void checkNewOrders(Scanner scanner, Map<UUID, User> users, Restaurant restarunt) {
		if (restarunt == null)
			throw new CustomException("Restarunt not found");

		if (restarunt.getOrders() == null || restarunt.getOrders().isEmpty())
			throw new OrderNotFoundException();

		List<Order> orders = restarunt.getOrders();
		List<Order> processOrders = OrderUtility.getProcessOrders(orders);
		if (processOrders == null && processOrders.isEmpty()) {
			System.out.println("No process order founds");
			return;
		}
			

//		assign delievery boys to process order
		boolean isContinueAssigning = true;
		while (isContinueAssigning) {
			System.out.println("Choose option: \n1.Assign Delivery boy \n2.Go back");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
			case 1:
				AssignDeliveryBoy(scanner,users,orders);
				break;
			case 2:
				isContinueAssigning = false;
				break;
			default:
				System.err.println("Wrong choice code, choose again.");
			}
		}

	}

	public static void addNewDeliveryAgent(Scanner scanner, Map<UUID, User> users) {
		System.out.println("Enter the name of delivery agent");
		String deliveryAgentName = scanner.nextLine();
		
		System.out.println("Enter your email id");
		String email = scanner.nextLine();
		
		System.out.println("Enter the mobile number of delivery agent");
		Long mobileNumber = scanner.nextLong();
		scanner.nextLine();
		
		if(!InputValidator.isEmailValid(email)) throw new CustomException("Email id need to be valid");
		
		if(deliveryAgentName.isBlank() || Long.toString(mobileNumber).length() !=10){
			throw new CustomException("All credentials are required and valid");
		}
		
		DeliveryAgent agent = new UserBuilder()
				.setName(deliveryAgentName)
				.setEmail(email)
				.setMobileNumber(mobileNumber)
				.setPassword(email)
				.buildDeliveryAgent();
		
		if(agent != null) throw new CustomException("Something went wrong");
		
		users.put(agent.getId(), agent);
		System.out.println("Delivery agent successfully added");
		
	}
}
