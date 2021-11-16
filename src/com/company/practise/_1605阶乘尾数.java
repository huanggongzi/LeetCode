package com.company.practise;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/11/16/22:10
 * @Description:
 */
public class _1605阶乘尾数 {
    public int trailingZeroes(int n) {
        int count = 0;

        while (n > 0) {
            n = n / 5;
            count = count + n;
        }

        return count;
    }
}
