package runnableANDobjlock;

public class Test2 {

	public static void main(String[] args) {

		Runnnnable r = new Runnnnable();
		Runnnnable r2 = new Runnnnable();

		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r2);

		t1.start();
		// THREAD t1 will aquire lock of object r while entering synchronised method
		// display
		t2.start();
		// THREAD t12 will aquire lock of object r1 while entering synchronised method
		// display and wont wait to thread t1 to release lock for it to enter sync
		// method display

		// in o/p we will see that thread boththead will enter sync method dicplay
		// simultaneously unlike Test1
	}
}
