package wait_sleep_notifyAll;

public class Test {
	public static void main(String[] args) {

		SharedResource sharedObj = new SharedResource();

		Mythread s1 = new Mythread(sharedObj, 5);

		Mythread s2 = new Mythread(sharedObj, 10);

		s1.start();
		s2.start();

	}

}
