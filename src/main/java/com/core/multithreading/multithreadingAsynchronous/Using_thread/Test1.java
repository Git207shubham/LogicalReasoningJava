package com.core.multithreading.multithreadingAsynchronous.Using_thread;

public class Test1 {

	public static void main(String[] args) {

		Even e1 = new Even(0, 20); // thread 1

		Even e2 = new Even(40, 60); // thread 2

		Odd o1 = new Odd(111, 121); // thread 3

		Odd o2 = new Odd(151, 161); // thread 4

		o1.setName(" ODD_11 ");
		e1.setName(" EVEN_11 ");
		o2.setName(" ODD_22 ");
		e2.setName(" EVEN_22 ");

		e1.start();

		e2.start();

		o1.start();

		o2.start();

	}
}

class Even extends Thread {

	int x;
	int y;

	public Even(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void run() {

		for (int i = x; i <= y; i++) {
			System.out.println(i + Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}
}

class Odd extends Thread {

	int x;
	int y;

	public Odd(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void run()

	{
		for (int i = x; i <= y; i++) {

			System.out.println(i + Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;

		}

	}
}
