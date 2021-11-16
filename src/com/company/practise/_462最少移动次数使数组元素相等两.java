package com.company.practise;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/11/16/21:56
 * @Description:
 */
public class _462最少移动次数使数组元素相等两 {
    public int minMoves2(int[] nums) {
        // 1. 排序
        Arrays.sort(nums);

        // 求出中点
        int len = nums.length;
        int value = nums[len / 2];

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = sum + Math.abs(nums[i] - value);
        }


        return sum;
    }
}
