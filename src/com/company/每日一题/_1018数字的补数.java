package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/18/23:17
 * @Description:
 */
public class _1018数字的补数 {
    public int findComplement(int num) {
        int sum = 0;
        int value = 1;
        while(num != 0){
            if((num & 1) == 0){
                sum = sum + value;
            }
            num = num >> 1;
            value = value * 2;
        }
        return sum;
    }
}
