package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/02/06/23:46
 * @Description:
 */
public class _20220206唯一元素的和 {
    public int sumOfUnique(int[] nums) {
        int[] num = new int[101];
        for (int i = 0; i < nums.length; i++) {
            num[nums[i]]++;
        }
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (num[i] == 1) {
                sum = sum + i;
            }
        }
        return sum;
    }
}
