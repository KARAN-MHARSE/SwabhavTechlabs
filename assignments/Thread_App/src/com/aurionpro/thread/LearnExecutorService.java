package com.aurionpro.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LearnExecutorService {
	public static void main(String args[]) throws InterruptedException {
		
		Callable<Boolean> task = ()->{
			for(int i=0;i<10;i++) {
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
			return true;
		};
		
		List<Callable<Boolean>> tasks = Arrays.asList(
				task,task,task,task);
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.invokeAll(tasks);
		
		executorService.shutdown();
		
		
	}

}
