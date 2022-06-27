package com.company.滑动窗口;

import com.sun.xml.internal.bind.v2.runtime.NameBuilder;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/05/05/23:55
 * @Description:
 */
public class _239滑动窗口最大值 {
    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * 提交专用
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == nums || k < 1 || nums.length < k) {
            return null;
        }
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        LinkedList<Integer> qmax = new LinkedList<>();

        for (int R = 0; R < nums.length; R++) {
            while (!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[R]) {
                qmax.pollLast();
            }
            qmax.addLast(nums[R]);


            if (qmax.peekFirst() == R - k) {
                qmax.pollFirst();
            }

            if (R >= k - 1) {
                res[index++] = nums[qmax.peekFirst()];
            }
        }
        return res;
    }
}
