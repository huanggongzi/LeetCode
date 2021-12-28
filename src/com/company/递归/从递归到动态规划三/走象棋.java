package com.company.递归.从递归到动态规划三;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/26/23:07
 * @Description:
 */
public class 走象棋 {
    public static void main(String[] args) {
        int x = 7;
        int y = 7;
        int k = 10;
        System.out.println(getNum(x, y, k, 0, 0));
        System.out.println(dp(x, y, k));
    }

    public static int getNum(int x, int y, int k, int cow, int col) {
        // 处理越界
        if (cow < 0 || cow > 9 || col < 0 || col > 8 || k < 0) {
            return 0;
        }

        // 符合条件
        if (k == 0 && cow == x && col == y) {
            return 1;
        }

        // k > 0 还没有结束
        int p1 = getNum(x, y, k - 1, cow - 2, col + 1);
        int p2 = getNum(x, y, k - 1, cow - 2, col - 1);
        int p3 = getNum(x, y, k - 1, cow - 1, col - 2);
        int p4 = getNum(x, y, k - 1, cow - 1, col + 2);
        int p5 = getNum(x, y, k - 1, cow + 1, col - 2);
        int p6 = getNum(x, y, k - 1, cow + 1, col + 2);
        int p7 = getNum(x, y, k - 1, cow + 2, col - 1);
        int p8 = getNum(x, y, k - 1, cow + 2, col + 1);
        return p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8;
    }

    public static int dp(int x, int y, int rest) {
        int[][][] dp = new int[10][9][rest + 1];
        // 结束的标志
        dp[x][y][0] = 1;
        for (int k = 1; k <= rest; k++) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 9; j++) {
                    int ways = check(dp, k - 1, i - 2, j + 1);
                    ways += check(dp, k - 1, i - 2, j - 1);
                    ways += check(dp, k - 1, i - 1, j - 2);
                    ways += check(dp, k - 1, i - 1, j + 2);
                    ways += check(dp, k - 1, i + 1, j - 2);
                    ways += check(dp, k - 1, i + 1, j + 2);
                    ways += check(dp, k - 1, i + 2, j - 1);
                    ways += check(dp, k - 1, i + 2, j + 1);
                    dp[i][j][k] = ways;
                }
            }
        }
        return dp[0][0][rest];
    }

    public static int check(int[][][] dp, int rest, int x, int y) {
        // 处理越界
        if (x < 0 || x > 9 || y < 0 || y > 8 || rest < 0) {
            return 0;
        }
        return dp[x][y][rest];
    }

}
