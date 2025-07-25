package com.aurionpro.foodify.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import com.aurionpro.foodify.Foodify;
import com.aurionpro.foodify.enumproperties.OrderStatus;
import com.aurionpro.foodify.enumproperties.PaymentStatus;
import com.aurionpro.foodify.exceptions.CustomException;
import com.aurionpro.foodify.exceptions.DataValidationException;
import com.aurionpro.foodify.exceptions.FoodItemNotFoundException;
import com.aurionpro.foodify.exceptions.OrderNotFoundException;
import com.aurionpro.foodify.exceptions.UserNotFoundException;
import com.aurionpro.foodify.interfaces.IPaymentType;
import com.aurionpro.foodify.models.Address;
import com.aurionpro.foodify.models.Customer;
import com.aurionpro.foodify.models.FoodItem;
import com.aurionpro.foodify.models.Invoice;
import com.aurionpro.foodify.models.LineItem;
import com.aurionpro.foodify.models.Order;
import com.aurionpro.foodify.models.Payment;
import com.aurionpro.foodify.models.Restaurant;
import com.aurionpro.foodify.models.User;
import com.aurionpro.foodify.payments.type.CardPayment;
import com.aurionpro.foodify.payments.type.CashPayment;
import com.aurionpro.foodify.payments.type.UpiPayment;
import com.aurionpro.foodify.strategy.PaymentProcessor;
import com.aurionpro.foodify.utils.CustomerUtility;
import com.aurionpro.foodify.utils.OrderUtility;
import com.aurionpro.foodify.utils.PrintDataInFormat;

public class CustomerServices {
	private static CustomerServices customerServices = null;

	private CustomerServices() {

	}

	public static CustomerServices getInstance() {
		if (customerServices == null) {
			customerServices = new CustomerServices();
		}
		return customerServices;
	}

	public static void printCartFoodItems() {
		Customer currentCustomer = (Customer) Foodify.currentUser;
		if (currentCustomer == null)
			throw new UserNotFoundException();

		Order currentOrder = CustomerUtility.getCurrentOrder(currentCustomer);
		if (currentOrder == null || currentOrder.getLineItems() == null || currentOrder.getLineItems().isEmpty())
			throw new CustomException("Cart is empty");

//		currentOrder.getLineItems().forEach(System.out::println);
		PrintDataInFormat.printCartTable(currentOrder);
		System.out.println("\n");

	}

	public void addFoodItemToCart(Scanner scanner, Map<UUID, User> users) {
		Customer currentUser = (Customer) users.get(Foodify.currentUser.getId());
		if (currentUser == null)
			throw new CustomException("Please login first to add in cart");

		System.out.println("Enter the food id");
//		String foodItemId = scanner.nextLine().trim();
		int foodItemId = scanner.nextInt();
		scanner.nextLine();
		
		FoodItem foodItem = FoodServices.getFoodItemById(foodItemId);
		if (foodItem == null)
			throw new FoodItemNotFoundException();

		boolean isQunatityValidated = false;
		int quntity = 1;
		while (!isQunatityValidated) {
			System.out.println("Enter the quantity of food item");
			quntity = scanner.nextInt();
			scanner.nextLine();
			if (quntity > 50) {
				System.err.println("We can't take order more than 50 quntities");
				continue;
			}
			if (quntity > 0) {
				isQunatityValidated = true;
				break;
			}

			System.err.println("Quantity must be greatter than 0");
		}

		

		Order currentOrder = CustomerUtility.getCurrentOrder(currentUser);
		if (currentOrder == null) {
			LineItem lineItem = new LineItem(foodItem, quntity);
			List<LineItem> lineItems = new ArrayList<LineItem>();
			lineItems.add(lineItem);
			Order order = new Order(currentUser.getId(), lineItems, currentUser.getAdress(), OrderStatus.Pending,
					LocalDate.now());
			currentUser.getOrders().add(order);
			System.out.println("Product succesfully added into cart");
			return;
		}

		LineItem alreadyPresentLineItem = OrderUtility.getLineItem(currentOrder, foodItem.getId());
		if (alreadyPresentLineItem == null) {
			LineItem lineItem = new LineItem(foodItem, quntity);
			currentOrder.getLineItems().add(lineItem);
			System.out.println("Product succesfully added into cart");
			return;
		}

		alreadyPresentLineItem.setQuantity(alreadyPresentLineItem.getQuantity() + quntity);
		System.out.println("Product succesfully added into cart");

	}

	public void removeFoodItemFromCart(Scanner scanner, Map<UUID, User> users) {
		Customer currentUser = (Customer) users.get(Foodify.currentUser.getId());
		if (currentUser == null)
			throw new CustomException("Please login first to add in cart");

		System.out.println("Enter the food id");
//		String foodItemId = scanner.nextLine().trim();
		int foodItemId = scanner.nextInt();
		scanner.nextLine();

		FoodItem foodItem = FoodServices.getFoodItemById(foodItemId);
		if (foodItem == null)
			throw new FoodItemNotFoundException();

		Order currentOrder = CustomerUtility.getCurrentOrder(currentUser);
		if (currentOrder == null)
			throw new OrderNotFoundException();

		LineItem alreadyPresentLineItem = OrderUtility.getLineItem(currentOrder, foodItem.getId());
		if (alreadyPresentLineItem == null)
			throw new FoodItemNotFoundException();

		currentOrder.getLineItems().remove(alreadyPresentLineItem);

		System.out.println("Product succesfully remove from cart");

	}

	public void updateQauntityOfItem(Scanner scanner, Map<UUID, User> users) {
		Customer currentUser = (Customer) users.get(Foodify.currentUser.getId());
		if (currentUser == null)
			throw new CustomException("Please login first to add in cart");

		System.out.println("Enter the food id");
		int foodItemId = scanner.nextInt();
		scanner.nextLine();

		FoodItem foodItem = FoodServices.getFoodItemById(foodItemId);
		if (foodItem == null)
			throw new FoodItemNotFoundException();

		Order currentOrder = CustomerUtility.getCurrentOrder(currentUser);
		if (currentOrder == null)
			throw new OrderNotFoundException();

		LineItem alreadyPresentLineItem = OrderUtility.getLineItem(currentOrder, foodItem.getId());
		if (alreadyPresentLineItem == null)
			throw new FoodItemNotFoundException();

		System.out.println("Enter the updated quantity of food");
		try {
			int quantity = scanner.nextInt();
			scanner.nextLine();
			if (quantity < 0)
				throw new DataValidationException();
			alreadyPresentLineItem.setQuantity(quantity);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		System.out.println("Food item qunatity succesfully updated");

	}

	public void placeOrder(Scanner scanner, Map<UUID, User> users, Restaurant restarunt) {
		Customer currentUser = (Customer) users.get(Foodify.currentUser.getId());
		if (currentUser == null)
			throw new CustomException("Please login first to add in cart");

		Order currentOrder = CustomerUtility.getCurrentOrder(currentUser);
		if (currentOrder == null || currentOrder.getLineItems().isEmpty())
			throw new OrderNotFoundException();
		
		
		if(currentUser.getAdress() == null ) {
			while(true) {
				try {
					System.out.println("Your profile dont have address, so please provide address to deliver the order");
					System.out.println("Enter Area name");
					String area = scanner.nextLine();
					System.out.println("Enter Landmark name");
					String landmark = scanner.nextLine();
					System.out.println("Enter Postal code in numbers");
					int postalCode = scanner.nextInt();
					scanner.nextLine();
					
					Address address = new Address(area, landmark, postalCode);
					currentUser.setAdress(address);
					break;
				} catch (Exception e) {
					System.err.println("Wrong input value");
				}
				
				
			}
		}

//		payment
		boolean isPaymnetProcessContinue = true;
		IPaymentType paymentGateway = null;
		while (isPaymnetProcessContinue) {
			System.out.println("Total price: "+ (int)(currentOrder.getTotalDiscount()+currentOrder.getTotalPrice()));
			System.out.println("Total Disount: " + currentOrder.getTotalDiscount());
			System.out.println("Final Bill: "+ currentOrder.getTotalPrice());
			System.out.println("Choose the payment gateway: \n1.Credit Card \n2.Upi payment \n3.Cash Payment");
			
			int paymentChoice = scanner.nextInt();
			scanner.nextLine();

			boolean isSuccessfull = false;
			switch (paymentChoice) {
			case 1:
				isSuccessfull = PaymentProcessor.processPayment("card", currentOrder.getTotalPrice());
				if (isSuccessfull)
					isPaymnetProcessContinue = false;
				break;
			case 2:
				isSuccessfull = PaymentProcessor.processPayment("upi", currentOrder.getTotalPrice());
				if (isSuccessfull)
					isPaymnetProcessContinue = false;
				break;
			case 3:
				isSuccessfull = PaymentProcessor.processPayment("cash", currentOrder.getTotalPrice());
				if (isSuccessfull)
					isPaymnetProcessContinue = false;
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + paymentChoice);
			}
		}

//		Generate bill and invoice		
		Invoice invoice = new Invoice(currentOrder, currentUser.getName(),
				currentOrder.getTotalPrice() + currentOrder.getTotalDiscount(), currentOrder.getTotalDiscount(),
				currentOrder.getTotalPrice(), true, null);
		Payment paymentBill = new Payment(currentUser.getId(), invoice.getId(), currentOrder.getTotalPrice(),
				PaymentStatus.Success, paymentGateway);
		invoice.setPaymentId(paymentBill.getId());

	
		
		
		

		restarunt.getOrders().add(currentOrder);
		restarunt.getPaymentHistoy().add(paymentBill);

		currentOrder.setOrderStatus(OrderStatus.Process);
		currentOrder.setLocalDate(LocalDate.now());
		currentUser.getPaymentHistory().add(paymentBill);
		currentUser.getInvoiceList().add(invoice);
		
		System.out.println("Would you like to print invoice for this order? (y/n)");
		String isPrintInvoice = scanner.nextLine();
		if(isPrintInvoice.equals("y")) {
			PrintDataInFormat.printInvoice(invoice);
		}

		System.out.println("Order successfully placed");

	}

	public void printOrderHistory(Scanner scanner, Map<UUID, User> users, Restaurant restarunt) {
		Customer currentUser = (Customer) users.get(Foodify.currentUser.getId());
		if (currentUser == null)
			throw new CustomException("Please login first to add in cart");

		List<Order> orders = currentUser.getOrders();
		
		if(orders==null || orders.isEmpty()) throw new OrderNotFoundException();
		
		PrintDataInFormat.printOrderSummaryTable(orders);
		
	}

}
