package com.core.multithreading.multithreading.basic;

public class MyRunnable extends Thread implements Runnable {

	int x;

	public MyRunnable(int x)
	{
		this.x=x;
	}

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			System.out.println("Run method thread--- " + i*x);
		}
	}
}

class Test {

	public static void main(String[] args) {
		MyRunnable mr = new MyRunnable(11);

		// mr.start();

		// main method flow / thread continues to run
		// and mr.start() starts running new thread ie
		// run method in class A

		Thread t = new Thread(mr);

		t.start();

		for (int i = 50; i < 60; i++) {
			System.out.println("mainnn method thread --" + i);
		}

	}
}
