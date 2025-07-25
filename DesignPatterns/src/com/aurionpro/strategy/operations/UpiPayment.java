package com.aurionpro.strategy.operations;

import com.aurionpro.strategy.repo.IPayment;

public class UpiPayment implements IPayment {
	@Override
	public boolean pay(int amount) {
		System.out.println(amount + " successfully paid using card");
		return true;
	}

}
