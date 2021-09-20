package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 你的名字
 * @Date: 2021/09/19/23:08
 * @Description:
 */
public class _919只有两个键的键盘 {
    /**
     * DFS做法
     */
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        // len：当前的长度
        // step：执行操作的次数
        // sum：当前粘贴板上的数字
        // n：总次数
        return dfs(1, 1, 1, n);
    }

    public int dfs(int len, int step, int sum, int n) {
        if (len == n) {
            return step;
        }
        if (len > n) {
            return Integer.MAX_VALUE;
        }
        // 操作分为两种
        // 1. 粘贴复制
        // 2. 粘贴
        return Math.min(dfs(len + sum, step + 2, sum + len, n), dfs(len + sum, step + 1, sum, n));

    }


}
