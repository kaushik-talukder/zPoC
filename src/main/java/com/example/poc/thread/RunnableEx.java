package com.example.poc.thread;

class Student implements Runnable {
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}

public class RunnableEx {
	public static void main(String[] args) {
		Thread t = new Thread(new Student());
		t.start();
		System.out.println(Thread.currentThread().getName());
	}
}

