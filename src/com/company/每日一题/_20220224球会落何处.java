package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/02/24/23:54
 * @Description:
 */
public class _20220224球会落何处 {
    public int[] findBall(int[][] grid) {
        int len = grid[0].length;
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = dfs(grid, 0, i);
        }
        return answer;
    }


    public int dfs(int[][] grid, int i, int j) {
        if (i == grid.length) {
            return j;
        }

        // 什么情况下会卡死
        if (j == 0 && grid[i][j] == -1) {
            return -1;
        }

        if (j == grid[0].length - 1 && grid[i][j] == 1) {
            return -1;
        }

        if (grid[i][j] == 1 && grid[i][j + 1] == -1) {
            return -1;
        }

        if (grid[i][j] == -1 && grid[i][j - 1] == 1) {
            return -1;
        }
        if (grid[i][j] == 1) {
            return dfs(grid, i + 1, j + 1);
        } else {
            return dfs(grid, i + 1, j - 1);
        }

    }
}
