package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/01/15/23:25
 * @Description:
 */
public class _20220115计算力扣银行的钱 {
    public int totalMoney(int n) {
        int sum = 0;
        int numMon = 1;
        int num = n / 7;
        for (int i = 0; i < num; i++) {
            for (int j = numMon; j < numMon + 7; j++) {
                sum = sum + j;
            }
            numMon = numMon + 1;
        }
        for (int j = numMon; j < numMon + n % 7; j++) {
            sum = sum + j;
        }
        return sum;
    }
}
