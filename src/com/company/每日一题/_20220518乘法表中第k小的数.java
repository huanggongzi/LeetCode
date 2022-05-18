package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/05/18/22:31
 * @Description:
 */
public class _20220518乘法表中第k小的数 {
    public static void main(String[] args) {
        get(45, 12, 312);
        findKthNumber(3, 3, 5);
    }

    public static int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        int num = -1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (get(m, n, mid) >= k) {
                num = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return num;
    }

    public static int get(int m, int n, int num) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count = count + Math.min(num / i, n);
        }
        return count;
    }
}
