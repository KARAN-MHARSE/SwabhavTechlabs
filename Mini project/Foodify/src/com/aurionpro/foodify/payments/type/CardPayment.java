package com.aurionpro.foodify.payments.type;

import java.util.Scanner;

import com.aurionpro.foodify.exceptions.CustomException;
import com.aurionpro.foodify.interfaces.IPaymentType;

public class CardPayment implements IPaymentType {

	@Override
	public boolean pay(Scanner scanner,double amount) {
		System.out.println("Enter the 16 digit Card Number");
		String cardID = scanner.nextLine();
		if(cardID.length() != 16) throw new CustomException("Card Number is not valid");
		
		System.out.println("Enter the 4 digit pin");
		int pin =0;
		try {
			 pin = scanner.nextInt();
			scanner.nextLine();	
		} catch (Exception e) {
			System.err.println("Pin number must be in number format");
			return false;
		}	
		
		if(Integer.toString(pin).length() != 4) throw new CustomException("Pin length should be of 4 digit.");
		
		
		System.out.println("Wait for 2 second, your payment is in processing");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Wait, we are checking");
		}		
		System.out.println("amount paid throgh card");
		return true;
		
	}

}
