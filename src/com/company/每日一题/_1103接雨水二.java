package com.company.每日一题;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/11/03/22:49
 * @Description:
 */
public class _1103接雨水二 {
    public int trapRainWater(int[][] heightMap) {
        int r = heightMap.length;
        int c = heightMap[0].length;
        if (r < 3 || c < 3) {
            return 0;
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });

        boolean[][] vis = new boolean[r][c];
        // 外层的边放进去
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 || i == r - 1 || j == 0 || j == c - 1) {
                    priorityQueue.add(new int[]{i, j, heightMap[i][j]});
                    vis[i][j] = true;
                }
            }
        }
        int sum = 0;
        while (!priorityQueue.isEmpty()) {
            int[] curr = priorityQueue.poll();
            int[] dir = new int[]{-1, 0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dir[i];
                int ny = curr[1] + dir[i + 1];
                if (nx >= 0 && nx < r && ny >= 0 && ny < c && !vis[nx][ny]) {
                    int temp = curr[2] - heightMap[nx][ny];
                    if (temp > 0) {
                        sum = sum + temp;
                    }
                    priorityQueue.add(new int[]{nx, ny, curr[2]});
                    vis[nx][ny] = true;
                }
            }
        }
        return sum;
    }
}
