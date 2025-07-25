package com.auronrpro.isp.violation.model;

import com.auronrpro.isp.violation.repo.IWorker;

public class Robot implements IWorker {

	@Override
	public void startWork() {
		System.out.println("Robot start working");
		
	}

	@Override
	public void stopWork() {
		System.out.println("Robot stop work");
		
	}

	@Override
	public void eat() {
		System.out.println("Robot cannot be eat");
		
	}

	@Override
	public void drink() {
		System.out.println("Robot cannot be drink anything");
		
	}

}
