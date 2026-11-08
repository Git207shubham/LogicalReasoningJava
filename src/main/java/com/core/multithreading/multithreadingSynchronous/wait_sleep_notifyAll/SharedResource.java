package com.core.multithreading.multithreadingSynchronous.wait_sleep_notifyAll;

import java.util.Scanner;

public class SharedResource {

	public synchronized void show() {
		System.out.println("inside show....");

		try {
			// wait() RELEASES the lock (sleep() does not), so display() can now run
			// wait(2000) -> wakes up on notify()/notifyAll() OR after 2 seconds, whichever is first
			wait(2000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
		System.out.println("lock release by other thread  ..so leaving...");
	}

	public synchronized void display() {

		System.out.println("inside display....");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter some number ...");
		int s = sc.nextInt();
		System.out.println("thank you");
		// wakes up ALL threads waiting on this object (notify() wakes only one)
		// the woken thread continues only after this method exits and releases the lock
		notifyAll();

	}

}
