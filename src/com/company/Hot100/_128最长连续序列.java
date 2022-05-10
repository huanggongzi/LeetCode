package com.company.Hot100;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/05/10/23:53
 * @Description:
 */
public class _128最长连续序列 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int maxCount = 0;

        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int strat = 1;
                int value = num + 1;
                while (set.remove(value)) {
                    value++;
                    strat++;
                }
                maxCount = Math.max(maxCount, strat);
            }
        }

        return maxCount;
    }
}
