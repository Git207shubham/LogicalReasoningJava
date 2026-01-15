package wait_sleep_notifyAll;

import java.util.Scanner;

public class SharedResource {

	public synchronized void show() {
		System.out.println("inside show....");

		try {
			wait(2000);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
		System.out.println("lock release by other thread  ..so leaving...");
	}

	public synchronized void display() {

		System.out.println("inside display....");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter some number ...");
		int s = sc.nextInt();
		System.out.println("thank you");
		notifyAll();

	}

}
