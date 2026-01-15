package com.core.multithreading.multithreadingSynchronous;

public class ObjectAndClassLock {

	// lock equal to shared resource's object

	// Thread tries to get lock of object for entering a synchronised method

	public static void main(String[] args) {

		TableBasicClass1 t1 = new TableBasicClass1();
		Mythread1 thread1 = new Mythread1(2, t1);
		// thread1 will have object level lock m1 achieved by t1 object if it reached m1

		Mythread2 thread2 = new Mythread2(3, t1);
		// even though Thread1 and Thread2 are totally different threads
		// making method of shared resources(TableBasicClass1) synchronized makes sure only one thread can access it at a time

		// similar can be done by synchronized block inside method
		// same can be achived by using comman shared object to lock one thread at a time

		thread1.start();
		thread2.start();
	}
}

class Mythread1 extends Thread {

	int n;
	TableBasicClass1 t1;

	public Mythread1(int n, TableBasicClass1 t1) {
		this.n = n;
		this.t1 = t1;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		// t1 will have Object obj1 or 2 or 3 of TableBasicClass1  or Object2 at at time so , thread which reached here tries to get lock of t1 if free
		t1.m1(n);
	}
}

class Mythread2 extends Thread {

	int n;
	TableBasicClass1 t1;

	public Mythread2(int n, TableBasicClass1 t1) {
		this.n = n;
		this.t1 = t1;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		t1.m1(n);
	}
}

class TableBasicClass1 {

	public synchronized void m1(int n) {

		for (int i = 1; i <= 10; i++) {
			System.out.println(n * i);
		}

		System.out.println("");
	}
}
