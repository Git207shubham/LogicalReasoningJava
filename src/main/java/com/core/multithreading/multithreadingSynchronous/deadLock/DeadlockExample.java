package deadLock;

public class DeadlockExample {
    public static void main(String[] args) {
        // Two shared resources
        Object resource1 = new Object();
        Object resource2 = new Object();

        // Create Thread objects
        Thread thread1 = new Thread(new MyRunnable(resource1, resource2));
        Thread thread2 = new Thread(new MyRunnable(resource2, resource1));

        // Start the threads
        thread1.start();
        thread2.start();
    }
}

class MyRunnable implements Runnable {
    private final Object resource1;
    private final Object resource2;

    public MyRunnable(Object resource1, Object resource2) {
        this.resource1 = resource1;
        this.resource2 = resource2;
    }

    @Override
    public void run() {
        synchronized (resource1) {
            System.out.println(Thread.currentThread().getName() + ": Locked "+resource1);
            try {
                Thread.sleep(100); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": Waiting for"+resource2);
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + ": Locked "+resource1);
            }
        }
    }
}

