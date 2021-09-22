package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 你的名字
 * @Date: 2021/09/23/0:19
 * @Description:
 */
public class _9233的幂 {
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        int mod = 0;
        while (n != 1) {
            mod = n % 3;
            if (mod != 0) {
                return false;
            }
            n = n / 3;
        }

        return true;
    }
}
