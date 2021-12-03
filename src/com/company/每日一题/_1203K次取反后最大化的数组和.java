package com.company.每日一题;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/03/21:47
 * @Description:
 */
public class _1203K次取反后最大化的数组和 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        // 如果有负数 先改成正数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        if (k == 0) {
            return getSum(nums, true);
        }

        Arrays.sort(nums);

        if (k % 2 == 0) {
            return getSum(nums, true);
        }
        return getSum(nums, false);

    }

    public int getSum(int[] nums, boolean flag) {
        int sum = 0;
        if (flag) {
            sum = sum + nums[0];
        } else {
            sum = sum - nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
