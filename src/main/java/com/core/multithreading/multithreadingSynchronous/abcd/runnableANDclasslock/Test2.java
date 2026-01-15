package runnableANDclasslock;

public class Test2 {

	public static void main(String[] args) {

		Runnn r = new Runnn();

		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);

		t1.start();
		t2.start();
	}
}
