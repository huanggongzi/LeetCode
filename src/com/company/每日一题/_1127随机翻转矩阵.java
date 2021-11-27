package com.company.每日一题;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/11/27/23:41
 * @Description:
 */
public class _1127随机翻转矩阵 {
    int m, n;
    Set<Integer> set = new HashSet<>();
    Random random = new Random(300);
    public _1127随机翻转矩阵(int _m, int _n) {
        m = _m; n = _n;
    }
    public int[] flip() {
        int a = random.nextInt(m * n), b = a;
        while (a >= 0 && set.contains(a)) a--;
        while (b < m * n && set.contains(b)) b++;
        int c = a >= 0 && !set.contains(a) ? a : b;
        set.add(c);
        return new int[]{c / n, c % n};
    }
    public void reset() {
        set.clear();
    }
}
