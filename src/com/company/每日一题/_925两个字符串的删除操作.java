package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 你的名字
 * @Date: 2021/09/25/22:11
 * @Description:
 */
public class _925两个字符串的删除操作 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len2 + 1][len1 + 1];
        for (int i = 1; i <= len2; i++) {
            for (int j = 1; j <= len1; j++) {
                if (word2.charAt(i - 1) == word1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }


        int n = dp[len2][len1];
        return len1 - n + len2 - n;
    }
}
