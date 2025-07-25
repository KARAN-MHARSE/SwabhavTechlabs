package com.auronrpro.isp.solution;

import com.auronrpro.isp.solution.model.Labour;
import com.auronrpro.isp.solution.model.Robot;
import com.auronrpro.isp.solution.repo.IHuman;
import com.auronrpro.isp.solution.repo.IRobot;

public class Main {
	public static void main(String args[]) {
		Robot robot = new Robot();
		Labour labour = new Labour();
		
		robot.startWork();
		labour.startWork();
		robot.charge();
		labour.eat();
		robot.stopWork();
		labour.stopWork();
	}
}
