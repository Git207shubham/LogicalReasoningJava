package com.core.multithreading.multithreadingSynchronous.wait_notify;

public class MythreadAndSharedResource extends Thread {


	MythreadAndSharedResource mt;
	public MythreadAndSharedResource() {

	}

	public MythreadAndSharedResource(MythreadAndSharedResource mt) {
		this.mt = mt;
	}
	
	@Override
	public void run() {

		synchronized (mt) 
		{
			System.out.println("inside run method of  "+Thread.currentThread().getName());
			try {
				Thread.sleep(5000);  //-- doesnt relese lock ---if so..second thread would have started
				mt.wait();  // release lock---sleep till other thread with lock call notify
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("lock released by Second thread....");
		}
	}



	public static void main(String[] args) {

		// mt is never started; it is only used as the shared lock object for wait/notify
		MythreadAndSharedResource mt = new MythreadAndSharedResource();
		MythreadAndSharedResource mt1 = new MythreadAndSharedResource(mt);
		Mythread2 mt2= new Mythread2(mt);

		// NOTE: if mt2 gets the lock first, notify() is called before mt1 waits,
		// and mt1 then waits forever (wait() has no timeout here)
		mt1.start();
		mt2.start();
	}

}
