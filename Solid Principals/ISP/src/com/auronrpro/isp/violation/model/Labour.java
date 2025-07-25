package com.auronrpro.isp.violation.model;

import com.auronrpro.isp.violation.repo.IWorker;

public class Labour implements IWorker {

	@Override
	public void startWork() {
		System.out.println("Labour start working");
		
	}

	@Override
	public void stopWork() {
		System.out.println("Laboour stop work");
		
	}

	@Override
	public void eat() {
		System.out.println("Labour start eating");
		
	}

	@Override
	public void drink() {
		System.out.println("Labour start drinking");
	}

}
