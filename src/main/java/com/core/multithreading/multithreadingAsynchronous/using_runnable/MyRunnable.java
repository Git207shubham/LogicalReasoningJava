package com.core.multithreadingAsynchronous.using_runnable;

public class MyRunnable implements Runnable {

	int x;

	public MyRunnable(int x) {
		this.x = x;
	}

	@Override
	public void run() {

		// IMP IMP IMP

		// we are calling m1 method for this instance of MyRunnable class
		//  we are calling m1 method for this THREAD
		m1(x);
	}

	public void m1(int s) {

		for (int i = 1; i < 4; i++) {
			System.out.println(s);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Test {

	public static void main(String[] args) {

		MyRunnable mr = new MyRunnable(5);

		Thread thread1 = new Thread(mr);
		thread1.start();

	}
}
