package runnableANDclasslock;

public class Test1 {

	public static void main(String[] args) {

		Runn r = new Runn();

		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);

		t1.start();
		t2.start();
	}
}
