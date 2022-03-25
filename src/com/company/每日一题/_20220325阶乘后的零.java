package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/25/23:57
 * @Description:
 */
public class _20220325阶乘后的零 {
    public int trailingZeroes(int n) {
        int div = 5;
        int ans = 0;

        while (div <= n) {
            ans += n / div;
            div *= 5;
        }

        return ans;
    }
}
