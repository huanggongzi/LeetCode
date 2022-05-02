package com.company.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/04/27/23:44
 * @Description:
 */
public class _20220427太平洋大西洋水流问题 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        List<List<Integer>> list = new ArrayList<>();

        // 到达大西洋的岛屿
        boolean[][] vis1 = new boolean[n][m];

        // 到达太平洋的岛屿
        boolean[][] vis2 = new boolean[n][m];

        for(int i = 0; i < n; i++){
            dfs(i, 0, heights, vis1);
        }

        for(int j = 0; j < m; j++){
            dfs(0, j, heights, vis1);
        }

        for(int j = 0; j < m; j++){
            dfs(heights.length - 1, j, heights, vis2);
        }

        for(int i = 0; i < n; i++){
            dfs(i, heights[0].length - 1, heights, vis2);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis1[i][j] && vis2[i][j]){
                    List<Integer> path = new ArrayList<>();
                    path.add(i);
                    path.add(j);
                    list.add(path);
                }
            }
        }
        return list;
    }


    public void dfs(int i, int j, int[][] heights, boolean[][] vis){
        if(i < 0 || j < 0 || i > heights.length || j > heights[0].length || vis[i][j]){
            return;
        }

        vis[i][j] = true;

        if(i + 1 < heights.length && heights[i][j] <= heights[i + 1][j]){
            dfs(i + 1, j, heights, vis);
        }

        if(i - 1 >= 0 && heights[i][j] <= heights[i - 1][j]){
            dfs(i - 1, j, heights, vis);
        }

        if(j + 1 < heights[0].length && heights[i][j] <= heights[i][j + 1]){
            dfs(i, j + 1, heights, vis);
        }

        if(j - 1 >= 0 && heights[i][j] <= heights[i][j - 1]){
            dfs(i, j - 1, heights, vis);
        }
    }
}
