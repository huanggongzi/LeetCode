package com.company.每日一题;

import java.util.Arrays;

public class _20220920划分为k个相等的子集 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }

        if (sum % k != 0) {
            return false;
        }

        int num = sum / k;

        Arrays.sort(nums);
        boolean[] booleans = new boolean[nums.length];
        return dfs(nums, nums.length - 1, num, 0, k, booleans);
    }


    /**
     * @param nums    数组
     * @param start   起始的下标
     * @param target  目标值
     * @param current 当前的值
     * @param k       还有多少个集合
     * @param booleans 数据是否被访问
     * @return
     */
    public boolean dfs(int[] nums, int start, int target, int current, int k, boolean[] booleans) {
        // 证明当前已经完全匹配
        if (k == 0) {
            return true;
        }
        // 如果当前的值已经累加到目标值，则进行下一步的累加
        if (current == target) {
            return dfs(nums, nums.length - 1, target, 0, k - 1, booleans);
        }
        // 从大到小
        for (int i = start; i >= 0; i--) {
            // 如果当前的数据已经被匹配过或者当前数据加上已经超过了目标值
            if (booleans[i] || current + nums[i] > target) {
                continue;
            }
            booleans[i] = true;
            if (dfs(nums, i - 1, target, current + nums[i], k, booleans)) {
                return true;
            }
            booleans[i] = false;
        }

        return false;
    }
}
