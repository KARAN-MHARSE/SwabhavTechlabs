package com.aurinonrpo.strategy.statergyadapter;

import com.aurionpro.strategy.repo.IOperation;

public class OperationStrategy {
	IOperation operation;

	public OperationStrategy(IOperation operation) {
		this.operation = operation;
	}
	
	
	public void addOperation(IOperation operation) {
		this.operation = operation;
	}
	
	public int doOperation(int number1, int number2) {
		return operation.doOperation(number1, number2);
	}

}
