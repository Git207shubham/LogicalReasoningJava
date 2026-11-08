package com.core.multithreading.multithreadingSynchronous.abcd.runnableANDclasslock;

// CLASS LEVEL LOCK using a static synchronized method
// the lock is taken on Runn.class (one lock per class), not on a Runn object
public class Runn implements Runnable {

	@Override
	public void run() {
		display();

	}

	public static synchronized void display() {

		// we use static keyword dto aplly class level lock
		// becoz static represents "class level"
		try {
			System.out.println(Thread.currentThread().getName() + " entering ");
			// sleep() does NOT release the lock, so the other thread keeps waiting
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " exiting ");
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

}
