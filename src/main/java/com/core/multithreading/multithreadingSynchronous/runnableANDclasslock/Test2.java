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

		// any Class object works as a class level lock; Runn.class (from the abcd package)
		// is used here, so this block also blocks threads running Runn.display()
		// CustomRunnable2.class would be the more usual choice
		synchronized (com.core.multithreading.multithreadingSynchronous.abcd.runnableANDclasslock.Runn.class) {

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
