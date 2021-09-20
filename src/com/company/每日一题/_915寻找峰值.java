package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 你的名字
 * @Date: 2021/09/15/0:35
 * @Description:
 */
public class _915寻找峰值 {
    public int findPeakElement(int[] nums) {
        // 找到第一个的转折点
        // 我们不断二分递增的另一部分，最差情况会一直递增到最后一位数，但是我们知道nums[n]为负无穷，所以，符合峰值的定义
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (mid == 0 || nums[mid] > nums[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left - 1;
    }
}
