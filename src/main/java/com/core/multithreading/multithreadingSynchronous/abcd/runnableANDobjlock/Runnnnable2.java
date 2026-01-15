package runnableANDobjlock;

public class Runnnnable2 implements Runnable {

	@Override
	public void run() {
		display();

	}

	public void display() {

		synchronized (this) {
			// this will point to currently running object

			// since this method is synchronised , calling thread must aquire the lock
			// so calling thred t1 will aquire lock of r then only enter method display
			// when thread t2 calls run method then display method , this t2 thred must
			// aquire
			// the lock of r but its alrwady aquired by thred t1 so will wait till t1
			// releases lock of r

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
