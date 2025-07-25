package com.aurinonrpo.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.aurinonrpo.strategy.model.Product;
import com.aurinonrpo.strategy.statergyadapter.PaymentStrategy;
import com.aurionpro.strategy.operations.CardPayment;
import com.aurionpro.strategy.operations.PaypalPayment;
import com.aurionpro.strategy.operations.UpiPayment;

public class PaymentStrategyTest {
	public static void main(String args[]) {
		List<Product> products = new ArrayList<Product>(
				Arrays.asList(
						new Product("Asus Laptop", 40000),
						new Product("Keyboard", 1000),
						new Product("Mouse", 3049)
						
						)
				);
		
		doOrder(products);
		
		
		
		
		
		
		
		
		
	}

	private static void doOrder(List<Product> products) {
		// TODO Auto-generated method stub
		ArrayList<Product> cart = new ArrayList<Product>(Arrays.asList(products.get(0), products.get(1)));

		payBill(cart);

	}

	private static void payBill(ArrayList<Product> cart) {
		System.out.println("Do your payment of 1000rs");
		int billAmount = calculateTotalBill(cart);

		PaymentStrategy paymentStrategy = new PaymentStrategy(new CardPayment());
		boolean isSuccefull =  paymentStrategy.doPayment(billAmount);
		if(isSuccefull) return;
		

		paymentStrategy.chooseNewPaymentGateway(new PaypalPayment());
		isSuccefull =  paymentStrategy.doPayment(billAmount);
		if(isSuccefull) return;
		
		paymentStrategy.chooseNewPaymentGateway(new UpiPayment());
		paymentStrategy.doPayment(billAmount);

	}

	private static int calculateTotalBill(ArrayList<Product> cart) {
		int total = 0;
		
		for(Product product : cart) {
			total+=product.getPrice();
		}
		return total;
	}

}
