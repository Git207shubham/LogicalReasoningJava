package com.core.multithreading.multithreadingSynchronous.runnableANDclasslock;

public class Test {

	public static void main(String[] args) {

		MyRunnableSharedResource sharedObj1 = new MyRunnableSharedResource(5);
		
		MyRunnableSharedResource sharedObj2 = new MyRunnableSharedResource(7);

		// both thread use same obj of shared resurce
		Thread t1 = new Thread(sharedObj1);
		Thread t2 = new Thread(sharedObj1);
		
		// t3 uses a DIFFERENT object, but sharedMethod() is static synchronized
		// -> class level lock, so t3 also waits; all 3 threads run one after another
		// (with a non-static synchronized method, t3 would run in parallel with t1/t2)
		Thread t3 = new Thread(sharedObj2);

		t1.start();
		t2.start();
		t3.start();

	}
}

class MyRunnableSharedResource implements Runnable {

	int x;

	public MyRunnableSharedResource(int x) {
		this.x = x;
	}

	@Override
	public void run() {

		sharedMethod(x);
	}


	public static synchronized  void sharedMethod(int s) {

		for (int i = 1; i < 4; i++) {
			System.out.println(s+"  "+Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}


