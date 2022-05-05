package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/05/05/23:30
 * @Description:
 */
public class _20220505乘积小于K的子数组 {
    /**
     * 如果一个最长子串的乘积小于K，那么 count = 子串的任意子串都小于 K
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int sum = 1;
        int len = nums.length;
        int count = 0;
        while (right < len) {
            sum = sum * nums[right];

            while (left <= right && sum >= k) {
                sum = sum / nums[left];
                left++;
            }

            right++;
            count = count + right - left;
        }
        return count;
    }
}
