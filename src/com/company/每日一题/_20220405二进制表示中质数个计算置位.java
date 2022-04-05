package com.company.每日一题;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/04/05/22:32
 * @Description:
 */
public class _20220405二进制表示中质数个计算置位 {
    public static void main(String[] args) {
        System.out.println(2 >> 1);
    }

    static Set<Integer> set = new HashSet<>();

    static {
        getSet();
    }

    public int countPrimeSetBits(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            int count = 0;
            int x = i;
            while (x != 0) {
                if ((x & 1) == 1) {
                    count++;
                }
                x = x >> 1;
            }
            if (set.contains(count)) {
                // System.out.println(count);
                sum++;
            }
        }
        return sum;
    }

    public static void getSet() {
        for (int i = 2; i <= 32; i++) {
            if (f(i)) {
                set.add(i);
            }
        }
    }

    public static boolean f(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
