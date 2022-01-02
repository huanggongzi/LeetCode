package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/01/02/23:48
 * @Description:
 */
public class _20220102消除游戏 {
    public int lastRemaining(int n) {
        int num = n;
        int a0 = 1;
        int d = 1;
        // 默认为左边到右边
        boolean flag = true;

        while (num > 1) {
            // 奇数
            if (num % 2 == 1) {
                a0 = a0 + d;
            } else {
                if (flag) {
                    a0 = a0 + d;
                } else {
                    a0 = a0;
                }
            }
            num = num / 2;
            d = d * 2;
            flag = !flag;
        }
        return a0;
    }
}
