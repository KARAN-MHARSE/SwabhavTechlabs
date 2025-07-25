package com.aurionpro.learninterface.payment;

import java.util.Random;

public interface PaymentGateway {

	void pay(double ammount);
	
	private String returnString() {
		return "Karan";
	}
	
	default String generateTransactionNumber() {
		Random random = new Random();
		System.out.println(returnString());
		return "TX"+ (int)(random.nextInt(1000)+100000000);
	}
	
}
