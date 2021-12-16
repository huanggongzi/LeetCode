package com.company.递归.从递归到动态规划三;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/16/0:03
 * @Description:
 */
public class Demo01 {

    public static void main(String[] args) {

    }

        /**
         * 最长公共子序列：DFS暴力写法
         */
        public static int longestCommonSubsequence1(String s1, String s2) {
            if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
                return 0;
            }
            char[] str1 = s1.toCharArray();
            char[] str2 = s2.toCharArray();
            return process1(str1, str2, str1.length - 1, str2.length - 1);
        }

        // 从 str1[0,i] 与 str2[0,j]
        public static int process1(char[] str1, char[] str2, int i, int j) {
            if (i == 0 && j == 0) {
                return str1[i] == str2[j] ? 1 : 0;
            } else if (i == 0) {
                if (str2[j] == str1[i]) {
                    return 1;
                } else {
                    return process1(str1, str2, i, j - 1);
                }
            } else if (j == 0) {
                if (str1[i] == str2[j]) {
                    return 1;
                } else {
                    return process1(str1, str2, i - 1, j);
                }
            } else {
                // 样本对应模型
                int p1 = process1(str1, str2, i - 1, j);
                int p2 = process1(str1, str2, i, j - 1);
                int p3 = str1[i] == str2[j] ? 1 + process1(str1, str2, i - 1, j - 1) : 0;
                return Math.max(p1, Math.max(p2, p3));
            }
        }

    /**
     * 最长公共子序列：动态规划写法
     */
    public static int longestCommonSubsequence2(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        int n = s1.length();
        int m = s2.length();
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[][] dp = new int[n][m];

        dp[0][0] = str1[0] == str2[0] ? 1 : 0;

        for (int j = 1; j < m; j++) {
            dp[0][j] = str1[0] == str2[j] ? 1 : dp[0][j - 1];
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = str1[i] == str2[0] ? 1 : dp[i - 1][0];
        }


        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int p1 = dp[i - 1][j];
                int p2 = dp[i][j - 1];
                int p3 = str1[i] == str2[j] ? 1 + dp[i - 1][j - 1] : 0;
                dp[i][j] = Math.max(p1, Math.max(p2, p3));
            }
        }
        return dp[n - 1][m - 1];
    }
}
