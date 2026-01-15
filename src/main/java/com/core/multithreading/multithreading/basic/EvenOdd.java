package com.core.multithreading.multithreading.basic;

public class EvenOdd {

	public static void main(String[] args) {

		Even e1 = new Even(0, 10);

		Even e2 = new Even(20, 30);

		Odd o1 = new Odd(1, 11);

		Odd o2 = new Odd(21, 31);

		// above are not threads

		Thread t1 = new Thread(e1);

		// class level lock ??---no
		// to connect Odd , Even classes to thread class
		// we created this obj of Thread class

		Thread t2 = new Thread(e2);

		Thread t3 = new Thread(o1);

		Thread t4 = new Thread(o2);

		t1.setName("EVEN_1_");
		t2.setName("Even_2");
		t3.setName("ODD_1_");
		t4.setName("ODD_2");

		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}
}


class Even implements Runnable {

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
class Odd implements Runnable {

	int x;
	int y;

	public Odd(int x, int y) {
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
