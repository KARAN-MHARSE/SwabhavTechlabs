package com.aurionpro.foodify.utils;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.foodify.models.DeliveryAgent;
import com.aurionpro.foodify.models.FoodItem;
import com.aurionpro.foodify.models.Invoice;
import com.aurionpro.foodify.models.LineItem;
import com.aurionpro.foodify.models.Order;
import com.aurionpro.foodify.models.User;

public class PrintDataInFormat {

	private static final int BOX_WIDTH = 44; // inside border
	private static final String BOX_LINE = "+" + "-".repeat(BOX_WIDTH) + "+";

	private static String truncate(String text, int maxLength) {
		if (text.length() <= maxLength)
			return text;
		return text.substring(0, maxLength - 3) + "...";
	}

	public static void printFoodItemsTable(List<FoodItem> foodItems) {
		String format = "| %-7s | %-25s | %-25s | %-15s | %-10s | %-14s |\n";
		String line = "+---------+---------------------------+---------------------------+--------------------+------------+-------------+";

		System.out.println("📦 Food Items List:");
		System.out.println(line);
		System.out.printf(format, "ID", "Name", "Description", "FoodType", "Price", "Discount Price");
		System.out.println(line);

		for (FoodItem item : foodItems) {
			String desc = truncate(item.getDescription(), 25);
			System.out.printf(format, item.getId(), item.getName(), desc, item.getFoodType().getClass().getSimpleName(),
					String.format("%.2f", item.getPrice()), String.format("%.2f", item.getPriceAfterDiscount()));
		}

		System.out.println(line);
	}

	public static void printWelcomeMessage() {
		String border = "╔" + "═".repeat(BOX_WIDTH) + "╗";
		String spacer = "║" + " ".repeat(BOX_WIDTH) + "║";
		String endBorder = "╚" + "═".repeat(BOX_WIDTH) + "╝";

		System.out.println(border);
		System.out.println(spacer);
		System.out.printf("║%s║\n", centerText("🍴  WELCOME TO THE FOODIFY APP!", BOX_WIDTH));
		System.out.printf("║%s║\n", centerText("Enjoy your delicious food experience", BOX_WIDTH));
		System.out.println(spacer);
		System.out.println(endBorder + "\n");
	}

	public static void printLoginMenu() {
		System.out.println(BOX_LINE);
		System.out.println("|      Please Login/Register first           |");
		System.out.println(BOX_LINE);
		System.out.println("| Choose an option:                          |");
		System.out.println("| 1. Login                                   |");
		System.out.println("| 2. Register                                |");
		System.out.println("| 4. Exit                                    |");
		System.out.println("| Enter choice code:                         |");
		System.out.println(BOX_LINE);
	}

	public static String readInput(Scanner scanner, String prompt) {
		System.out.println(BOX_LINE);
		System.out.printf("| %-42s |\n", prompt);
		System.out.println(BOX_LINE);
		System.out.print("→ ");
		return scanner.nextLine();
	}

	public static void printError(String errorMessage) {
		String redColor = "\u001B[31m";
		String resetColor = "\u001B[0m";

		System.out.println(BOX_LINE);
		System.out.printf("| %s%-42s%s |\n", redColor, truncate(errorMessage, 42), resetColor);
		System.out.println(BOX_LINE);
	}

	private static String centerText(String text, int width) {
		if (text.length() >= width)
			return text.substring(0, width);
		int padding = (width - text.length()) / 2;
		return " ".repeat(padding) + text + " ".repeat(width - padding - text.length());
	}

	public static void printMenu(String multilineText) {
		String[] lines = multilineText.split("\n");

		int boxWidth = findMaxLineLength(lines) + 4; // Padding
		String horizontal = "+" + "-".repeat(boxWidth) + "+";

		System.out.println(horizontal);
		System.out.printf("| %-" + (boxWidth - 2) + "s |\n", lines[0]);
		System.out.println(horizontal);

		for (int i = 1; i < lines.length; i++) {
			System.out.printf("| %-" + (boxWidth - 2) + "s |\n", lines[i]);
		}

		System.out.println(horizontal);
	}

	private static int findMaxLineLength(String[] lines) {
		int max = 0;
		for (String line : lines) {
			if (line.length() > max)
				max = line.length();
		}
		return max;
	}

	public static void printCartTable(Order order) {

		double totalDiscount = order.getTotalDiscount();
		double totalAmountAfterDiscount = order.getTotalPrice();
		double totalAmountBeforeDiscount = totalDiscount + totalAmountAfterDiscount;
		List<LineItem> cartItems = order.getLineItems();

		String format = "| %-36s | %-20s | %-13s | %-8s | %-10s | %-12s | %-12s |\n";
		String line = "+--------------------------------------+----------------------+---------------+----------+------------+--------------+--------------+";

		System.out.println("🛒 Cart Items:");
		System.out.println(line);
		System.out.printf(format, "LineItem ID", "Food Name", "Food Type", "Qty", "Unit Price", "Discount", "Total");
		System.out.println(line);

		double grandTotal = 0.0;

		for (LineItem item : cartItems) {
			String name = item.getFoodItem().getName();
			String type = item.getFoodItem().getFoodType().getClass().getSimpleName();
			double unitPrice = item.getFoodItem().getPrice();
			double discounted = item.getFoodItem().getTotalDiscountPrice();
			double total = item.getTotalPrice();

			grandTotal += total;

			System.out.printf(format, item.getId(), name, type, item.getQuantity(), String.format("%.2f", unitPrice),
					String.format("%.2f", discounted), String.format("%.2f", total));
		}

		System.out.println(line);

		// Add summary lines
		System.out.printf("| %-114s | %-12s |\n", "Original Price", String.format("₹%.2f", totalAmountBeforeDiscount));
		System.out.printf("| %-114s | %-12s |\n", "Total Discount", String.format("-₹%.2f", totalDiscount));
		System.out.printf("| %-114s | %-12s |\n", "Grand Total", String.format("₹%.2f", totalAmountAfterDiscount));

		System.out.println(line);
	}

	public static void printOrderSummaryTable(List<Order> orders) {
		String format = "| %-36s | %-10s | %-10s | %-12s | %-12s |\n";
		String line = "+--------------------------------------+------------+------------+--------------+--------------+";

		System.out.println("📦 All Orders Summary:");
		System.out.println(line);
		System.out.printf(format, "Order ID", "Date", "Status", "Items Count", "Total Amount");
		System.out.println(line);

		for (Order order : orders) {
			int itemCount = order.getLineItems().size();
			double totalAmount = order.getLineItems().stream().mapToDouble(LineItem::getTotalPrice).sum();

			String date = order.getLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE);

			System.out.printf(format, order.getId(), date, order.getOrderStatus().toString(), itemCount,
					String.format("₹ %.2f", totalAmount));
		}

		System.out.println(line);
	}

	public static void printDeliveryAgents(List<User> agents) {
		String format = "| %-36s | %-15s | %-25s | %-12s | %-12s |\n";
		String line = "+--------------------------------------+-----------------+---------------------------+--------------+--------------+";

		System.out.println("🚚 Delivery Agents:");
		System.out.println(line);
		System.out.printf(format, "ID", "Name", "Email", "Mobile", "Orders");
		System.out.println(line);

		for (User agentUser : agents) {
			DeliveryAgent agent = (DeliveryAgent) agentUser;
			System.out.printf(format, agent.getId(), agent.getName(), agent.getEmail(), agent.getMobileNumber(),
					agent.getOrders().size());
		}

		System.out.println(line);
	}

	public static void printInvoice(Invoice invoice) {
		List<LineItem> items = invoice.getOrder().getLineItems();

		System.out.println(BOX_LINE);
		System.out.printf("|%s|\n", centerText("🧾 INVOICE", BOX_WIDTH));
		System.out.println(BOX_LINE);

		printKeyValue("Invoice ID", invoice.getId().toString());
//  printKeyValue("Order ID", invoice.getOrder().toString());
		printKeyValue("Customer Name", invoice.getCustomerName());
		printKeyValue("Payment ID", invoice.getPaymentId().toString());
		printKeyValue("Date", invoice.getCreatedAt().toString());

		System.out.println(BOX_LINE);
		System.out.printf("|%s|\n", centerText("Items", BOX_WIDTH));
		System.out.println(BOX_LINE);

		for (LineItem item : items) {
			String name = item.getFoodItem().getName();
			double totalPrice = item.getTotalPrice()+item.getDiscountPrice();
			int qty = item.getQuantity();
			String line = String.format("%s x%d", name, qty);
			printKeyValue(line, String.format("₹%.2f", totalPrice));
		}

		System.out.println(BOX_LINE);

		printKeyValue("Total Amount", String.format("₹%.2f", invoice.getTotalAmount()));
		printKeyValue("Discount", String.format("₹%.2f", invoice.getDiscountAmount()));
		printKeyValue("Final Amount", String.format("₹%.2f", invoice.getFinalAmount()));
		printKeyValue("Payment Status", invoice.isPaid() ? "PAID" : "UNPAID");

		System.out.println(BOX_LINE);
		System.out.printf("|%s|\n", centerText("Thank you for ordering with Foodify!", BOX_WIDTH));
		System.out.println(BOX_LINE + "\n");
	}

	private static void printKeyValue(String key, String value) {
		String formatted = String.format("%-15s : %s", key, value);
		System.out.printf("| %-48s |\n", formatted);
	}

}
