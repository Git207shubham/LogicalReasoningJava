package com.core.multithreading.multithreadingSynchronous;


public class ObjectLockTest {

	public static void main(String[] args) {

		Hello1 h = new Hello1();

		A1 t1 = new A1(h, "java"); // thred 1--using obj 1

		A1 t2 = new A1(h, "class"); // thread 2---using obj 1

		t1.start();
		t2.start();

	}
}

class A1 extends Thread {

	Hello1 h;
	String msg;

	public A1(Hello1 h, String msg) {
		this.h = h;
		this.msg = msg;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		h.display(msg);
	}
}

class Hello1 {

	public synchronized void display(String msg)

	// we applied object level lock on this method/block
	// synchronize this block if called by same object
	// or if called indirectly but simulantneously

	// if this method is called by h1, h2 , h3 then there will be
	// no synchronism becoz only object level lock not class level

	{
		System.out.println("[");
		System.out.println(msg);
		System.out.println("]");
	}
}
