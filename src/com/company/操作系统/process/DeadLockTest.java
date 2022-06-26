package com.company.操作系统.process;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/06/20/22:35
 * @Description:
 */
public class DeadLockTest {
    // 用于死锁测试的代码
    public static Object o1 = new Object();
    public static Object o2 = new Object();

    public static void main(String[] args) {


        Thread thread1 = new Thread(new MyThread(o1, o2));
        Thread thread2 = new Thread(new MyThread(o1, o2));

        // 设置名称
        thread1.setName("线程一");
        thread2.setName("线程二");

        // 启动线程
        thread1.start();
        thread2.start();

    }
}

class MyThread implements Runnable {
    public Object o1;
    public Object o2;

    public MyThread(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o1) {
            try {
                Thread.sleep(100);
                synchronized (o2) {
                    System.out.println("获取成功！！！");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
