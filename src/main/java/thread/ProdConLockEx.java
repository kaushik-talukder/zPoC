package thread;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Producer1 extends Thread {
	PC1 pc;

	Producer1(PC1 pc) {
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

class Consumer1 extends Thread {
	PC1 pc;

	Consumer1(PC1 pc) {
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

class PC1 {
	private LinkedList<Integer> list = new LinkedList<>();
	private int capacity = 5;
	private ReentrantLock lock = new ReentrantLock();
	private final Condition bufferNotFull = lock.newCondition(); 
	private final Condition bufferNotEmpty = lock.newCondition();

	// Function called by producer thread
	public void produce() throws InterruptedException {
		int value = 0;
		while (true) {
			lock.lock();
			try {
				while (list.size() == capacity) {
					bufferNotEmpty.await();
				}
				System.out.println("Producer produced-" + value);
				list.add(value++);
				bufferNotFull.signalAll();
				Thread.sleep(1000);
			} finally {
				lock.unlock();
			}
		}
	}

	// Function called by consumer thread
	public void consume() throws InterruptedException {
		while (true) {
			lock.lock();
			try {
				while (list.size() == 0) {
					bufferNotFull.await();
				}
				int val = list.removeFirst();
				System.out.println("Consumer consumed-" + val);
				bufferNotEmpty.signalAll();
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}
}

public class ProdConLockEx {
	public static void main(String[] args) throws InterruptedException {
		final PC1 pc = new PC1();
		// Create producer thread
		Thread t1 = new Producer1(pc);

		// Create consumer thread
		Thread t2 = new Consumer1(pc);
		
		// Start both threads
		t1.start();
		t2.start();

		// t1 finishes before t2
		//t1.join();
		//t2.join();
	}
}