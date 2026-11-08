package com.core.multithreading.multithreadingSynchronous.abcd.runnableANDclasslock;

public class Test1 {

	public static void main(String[] args) {

		// display() is static synchronized -> class level lock on Runn.class
		// so t1 and t2 run it one after another (entering/exiting never overlap)
		// this would be true even with two different Runn objects
		Runn r = new Runn();

		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);

		t1.start();
		t2.start();
	}
}
