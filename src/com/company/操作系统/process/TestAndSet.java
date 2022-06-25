package com.company.操作系统.process;

public class TestAndSet {
    int flag = 0;

    public static void main(String[] args) {
        TestAndSet testAndSet = new TestAndSet();
        testAndSet.init();
        testAndSet.lock();
        testAndSet.lock();
    }

    // 加锁
    public void lock() {
        while (testAndSet(1) == 1) {
        }
        //
        System.out.println("我抢占了锁");
    }

    // 解锁
    public void unLock() {
        flag = 0;
    }

    // 初始化
    public void init() {
        flag = 0;
    }

    // 这是一个原子的操作
    public int testAndSet(int newValue) {
        int old = flag;
        flag = newValue;
        return old;
    }
}
