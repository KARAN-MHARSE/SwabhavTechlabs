package com.aurinonrpo.strategy.statergyadapter;

import com.aurionpro.strategy.repo.IPayment;

public class PaymentStrategy {
	IPayment paymentGateway;
	
	public PaymentStrategy(IPayment payment) {
		this.paymentGateway = payment;
	}
	
	public void chooseNewPaymentGateway(IPayment paymentGateway){
		this.paymentGateway = paymentGateway;
	}
	
	public boolean doPayment(int amount) {
		return paymentGateway.pay(amount);
	}

}
