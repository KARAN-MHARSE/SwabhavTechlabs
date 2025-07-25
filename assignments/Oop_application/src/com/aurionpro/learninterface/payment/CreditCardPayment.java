package com.aurionpro.learninterface.payment;

public class CreditCardPayment  implements PaymentGateway{

	@Override
	public void pay(double ammount) {
		System.out.println("Payment done through the credit card and the transaction id is: "+ PaymentGateway.generateTransactionNumber());
		
		
	}

}
