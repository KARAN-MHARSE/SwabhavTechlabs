package com.aurionpro.thread;

public class ThreadTest {

	public static void main(String args[]) {
		
		System.out.println("Start"+Thread.currentThread());
		
//		NumberPrinterThread thread1 = new NumberPrinterThread("thread1");
//		thread1.start();
		
//		NumberPrinterThread thread2 = new NumberPrinterThread("thread2");
//		thread2.start();
		
		Thread thread1 = new Thread(new NumberPrinterRunnable());
		thread1.start();
		
		System.out.println("Exist"+Thread.currentThread());

	}
}
