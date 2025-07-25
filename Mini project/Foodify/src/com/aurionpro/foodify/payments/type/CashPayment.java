package com.aurionpro.foodify.payments.type;

import java.util.Scanner;

import com.aurionpro.foodify.interfaces.IPaymentType;

public class CashPayment implements IPaymentType {

	@Override
	public boolean pay(Scanner scanner,double amount) {
		System.out.println("amount pay throgh cash");
		return true;
	}

}
