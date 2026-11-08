package com.core.multithreading.multithreadingSynchronous.wait_notify;

import java.util.Scanner;

public class Mythread2 extends Thread {

	public MythreadAndSharedResource mt1;

	public Mythread2(MythreadAndSharedResource mt3) {
		this.mt1 = mt3;
	}

	@Override
	public void run() {

		// notify() can only be called while holding the lock of mt1
		// (otherwise IllegalMonitorStateException)
		synchronized (mt1) {

			System.out.println("welcome to thread_--2");
			Scanner sc = new Scanner(System.in);
			System.out.println("enter number to notify waiting thread");
			int i = sc.nextInt();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// wakes the waiting thread; it resumes only after this block exits
			mt1.notify();
			
		}
	}
}
