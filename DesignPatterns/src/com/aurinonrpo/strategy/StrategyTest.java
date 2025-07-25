package com.aurinonrpo.strategy;

import com.aurinonrpo.strategy.statergyadapter.OperationStrategy;
import com.aurionpro.strategy.operations.AddOperation;
import com.aurionpro.strategy.operations.MultipleOperation;
import com.aurionpro.strategy.repo.IOperation;

public class StrategyTest {
	public static void main(String args[]) {
		OperationStrategy operationStrategy = new OperationStrategy(new AddOperation());
		System.out.println(operationStrategy.doOperation(10, 10));
		operationStrategy.addOperation(new MultipleOperation());
		System.out.println(operationStrategy.doOperation(10, 10));
		
		
	}

}
