package com.company.每日一题;

import com.company.图.Edge;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/20/18:19
 * @Description:
 */
public class _20220320网络空闲的时刻 {
    public static void main(String[] args) {
        Test test = new Test();
        int[][] edges = new int[][]{{3, 8}, {4, 13}, {0, 7}, {0, 4}, {1, 8}, {14, 1}, {7, 2}, {13, 10}, {9, 11}, {12, 14}, {0, 6}, {2, 12}, {11, 5}, {6, 9}, {10, 3}};
        int[] patience = new int[]{0, 3, 2, 1, 5, 1, 5, 5, 3, 1, 2, 2, 2, 2, 1};
        int[] array = new int[patience.length];
        int[] array1 = new int[patience.length];
        networkBecomesIdle(edges, patience, array);
        System.out.println("");
    }

    public static int networkBecomesIdle(int[][] edges, int[] patience, int[] a) {
        // 一个数据服务器距离总服务器的最短路径是多少
        Map<Integer, List<Integer>> map = new HashMap<>();
        init(edges, map);

        Map<Integer, Integer> shortestRoute = new HashMap<>();
        shortestRoute.put(0, 0);
        Queue<Integer> queue = new LinkedList<>();
        int num = 1;
        queue.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer value = queue.poll();
                List<Integer> path = map.get(value);
                for (Integer x : path) {
                    if (!shortestRoute.containsKey(x)) {
                        shortestRoute.put(x, num);
                        queue.add(x);
                    }
                }
            }
            num++;
        }

        int max = 0;
        for (int i = 0; i < patience.length; i++) {
            a[i] = shortestRoute.get(i);
        }
        for (Map.Entry<Integer, Integer> entry : shortestRoute.entrySet()) {
            int d = entry.getValue() * 2;
            int p = patience[entry.getKey()];

            if (d <= p) {
                max = Math.max(max, d);
            } else {
                // System.out.println(key + " " + value + " " + patienceValue);
                max = Math.max(max, (d - 1) / p * p + d);
                if (max == 70) {
                    System.out.println("");
                }
            }
        }

        return max + 1;
    }


    public static void init(int[][] edges, Map<Integer, List<Integer>> map) {
        for (int i = 0; i < edges.length; i++) {
            int edge1 = edges[i][0];
            int edge2 = edges[i][1];
            if (map.containsKey(edge1)) {
                List<Integer> path = map.get(edge1);
                path.add(edge2);
                map.put(edge1, path);
            } else {
                List<Integer> path = new ArrayList<>();
                path.add(edge2);
                map.put(edge1, path);
            }
            if (map.containsKey(edge2)) {
                List<Integer> path = map.get(edge2);
                path.add(edge1);
                map.put(edge2, path);
            } else {
                List<Integer> path = new ArrayList<>();
                path.add(edge1);
                map.put(edge2, path);
            }
        }
    }
}
