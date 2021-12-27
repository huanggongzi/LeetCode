package com.company.递归.从递归到动态规划三;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/17/0:18
 * @Description:
 */
public class 最长回文子串 {
    // 最长回文子串
    public static void main(String[] args) {
        String str = "bbbab";
        System.out.println(lpsl(str));
    }

    public static int lpsl(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        return f(str, 0, str.length - 1);
    }

    public static int f(char[] str, int L, int R) {
        if (L > R) {
            return 0;
        }
        if (L == R) {
            return 1;
        }
        if (str[L] == str[R]) {
            return 2 + f(str, L + 1, R - 1);
        } else {
            int p1 = f(str, L + 1, R);
            int p2 = f(str, L, R - 1);
            return Math.max(p1, p2);
        }
    }

    public static int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int len = s.length();
        int L = len;
        int R = len;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int l = L - 2; l >= 0; l--) {
            for (int r = l + 1; r < R; r++) {
                if (l < r) {
                    if (str[l] == str[r]) {
                        dp[l][r] = 2 + dp[l + 1][r - 1];
                    } else {
                        dp[l][r] = Math.max(dp[l + 1][r], dp[l][r - 1]);
                    }
                }
            }
        }
        return dp[0][len - 1];
    }

}
