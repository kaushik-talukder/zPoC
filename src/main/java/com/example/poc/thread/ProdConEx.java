package com.example.poc.thread;

import java.util.LinkedList;

class Producer extends Thread{
	PC pc;
	Producer(PC pc){
		this.pc = pc;
	}
	@Override
	public void run() {
		try {
			pc.produce();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Consumer extends Thread {
	PC pc;
	Consumer(PC pc){
		this.pc = pc;
	}
	@Override
	public void run() {
		try {
			pc.consume();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class PC {
	LinkedList<Integer> list = new LinkedList<>();
	int capacity = 5;

	// Function called by producer thread
	public void produce() throws InterruptedException {
		int value = 0;
		while (true) {
			synchronized (this) {
				while (list.size() == capacity) {
					wait();
				}
				System.out.println("Producer produced-" + value);

				list.add(value++);
				notify();
				Thread.sleep(1000);
			}
		}
	}

	// Function called by consumer thread
	public void consume() throws InterruptedException {
		while (true) {
			synchronized (this) {
				while (list.size() == 0) {
					wait();
				}
				int val = list.removeFirst();
				System.out.println("Consumer consumed-" + val);
				notify();
				Thread.sleep(1000);
			}
		}
	}
}

public class ProdConEx {
	public static void main(String[] args) throws InterruptedException {
		final PC pc = new PC();
		// Create producer thread
		Thread t1 = new Producer(pc);

		// Create consumer thread
		Thread t2 = new Consumer(pc);
		
		// Start both threads
		t1.start();
		t2.start();

		// t1 finishes before t2
		//t1.join();
		//t2.join();
	}
}