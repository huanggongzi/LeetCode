package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/11/06/22:12
 * @Description:
 */
public class _1106丢失的数字 {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i = 0; i <= nums.length; i++){
            sum = sum ^ i;
        }
        for(int i = 0; i < nums.length; i++){
            sum = sum ^ nums[i];
        }
        return sum;
    }
}
