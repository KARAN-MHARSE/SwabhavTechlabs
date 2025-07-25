package com.aurinonpro.main.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import com.aurinonpro.main.exceptions.CustomerNotFoundException;
import com.aurinonpro.main.exceptions.OrderNotFoundException;
import com.aurinonpro.main.exceptions.ProductNotFountException;
import com.aurinonpro.main.models.Customer;
import com.aurinonpro.main.models.LineItem;
import com.aurinonpro.main.models.Order;
import com.aurinonpro.main.models.Product;
import com.aurinonpro.main.utility.CustomerUtility;
import com.aurinonpro.main.utility.OrderUtitlity;
import com.aurinonpro.main.utility.ProductUtility;

public class GeneralStoreServices {
	private static Map<Integer, Product> products = new HashMap<>();
	private static Map<Integer, Customer> customers = new HashMap<Integer, Customer>();

	public static void addInitialProducts() {
		products.put(100, new Product("Laptop", 50000, 10));
		products.put(101, new Product("Phone", 25000, 5));
		products.put(102, new Product("Headphones", 3000, 15));
		products.put(103, new Product("Monitor", 10000, 12));
		products.put(104, new Product("Keyboard", 1500, 8));
		products.put(105, new Product("Mouse", 800, 6));

		customers.put(700, new Customer("Karan"));
	}

	public static void showAllProducts() {
		if (products.isEmpty())
			throw new ProductNotFountException();
		System.out.println("Here is the list of product:");
		for (Map.Entry<Integer, Product> entry : products.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	public static void AddProductIntoCart(Scanner scanner) {
		Customer customer = customers.get(700);

		System.out.println("Enter the product id");
		int productId = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter the quantity of products");
		int quantity = scanner.nextInt();
		scanner.nextLine();

		Product product = ProductUtility.findProductById(products, productId);
		if (product == null)
			throw new ProductNotFountException();

		Order currentOrder = CustomerUtility.getCurrentOrder(customer);
		if (currentOrder == null) {
			LineItem lineItem = new LineItem(quantity, product);
			Order order = new Order(lineItem);
			customer.getOrders().add(order);
			System.out.println("Product successfully added into cart");
			return;
		}

		LineItem sameLineItem = OrderUtitlity.getLineItemFromOrderByProductId(currentOrder, productId);
		if (sameLineItem == null) {
			LineItem lineItem = new LineItem(quantity, product);
			currentOrder.getLineItems().add(lineItem);
			System.out.println("Product successfully added into cart");
			return;
		}

//		if item already present in the cart
		sameLineItem.setQuantity(sameLineItem.getQuantity() + quantity);
		System.out.println("Product successfully added into cart");

	}

	public static void removeProductFromCart(Scanner scanner) {
		Customer customer = customers.get(700);

		System.out.println("Enter the product id");
		int productId = scanner.nextInt();
		scanner.nextLine();

		Order currentOrder = CustomerUtility.getCurrentOrder(customer);
		if (currentOrder == null)
			throw new OrderNotFoundException();

		LineItem lineItem = OrderUtitlity.getLineItemFromOrderByProductId(currentOrder, productId);
		if (lineItem == null || currentOrder.getLineItems().isEmpty())
			throw new ProductNotFountException();

		currentOrder.getLineItems().remove(lineItem);
		System.out.println("Product successfully removed from cart");

	}

	public static void viewAllItemsOfcart(Scanner scanner) {
		Customer customer = customers.get(700);

		Order currentOrder = CustomerUtility.getCurrentOrder(customer);
		if (currentOrder == null)
			throw new OrderNotFoundException();

		List<LineItem> lineItems = OrderUtitlity.getAllLineItemsOfOrder(currentOrder);
		if (lineItems == null || lineItems.isEmpty())
			throw new ProductNotFountException();

		lineItems.forEach(System.out::println);
	}

	public static void updateProductQuantity(Scanner scanner) {
		Customer customer = customers.get(700);

		System.out.println("Enter the product id");
		int productId = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter the quantity of products");
		int quantity = scanner.nextInt();
		scanner.nextLine();
		
		if(quantity <=0) throw new RuntimeException("Product quantity should be greater than 0");

		Product product = ProductUtility.findProductById(products, productId);
		if (product == null)
			throw new ProductNotFountException();

		Order currentOrder = CustomerUtility.getCurrentOrder(customer);
		if (currentOrder == null)
			throw new OrderNotFoundException();

		LineItem sameLineItem = OrderUtitlity.getLineItemFromOrderByProductId(currentOrder, productId);
		if (sameLineItem == null)
			throw new ProductNotFountException();

//		if item product present in the cart
		sameLineItem.setQuantity(quantity);
		System.out.println("Product quantity successfully updated into cart");

	}
	
	public static void doOrder(Scanner scanner) {
		Customer customer = customers.get(700);


		Order currentOrder = CustomerUtility.getCurrentOrder(customer);
		if (currentOrder == null)
			throw new OrderNotFoundException();

		if ( currentOrder.getLineItems() == null ||currentOrder.getLineItems().isEmpty()) throw new RuntimeException("No product found for ordering");
		
		currentOrder.setIsCompleted(true);
		System.out.println("Order successfully registered");
	}

}
