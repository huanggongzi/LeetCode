package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/01/17/23:19
 * @Description:
 */
public class _20220117统计元音字母序列的数目 {
    public int countVowelPermutation(int n) {
        long mod = 1000000007;
        //
        long[][] dp = new long[n][5];
        for (int i = 0; i < 5; i++) {
            dp[n - 1][i] = 1;
        }
        // 0 1 2 3 4
        // a e i o u
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < 5; j++) {
                if (j == 0) {
                    dp[i][j] = (dp[i + 1][1]) % mod;
                } else if (j == 1) {
                    dp[i][j] = (dp[i + 1][0] + dp[i + 1][2]) % mod;
                } else if (j == 2) {
                    dp[i][j] = (dp[i + 1][0] + dp[i + 1][1] + dp[i + 1][3] + dp[i + 1][4]) % mod;
                } else if (j == 3) {
                    dp[i][j] = (dp[i + 1][2] + dp[i + 1][4]) % mod;
                } else {
                    dp[i][j] = (dp[i + 1][0]) % mod;
                }
            }
        }

        long sum = 0;
        for (int i = 0; i < 5; i++) {
            sum = (sum + dp[0][i]) % mod;
        }

        return (int) sum;
    }

    public int dfs(int n, int index, char ch) {
        if (index == n) {
            return 1;
        }

        int sum = 0;

        if (ch == 'a') {
            sum = dfs(n, index + 1, 'e');
        } else if (ch == 'e') {
            sum = dfs(n, index + 1, 'a') + dfs(n, index + 1, 'i');
        } else if (ch == 'i') {
            sum = dfs(n, index + 1, 'a') + dfs(n, index + 1, 'e') + dfs(n, index + 1, 'o') + dfs(n, index + 1, 'u');
        } else if (ch == 'o') {
            sum = dfs(n, index + 1, 'i') + dfs(n, index + 1, 'u');
        } else if (ch == 'u') {
            sum = dfs(n, index + 1, 'a');
        }

        return sum;

    }
}
