package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/02/17/23:57
 * @Description:
 */
public class _20220217骑士在棋盘上的概率 {

    private static final int[][] DIRS = {{1, 2}, {2, 1}, {-1, 2}, {2, -1}, {1, -2}, {-2, 1}, {-1, -2}, {-2, -1}};

    public double knightProbability(int n, int k, int row, int column) {
        // 记忆化搜索
        double[][][] memo = new double[n][n][k + 1];
        return dfs(n, k, row, column, memo);
    }

    public double dfs(int n, int k, int i, int j, double[][][] memo) {
        // 走出边界了，这条路不通，概率为0
        if (i < 0 || j < 0 || i >= n || j >= n) {
            return 0;
        }
        // k 步走完了还没超出边界，这一步的概率是1，还需要乘上前面的 k 个 1/8
        if (k == 0) {
            return 1;
        }

        // 缓存中存在，直接返回
        if (memo[i][j][k] != 0) {
            return memo[i][j][k];
        }

        // 每一个方向的概率都是 1/8
        double ans = 0;
        for (int[] dir : DIRS) {
            ans += dfs(n, k - 1, i + dir[0], j + dir[1], memo) / 8.0;
        }

        memo[i][j][k] = ans;

        return ans;
    }
}
