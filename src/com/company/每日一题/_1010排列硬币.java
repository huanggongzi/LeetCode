package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/10/16:46
 * @Description:
 */
public class _1010排列硬币 {
    /**
     * 暴力做法
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        long sum = 0;
        long num = 1;
        while(sum < n){
            sum = sum + num;
            // System.out.println(sum + "+" + num);
            if(sum == n){
                return (int)num;
            }
            if(sum > n){
                return (int)(num - 1);
            }
            num++;
        }
        return (int)num;
    }

    /**
     * 二分法
     * @param n
     * @return
     */
    public int arrangeCoinsErFen(int n) {
        // 1 + 2 + 3 + 4 + ..... + n = n (n + 1) / 2

        long left = 1;
        long right = n;

        while(left <= right){
            long mid = left + (right - left) / 2;
            long total = (mid * (mid + 1) ) / 2;

            if(total == n){
                return (int)mid;
            }else if(total < n){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return (int)right;
    }
}
