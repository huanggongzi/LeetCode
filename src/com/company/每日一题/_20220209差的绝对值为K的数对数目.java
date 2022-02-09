package com.company.每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/02/09/23:42
 * @Description:
 */
public class _20220209差的绝对值为K的数对数目 {
    public static void main(String[] args) {
        countKDifference(new int[]{1, 2, 2, 1}, 1);
    }

    public static int countKDifference(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);
        for (int i = 1; i < nums.length; i++) {
            Integer value1 = nums[i] + k;
            Integer value2 = nums[i] - k;
            count = count + map.getOrDefault(value1, 0) + map.getOrDefault(value2, 0);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return count;
    }
}
