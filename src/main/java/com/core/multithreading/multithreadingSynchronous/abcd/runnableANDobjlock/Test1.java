package com.core.multithreading.multithreadingSynchronous.abcd.runnableANDobjlock;

public class Test1 {

	public static void main(String[] args) {

		// OBJECT LEVEL LOCK: both threads share the SAME object r
		// display() is synchronized (non-static) -> lock is on r, so t2 waits for t1
		// if each thread had its own Runnnnable object, they would run in parallel
		Runnnnable r = new Runnnnable();

		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);

		t1.start();
		t2.start();
	}

}
