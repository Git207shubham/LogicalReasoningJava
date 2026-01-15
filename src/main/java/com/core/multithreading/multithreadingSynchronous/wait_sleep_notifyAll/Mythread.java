package wait_sleep_notifyAll;

public class Mythread extends Thread {

	int x;
	SharedResource v;

	public Mythread(SharedResource v, int x) {
		this.x = x;
		this.v = v;
	}

	@Override
	public void run() {

		System.out.println("welcome.......");
		if (x == 5) {
			v.show();
		} else {
			v.display();
		}
	}

}
