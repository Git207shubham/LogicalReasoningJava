package com.core.multithreading.multithreadingSynchronous.wait_sleep_notifyAll;

public class Test {
	public static void main(String[] args) {

		// both threads must use the SAME object, because wait/notify work on that object's lock
		SharedResource sharedObj = new SharedResource();

		Mythread s1 = new Mythread(sharedObj, 5);

		Mythread s2 = new Mythread(sharedObj, 10);

		// start order is not guaranteed: if s2 gets the lock first, its notifyAll() happens
		// before s1 waits, and s1 just leaves after the 2 second timeout
		s1.start();
		s2.start();

	}

}
