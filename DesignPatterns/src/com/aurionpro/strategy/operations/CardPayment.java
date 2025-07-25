package com.aurionpro.strategy.operations;

import com.aurionpro.strategy.repo.IPayment;

public class CardPayment implements IPayment {

	@Override
	public boolean pay(int amount)  {
		System.out.println("payment in process using card");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		System.out.println("Payment failed, trying with another gateway");
		return false;
//		System.out.println(amount + " successfully paid using card");
		
	}

}
