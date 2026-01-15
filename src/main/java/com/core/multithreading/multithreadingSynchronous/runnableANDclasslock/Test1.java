package com.core.multithreading.multithreadingSynchronous.runnableANDclasslock;

public class Test1 {

	public static void main(String[] args) {

		CustomRunnable1 r = new CustomRunnable1();

		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);

		t1.start();
		t2.start();
	}
}

class CustomRunnable1 implements Runnable {

	@Override
	public void run() {
		display();

	}

	public static synchronized void display() {

		// we use static keywor dto aplly class level lock
		// becoz static represents "class level"
		try {
			System.out.println(Thread.currentThread().getName() + " entering ");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " exiting ");
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

}
