package wait_notify;

import java.util.Scanner;

public class Mythread2 extends Thread {

	public MythreadAndSharedResource mt1;

	public Mythread2(MythreadAndSharedResource mt3) {
		this.mt1 = mt3;
	}

	@Override
	public void run() {

		synchronized (mt1) {

			System.out.println("welcome to thread_--2");
			Scanner sc = new Scanner(System.in);
			System.out.println("enter number to notify waiting thread");
			int i = sc.nextInt();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mt1.notify();
			
		}
	}
}
