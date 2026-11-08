package com.core.multithreading.multithreadingSynchronous.abcd.runnableANDclasslock;

public class Test2 {

	public static void main(String[] args) {

		// same result as Test1, but the class lock comes from synchronized (Runn.class) block
		Runnn r = new Runnn();

		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);

		t1.start();
		t2.start();
	}
}
