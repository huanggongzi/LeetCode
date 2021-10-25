package com.company.递归.递归到动态规划;

import java.time.Year;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/24/22:27
 * @Description:
 */
public class Demo01 {
    static int num = 0;

    public static void main(String[] args) {
        System.out.println(dfs1(4, 2, 4, 4));
    }

    public static int dfs1(int N, int start, int target, int k) {
        if (k == 0) {
            return start == target ? 1 : 0;
        }
        if (start == 1) {
            return dfs1(N, start + 1, target, k - 1);
        }
        if (start == N) {
            return dfs1(N, start - 1, target, k - 1);
        }
        return dfs1(N, start + 1, target, k - 1) + dfs1(N, start - 1, target, k - 1);
    }
}
