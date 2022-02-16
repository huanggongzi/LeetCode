package com.company.每日一题;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/02/16/23:46
 * @Description:
 */
public class _20220216重构一棵树的方案数 {
    int N = 510;
    int[] cnts = new int[N], fa = new int[N];
    boolean[][] g = new boolean[N][N];
    public int checkWays(int[][] pairs) {
        int m = pairs.length;
        Set<Integer> set = new HashSet<>();
        for (int[] p : pairs) {
            int a = p[0], b = p[1];
            g[a][b] = g[b][a] = true;
            cnts[a]++; cnts[b]++;
            set.add(a); set.add(b);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list, (a, b)->cnts[b]-cnts[a]);
        int n = list.size(), root = list.get(0);
        if (m < n - 1) return 0; // 森林
        fa[root] = -1;
        for (int i = 1; i < n; i++) {
            int a = list.get(i);
            boolean ok = false;
            for (int j = i - 1; j >= 0 && !ok; j--) {
                int b = list.get(j);
                if (g[a][b]) {
                    fa[a] = b;
                    ok = true;
                }
            }
            if (!ok) return 0;
        }
        int c = 0, ans = 1;
        for (int i : set) {
            int j = i;
            while (fa[j] != -1) {
                if (!g[i][fa[j]]) return 0;
                if (cnts[i] == cnts[fa[j]]) ans = 2;
                c++;
                j = fa[j];
            }
        }
        return c < m ? 0 : ans;
    }
}
