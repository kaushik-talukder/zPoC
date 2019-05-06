package thread;

class Teacher extends Thread implements Runnable {
	Teacher(String name) {
		super.setName(name);
		//this.start();
	}

	@Override
	public void run() {
		super.run();
		System.out.println("I am " + Thread.currentThread().getName());
	}
}

public class ThreadEx {
	public static void main(String[] args) {
		Thread t1 = new Teacher("Kaushik");
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Exitig main thread");
	}
}
