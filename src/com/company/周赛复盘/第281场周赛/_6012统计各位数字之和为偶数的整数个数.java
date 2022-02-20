package com.company.周赛复盘.第281场周赛;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/02/20/18:15
 * @Description:
 */
public class _6012统计各位数字之和为偶数的整数个数 {
    public int countEven(int num) {
        int sum = 0;
        for(int i = 1; i <= num; i++){
            if(f(i)){
                sum++;
            }
        }
        return sum;
    }

    public boolean f(int n){
        int sum = 0;
        while(n != 0){
            sum = sum + n % 10;
            n = n / 10;
        }
        return sum % 2 == 0 ? true : false;
    }
}
