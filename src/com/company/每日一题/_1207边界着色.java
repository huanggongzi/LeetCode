package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/07/23:46
 * @Description:
 */
public class _1207边界着色 {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int value = grid[row][col];
        dfs(grid, row, col, grid[row][col]);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == -1 && isExist(grid, i, j)) {
                    vis[i][j] = true;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (vis[i][j]) {
                    grid[i][j] = color;
                } else if (grid[i][j] == -1) {
                    grid[i][j] = value;
                }
            }
        }

        return grid;

    }


    // 先找到连通分量，能够连通的直接设置为-1
    public void dfs(int[][] grid, int row, int col, int value) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == -1) {
            return;
        }

        if (grid[row][col] == value) {
            grid[row][col] = -1;
            // 向四周散播
            dfs(grid, row - 1, col, value);
            dfs(grid, row + 1, col, value);
            dfs(grid, row, col + 1, value);
            dfs(grid, row, col - 1, value);
        }
    }


    // 怎么算符合的染色：边界、周围存在和他自己颜色不一样的值
    public boolean isExist(int[][] grid, int row, int col) {
        // 看是不是边界
        if (row == 0 || row == grid.length - 1 || col == 0 || col == grid[0].length - 1) {
            return true;
        }

        // 不是边界,看周围是否存在-1的情况
        if (grid[row - 1][col] == -1 && grid[row + 1][col] == -1 && grid[row][col - 1] == -1 && grid[row][col + 1] == -1) {
            return false;
        }

        return true;
    }
}
