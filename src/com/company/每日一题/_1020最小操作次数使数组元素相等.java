package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/20/21:47
 * @Description:
 */
public class _1020最小操作次数使数组元素相等 {
    public int minMoves(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int min = nums[0];
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] - min;
        }
        return sum;
    }
}
