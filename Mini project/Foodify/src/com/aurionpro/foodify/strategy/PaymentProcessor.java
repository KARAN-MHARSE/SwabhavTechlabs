package com.aurionpro.foodify.strategy;

import java.util.Scanner;

import com.aurionpro.foodify.builder.PaymentTypeFactory;
import com.aurionpro.foodify.interfaces.IPaymentType;

public class PaymentProcessor {
	public static boolean processPayment(String paymentType, double amount) {
		Scanner scanner = new Scanner(System.in);
		return PaymentTypeFactory.getPaymentMethod(paymentType).pay(scanner, amount);
	}
	
	

}
