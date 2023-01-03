package com.company.每日一题;

public class _20221128最大平均值和的分组 {
    public static void main(String[] args) {
        int[] nums = new int[]{9, 1, 2, 3, 9};
        System.out.println(largestSumOfAverages(nums, 3));
    }

    public static double largestSumOfAverages(int[] nums, int k) {
        // 前缀和
        int[] array = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            array[i + 1] = nums[i] + array[i];
        }
        double[][] vis = new double[array.length][k];

        return dfs(array, nums.length, 0, k, vis);
    }


    public static double dfs(int[] array, int len, int i, int k, double[][] vis) {
        if (i == len) {
            return 0;
        }

        // 说明只剩下一组了，直接返回数据即可
        if (k == 1) {
            return (array[len] - array[i]) * 1.0 / (len - i);
        }

        if (vis[i][k] != 0) {
            return vis[i][k];
        }

        double ans = 0;

        // 当前可以用几个
        for (int j = i; j < len; j++) {
            double t = (array[j + 1] - array[i]) * 1.0 / (j + 1 - i) + dfs(array, len, j + 1, k - 1, vis);
            ans = Math.max(ans, t);
        }

        vis[i][k] = ans;
        return ans;
    }
}
