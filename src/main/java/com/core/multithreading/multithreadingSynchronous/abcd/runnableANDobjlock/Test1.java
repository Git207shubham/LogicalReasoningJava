package runnableANDobjlock;

public class Test1 {

	public static void main(String[] args) {

		Runnnnable r = new Runnnnable();

		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);

		t1.start();
		t2.start();
	}

}
