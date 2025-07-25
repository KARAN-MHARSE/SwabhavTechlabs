package com.aurionpro.learninterface.payment;

public class UpiPayment implements PaymentGateway{
	@Override
	public void pay(double ammount) {
		System.out.println("Payment done through the UPI Payment and the transaction id is: "+ PaymentGateway.generateTransactionNumber());
		
	}

}
