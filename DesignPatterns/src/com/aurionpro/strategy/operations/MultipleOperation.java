package com.aurionpro.strategy.operations;

import com.aurionpro.strategy.repo.IOperation;

public class MultipleOperation implements IOperation {

	@Override
	public int doOperation(int number1, int number2) {
		// TODO Auto-generated method stub
		return number1*number2;
	}

}
