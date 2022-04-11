package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/04/11/23:35
 * @Description:
 */
public class _20220411统计各位数字都不同的数字个数 {
    public int countNumbersWithUniqueDigits(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            boolean[] vis = new boolean[10];
            sum = sum + dfs(0, i, vis);
        }
        return sum;
    }

    /**
     * index:当前的层数
     * n:总层数
     * vis:当前使用的标记的数字
     */
    public int dfs(int index, int n, boolean[] vis) {
        if (index == n) {
            return 1;
        }

        int sum = 0;

        for (int i = 0; i <= 9; i++) {
            if (i != 0) {
                if (!vis[i]) {
                    vis[i] = true;
                    sum = sum + dfs(index + 1, n, vis);
                    vis[i] = false;
                }
            } else {
                if (index != 0) {
                    if (!vis[i]) {
                        vis[i] = true;
                        sum = sum + dfs(index + 1, n, vis);
                        vis[i] = false;
                    }
                }
            }
        }

        return sum;
    }
}
