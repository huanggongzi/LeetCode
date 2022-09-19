package com.company.netty;

import java.util.concurrent.Semaphore;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        new Thread(myThread).start();
        Thread.sleep(10);
        new Thread(myThread).start();
    }
}

class MyThread implements Runnable {
    Semaphore semaphore = new Semaphore(1);
    int count = 0;
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(count++);
        }
    }
}
