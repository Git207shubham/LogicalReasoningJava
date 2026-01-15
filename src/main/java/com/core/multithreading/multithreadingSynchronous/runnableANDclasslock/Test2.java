package com.core.multithreading.multithreadingSynchronous.runnableANDclasslock;

public class Test2 {

	public static void main(String[] args) {

		CustomRunnable2 r = new CustomRunnable2();

		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);

		t1.start();
		t2.start();
	}
}

class CustomRunnable2 implements Runnable {

	@Override
	public void run() {
		display();

	}

	// another way to represent class level lock

	public void display() {

		synchronized (runnableANDclasslock.Runn.class) {

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

}
