package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/28/23:34
 * @Description:
 */
public class _20220328交替位二进制数 {
    public boolean hasAlternatingBits(int n) {
        int num = n & 1;
        n = n >> 1;
        while (n != 0) {
            if ((n & 1) != num) {
                num = n & 1;
                n = n >> 1;
            } else {
                return false;
            }
        }
        return true;
    }
}
