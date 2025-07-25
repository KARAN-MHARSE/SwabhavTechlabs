package com.aurionpro.learninterface.payment;

public class PaypalPayment implements PaymentGateway {
	@Override
	public void pay(double ammount) {
		System.out.println("Payment done through the Paypal Gateway and the transaction id is: "+ PaymentGateway.generateTransactionNumber());
	}

}
