package com.core.multithreading.multithreadingSynchronous.wait_sleep_notifyAll;

public class Mythread extends Thread {

	int x;
	SharedResource v;

	public Mythread(SharedResource v, int x) {
		this.x = x;
		this.v = v;
	}

	@Override
	public void run() {

		System.out.println("welcome.......");
		// x decides the role: 5 -> waiting thread (show), anything else -> notifying thread (display)
		if (x == 5) {
			v.show();
		} else {
			v.display();
		}
	}

}
