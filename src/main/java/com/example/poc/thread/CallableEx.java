package com.example.poc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class Point implements Callable<String> {
	@Override
	public String call() throws Exception {
		return "I am callable";
	}
}

public class CallableEx {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<String> task = new FutureTask<>(new Point());
		Thread t1 = new Thread(task, "abc");
		t1.start();
		System.out.println(t1.getName());
		System.out.println(task.get());
	}
}