package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/02/12/23:20
 * @Description:
 */
public class _20220212飞地的数量 {
    boolean[][] fangwen;

    public int numEnclaves(int[][] grid) {
        fangwen = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) {
                fangwen[i][0] = true;
                dfs(grid, i, 0);
            }
            if (grid[i][grid[0].length - 1] == 1) {
                fangwen[i][grid[0].length - 1] = true;
                dfs(grid, i, grid[0].length - 1);
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1) {
                fangwen[0][i] = true;
                dfs(grid, 0, i);
            }
            if (grid[grid.length - 1][i] == 1) {
                fangwen[grid.length - 1][i] = true;
                dfs(grid, grid.length - 1, i);
            }
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && !fangwen[i][j]){
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }

        if (x + 1 < grid.length) {
            if (grid[x + 1][y] == 1 && !fangwen[x + 1][y]) {
                fangwen[x + 1][y] = true;
                dfs(grid, x + 1, y);
            }
        }
        if (x - 1 >= 0) {
            if (grid[x - 1][y] == 1 && !fangwen[x - 1][y]) {
                fangwen[x - 1][y] = true;
                dfs(grid, x - 1, y);
            }
        }
        if (y + 1 < grid[0].length) {
            if (grid[x][y + 1] == 1 && !fangwen[x][y + 1]) {
                fangwen[x][y + 1] = true;
                dfs(grid, x, y + 1);
            }
        }
        if (y - 1 >= 0) {
            if (grid[x][y - 1] == 1 && !fangwen[x][y - 1]) {
                fangwen[x][y - 1] = true;
                dfs(grid, x, y - 1);
            }
        }
    }
}
