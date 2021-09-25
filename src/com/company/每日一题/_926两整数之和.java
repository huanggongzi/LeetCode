package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 你的名字
 * @Date: 2021/09/26/0:21
 * @Description:
 */
public class _926两整数之和 {
    public static void main(String[] args) {
        int a = 6;
        int b = 7;
    }

    public int getSum(int a, int b) {
        while (b != 0) {
            int num = (a & b) <<   1;
            a = a ^ b;
            b = num;
        }
        return a;
    }
}
