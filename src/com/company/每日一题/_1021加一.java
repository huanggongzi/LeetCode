package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/21/22:57
 * @Description:
 */
public class _1021加一 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int num = 0;
        int max = 1;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] + num + max >= 10) {
                digits[i] = (digits[i] + num + max) % 10;
                max = 0;
                num = 1;
            } else {
                digits[i] = digits[i] + num + max;
                num = 0;
                break;
            }
        }
        if (num == 1) {
            int[] result = new int[len + 1];
            result[0] = 1;
            for (int i = 1; i <= len; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        }
        return digits;
    }
}
