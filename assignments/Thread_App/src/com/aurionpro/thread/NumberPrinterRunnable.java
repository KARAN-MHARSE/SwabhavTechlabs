package com.aurionpro.thread;

public class NumberPrinterRunnable implements Runnable {

	@Override
	public void run() {
		for(int i=5;i>=0 ; i--) {
			System.out.println(Thread.currentThread().getName()+":"+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
