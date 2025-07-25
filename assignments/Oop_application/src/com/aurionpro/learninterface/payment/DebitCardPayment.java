package com.aurionpro.learninterface.payment;

public class DebitCardPayment implements PaymentGateway
{
	@Override
	public void pay(double ammount) {
		System.out.println("Payment done through the Debit card and the transaction id is: "+ PaymentGateway.generateTransactionNumber());
		
	}

}
