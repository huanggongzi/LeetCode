package com.company.并查集;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 你的名字
 * @Date: 2021/09/20/23:48
 * @Description:
 */
public class UnionFind {
    /**
     * 并查集
     * 对于并查集来说，操作一共有两种方式：find()、union()
     * public boolean find(int a, int b):查询a和b是否是同一组
     * public void union(int a, int b):将a组的人员和b组的人员合并
     */
    public int findCircleNum(int[][] isConnected) {
        int N = isConnected.length;
        UnionAndFind unionFind = new UnionAndFind(N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.sets;
    }
}

class UnionAndFind {
    // 当前自己的大哥是谁
    private int[] parent;
    // 当前自己的队伍有多少人(只有大哥有)
    private int[] size;
    // 辅助数组
    private int[] help;
    // 江湖还有几个派系
    int sets;

    // 初始化
    // 每个人的大哥都是自己
    public UnionAndFind(int N) {
        parent = new int[N];
        size = new int[N];
        help = new int[N];
        sets = N;
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int i) {
        int h = 0;
        while (i != parent[i]) {
            help[h++] = i;
            i = parent[i];
        }
        for (h--; h >= 0; h--) {
            parent[help[h]] = i;
        }
        return i;
    }

    // 看一下你的最终BOSS是谁
    public int findTwo(int i) {
        while (i != parent[i]) {
            i = parent[i];
        }
        return i;
    }

    public boolean isSameSet(int a, int b) {
        return find(a) == find(b);
    }

    public void union(int a, int b) {
        int A = find(a);
        int B = find(b);
        if (A != B) {
            if (size[A] >= size[B]) {
                size[A] += size[B];
                parent[B] = A;
            } else {
                size[B] += size[A];
                parent[A] = B;
            }
            sets--;
        }
    }
}
