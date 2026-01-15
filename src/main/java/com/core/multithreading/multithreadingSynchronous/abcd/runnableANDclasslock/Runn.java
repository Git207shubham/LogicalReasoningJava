package runnableANDclasslock;

public class Runn implements Runnable {

	@Override
	public void run() {
		display();

	}

	public static synchronized void display() {

		// we use static keywor dto aplly class level lock
		// becoz static represents "class level"
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
