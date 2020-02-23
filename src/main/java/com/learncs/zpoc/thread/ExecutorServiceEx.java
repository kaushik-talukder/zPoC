package com.learncs.zpoc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Square implements Runnable{

	@Override
	public void run() {
		System.out.println("I am runnable with submit");
	}
	
}

public class ExecutorServiceEx {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("I am runnable with exeute");
			}
		});

		Future<String> f = executorService.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "I am callable with submit";
			}
		});
		
		System.out.println(f.get());
		
		Future<?> f2 = executorService.submit(new Square());
		System.out.println(f2.get());
		
		executorService.shutdown();
	}
}
