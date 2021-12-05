package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/06/0:39
 * @Description:
 */
public class _1205超级次方 {
    int base = 1337;

    public int superPow(int a, int[] b) {
        return superPow(a, b, b.length - 1);
    }

    private int superPow(int a, int[] b, int index) {
        if (index < 0) {
            return 1;
        }

        int part1 = myPow(a, b[index]);
        int part2 = myPow(superPow(a, b, index - 1), 10);

        return (part1 * part2) % base;
    }

    public int myPow(int a, int b) {
        if (b == 0) {
            return 1;
        }

        if (b % 2 == 0) {
            return myPow(((a % base) * (a % base)) % base, b / 2);
        } else {
            return (myPow(a, b - 1) * (a % base)) % base;
        }
    }
}
