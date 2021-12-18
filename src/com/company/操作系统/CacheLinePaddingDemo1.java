package com.company.操作系统;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/18/19:25
 * @Description:
 */
public class CacheLinePaddingDemo1 {
    static long BASENUM = 10_1000_0000L;
    private static volatile long[] arr = new long[2];

    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < BASENUM; i++) {
                arr[0] = i;
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < BASENUM; i++) {
                arr[1] = i;
            }
        });
        final long start = System.nanoTime();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println((System.nanoTime() - start) / 100_0000);
    }
}
