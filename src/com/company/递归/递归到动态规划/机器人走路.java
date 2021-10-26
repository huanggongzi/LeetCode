package com.company.递归.递归到动态规划;

import java.time.Year;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/24/22:27
 * @Description:
 */
public class 机器人走路 {

    public static void main(String[] args) {
        System.out.println(dfs(5, 2, 4, 6));
        System.out.println(way(5, 2, 4, 6));
        System.out.println(way2(5, 2, 4, 6));
    }

    public static int dfs(int N, int start, int target, int k) {
        if (k == 0) {
            return start == target ? 1 : 0;
        }
        if (start == 1) {
            return dfs(N, start + 1, target, k - 1);
        }
        if (start == N) {
            return dfs(N, start - 1, target, k - 1);
        }
        return dfs(N, start + 1, target, k - 1) + dfs(N, start - 1, target, k - 1);
    }

    /**
     * 记忆化搜索
     */
    public static int way(int N, int start, int target, int k) {
        int[][] dp = new int[N + 1][k + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = -1;
            }
        }
        return way1(N, start, target, k, dp);
    }

    public static int way1(int N, int start, int target, int k, int[][] dp) {
        // 代表被缓存过
        if (dp[start][k] != -1) {
            return dp[start][k];
        }
        int ans = 0;
        if (k == 0) {
            ans = start == target ? 1 : 0;
        } else if (start == 1) {
            ans = dfs(N, start + 1, target, k - 1);
        } else if (start == N) {
            ans = dfs(N, start - 1, target, k - 1);
        } else {
            ans = dfs(N, start + 1, target, k - 1) + dfs(N, start - 1, target, k - 1);
        }
        dp[start][k] = ans;
        return ans;
    }

    /**
     * 动态规划
     */
    public static int way2(int N, int start, int target, int k) {
        int[][] dp = new int[N + 1][k + 1];
        dp[target][0] = 1;
        for (int i = 1; i <= k; i++) {
            dp[1][i] = dp[2][i - 1];
            for (int j = 2; j < N; j++) {
                dp[j][i] = dp[j + 1][i - 1] + dp[j - 1][i - 1];
            }
            dp[N][i] = dp[N - 1][i - 1];
        }
        return dp[start][k];
    }


}
