package com.company.递归.背包问题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/27/23:01
 * @Description:
 */
public class 简单背包 {
    public static void main(String[] args) {
        int[] w = new int[]{3, 2, 4, 7};
        int[] v = new int[]{5, 6, 3, 19};
        int bag = 11;
        System.out.println(maxValue(w, v, bag, 0));
    }

    /**
     * @param w   重量
     * @param v   价值
     * @param bag 背包的容量
     * @return
     */
    public static int maxValue(int[] w, int[] v, int bag, int index) {
        int ans = 0;
        if (index == w.length) {
            return 0;
        }
        if (w[index] <= bag) {
            // 如果我要当前的
            ans = maxValue(w, v, bag - w[index], index + 1) + v[index];
        }
        // 如果我不要当前的
        ans = Math.max(ans, maxValue(w, v, bag, index + 1));
        return ans;
    }
    /**
     * 动态规划
     */


}
