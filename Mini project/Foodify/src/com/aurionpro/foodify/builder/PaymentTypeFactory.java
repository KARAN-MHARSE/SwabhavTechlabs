package com.aurionpro.foodify.builder;

import com.aurionpro.foodify.exceptions.CustomException;
import com.aurionpro.foodify.interfaces.IPaymentType;
import com.aurionpro.foodify.payments.type.CardPayment;
import com.aurionpro.foodify.payments.type.CashPayment;
import com.aurionpro.foodify.payments.type.UpiPayment;

public class PaymentTypeFactory {
	public static IPaymentType getPaymentMethod(String type) {
		switch (type) {
		case "card": 
			return new CardPayment();
		case "cash":
			return new CashPayment();
		case "upi":
			return new UpiPayment();
		default:
			throw new CustomException("Wrong payment method");
		}
	}

}
