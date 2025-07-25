package com.auronrpro.isp.violation;

import com.auronrpro.isp.violation.model.Labour;
import com.auronrpro.isp.violation.model.Robot;
import com.auronrpro.isp.violation.repo.IWorker;

public class Workers {

	public static void main(String args[]) {
		IWorker worker = new Labour();
		IWorker worker2 = new Robot();
		
		worker.startWork();
		worker2.startWork();
		
		worker.drink();
		worker2.drink();
	}
}
