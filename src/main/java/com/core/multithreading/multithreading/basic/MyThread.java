package com.core.multithreading.multithreading.basic;

/*
When you extend Thread, you:
Override the run() method → task
        Call start() → JVM creates a new thread
        JVM internally calls run()
        */

// step_4 : t.start() ; get the thread in runnable state
// and jvm then allocated processor to decide which thread to run acc to thread scheduler
// after task completion the thread comes in dead state
// but sometimes after running a thread may go to
// non runnable state , wait , sleep , suspend state ....we will code for it in run method body


public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                    Thread.currentThread().getName() + " : " + i
            );
        }
    }
}

class TestThread {
    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();   // creates new thread
        t2.start();   // creates new thread
    }
}

