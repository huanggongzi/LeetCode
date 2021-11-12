package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/11/12/23:40
 * @Description:
 */
public class _1112猜数字大小 {
    public int getMoneyAmount(int n) {
        int[][] f = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                int minCost = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = k + Math.max(f[i][k - 1], f[k + 1][j]);
                    minCost = Math.min(minCost, cost);
                }
                f[i][j] = minCost;
            }
        }
        return f[1][n];
    }
}
