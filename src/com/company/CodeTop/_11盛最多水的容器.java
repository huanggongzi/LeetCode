package com.company.CodeTop;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/05/23:56
 * @Description:
 */
public class _11盛最多水的容器 {
    public int maxArea(int[] height) {
        // 这个可以贪心
        // 我们可以看到，什么情况下我们的水池里面的水是最多的
        // 我们看一下水池的计算：总长度 * min(left, right)
        // 如果我们默认要减少总长度的话，我们必须要增加 left 和 right 的值
        // 所以，滑动窗口的前提就是，谁最小谁往后滑
        int max = -1;
        int left = 0;
        int right = height.length - 1;
        while (left <= right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
