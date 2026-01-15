package com.core.multithreading.multithreadingSynchronous.runnableANDobjlock;

class SharedResource {

	public synchronized void display(int x) {

		try {
//			System.out.println(Thread.currentThread().getName() + " entering " + " : " + x);
//			Thread.sleep(1000);
//			System.out.println(Thread.currentThread().getName() + " exiting " + " : " + x);
//			Thread.sleep(1000);

			for (int i = 0; i < 6; i++) {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() +"  "+x);
			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

//		for (int i = 0; i < 6; i++) {
//			Thread.sleep(1000);
//			System.out.println(x);
//		}
	}
}

public class MyRunnable1 implements Runnable {
	SharedResource sharedObj;
	int x;
	int y;
	
	public MyRunnable1(SharedResource sharedObj, int x,int y) {
		this.x = x;
		this.y = y;
		this.sharedObj = sharedObj;
	}

	public MyRunnable1(SharedResource sharedObj, int x) {
		this.sharedObj = sharedObj;
		this.x = x;
	}

	// one object of Display class can access the display method at a time
	// becoz object level lock applied on the display method
	// if one thread achieved the object level lock means it called display using that object
	// so other wil have to wait till that thread leaves that object of release the
	// object level lock

	// other thread we can use other object of dislay class can access anytime

	@Override
	public synchronized void run() {

		// this display method call is related to one instance of MyRunnable
		// if using same runbavle object if we create thread and satrt thread then
		// display method gethods get invoke
		// so to stop from getting invoked we will use object level lock on the display
		// method
		sharedObj.display(x);
	}
}

class MyRunnable2 implements Runnable {

	@Override
	public void run() {
		display();
	}

	public synchronized void display() {
		try {
			System.out.println(Thread.currentThread().getName() + " entering ");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " exiting ");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyRunnable3 implements Runnable {

	@Override
	public void run() {
		display();

	}

	public void display() {
		synchronized (this) {
			try {
				System.out.println(Thread.currentThread().getName() + " entering ");
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName() + " exiting ");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Test1 {

	//IMP
	//both THREADS should hold same sharedResource object--to  hold obj level lock

	public static void main(String[] args) {

		SharedResource sharedObj1 = new SharedResource();
		MyRunnable1 run = new MyRunnable1(sharedObj1, 2);
		MyRunnable1 run2 = new MyRunnable1(sharedObj1, 6);
		Thread t1 = new Thread(run);
		Thread t2 = new Thread(run2);
		t1.start();
		t2.start();

		SharedResource sharedObj2 = new SharedResource();
		MyRunnable1 r2 = new MyRunnable1(sharedObj2, 5);
		Thread t3 = new Thread(run);
		t3.start();
	}

}

class Test2 {

	public static void main(String[] args) {

		MyRunnable2 r = new MyRunnable2();
		MyRunnable2 r2 = new MyRunnable2();

		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r2);

		t1.start();
		t2.start();

		// Since display() is synchronized, the calling thread must acquire
		// the lock of the object on which the method is invoked.
		// Thread t1 calls display() on object r,
		// so t1 acquires the lock of object r.
		// Thread t2 calls display() on object r2,
		// so t2 acquires the lock of object r2.
		// Since r and r2 are different objects,
		// both threads acquire different locks and do NOT block each other.

//		//Now both need lock of same object r
//		Thread t3 = new Thread(r);
//		Thread t4 = new Thread(r);
//		t3.start();
//		t4.start();

	}
}
