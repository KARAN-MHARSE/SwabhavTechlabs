package com.auronrpro.isp.solution.model;

import com.auronrpro.isp.solution.repo.IRobot;
import com.auronrpro.isp.violation.repo.IWorker;

public class Robot implements IWorker,IRobot{

	@Override
	public void charge() {
		System.out.println("Robot charging start");
		
	}

	@Override
	public void startWork() {
		System.out.println("Robot start working");
		
	}

	@Override
	public void stopWork() {
		System.out.println("Robot stop working");		
	}

//	@Override
//	public void eat() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void drink() {
//		// TODO Auto-generated method stub
//		
//	}

}
