package com.core.multithreading.multithreadingSynchronous.deadLock;

public class DeadlockExample {
    public static void main(String[] args) {
        // Two shared resources
        Object resource1 = new Object();
        Object resource2 = new Object();

        // Create Thread objects
        // the two threads take the same locks in OPPOSITE order:
        // thread1: resource1 -> resource2, thread2: resource2 -> resource1
        // each holds one lock and waits for the other -> DEADLOCK (program never ends)
        // fix: make every thread take the locks in the same order
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
                // never reached when the deadlock happens
                // NOTE: prints resource1 again; resource2 was probably intended
                System.out.println(Thread.currentThread().getName() + ": Locked "+resource1);
            }
        }
    }
}

