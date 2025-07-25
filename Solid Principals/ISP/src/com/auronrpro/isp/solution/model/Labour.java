package com.auronrpro.isp.solution.model;

import com.auronrpro.isp.solution.repo.IHuman;
import com.auronrpro.isp.solution.repo.Iworker;

public class Labour implements IHuman, Iworker {

	@Override
	public void startWork() {
		System.out.println("Labour start working");
		
	}

	@Override
	public void stopWork() {
		System.out.println("Labour stop work");
		
	}

	@Override
	public void eat() {
		System.out.println("Labout eating brunch");
		
	}

	@Override
	public void drink() {
		System.out.println("Labour drinks water");
		
	}

}
