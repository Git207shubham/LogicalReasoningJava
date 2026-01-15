package runnableANDclasslock;

public class Runnn implements Runnable {

	@Override
	public void run() {
		display();

	}

	// another way to represent class level lock

	public void display() {

		synchronized (Runn.class) {

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
