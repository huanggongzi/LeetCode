package com.company.递归.递归到动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/25/23:08
 * @Description:
 */
public class 发牌取牌 {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7};
    }

    /**
     * 先手函数
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int f(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        int num1 = arr[left] + g(arr, left + 1, right);
        int num2 = arr[right] + g(arr, left, right - 1);
        return Math.max(num1, num2);
    }

    public static int g(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int num1 = f(arr, left, right - 1);
        int num2 = f(arr, left + 1, right);
        return Math.min(num1, num2);
    }

    /**
     * 缓存级函数
     */
    public static int way1(int[] arr, int left, int right, int[][] fdp, int[][] gdp) {
        if (fdp[left][right] != -1) {
            return fdp[left][right];
        }

        int ans = 0;
        if (left == right) {
            ans = arr[left];
        }
        int num1 = arr[left] + way2(arr, left + 1, right, fdp, gdp);
        int num2 = arr[right] + way2(arr, left, right - 1, fdp, gdp);
        ans = Math.max(num1, num2);
        fdp[left][right] = ans;
        return ans;
    }

    public static int way2(int[] arr, int left, int right, int[][] fdp, int[][] gdp) {
        if (gdp[left][right] != -1) {
            return gdp[left][right];
        }
        int ans = 0;
        if (left == right) {
            ans = 0;
        }
        int num1 = way1(arr, left + 1, right, fdp, gdp);
        int num2 = way1(arr, left, right - 1, fdp, gdp);
        ans = Math.min(num1, num2);
        gdp[left][right] = ans;
        return ans;
    }

    /**
     * 动态规划
     *
     * @param arr
     * @param left
     * @param right
     * @param fdp
     * @param gdp
     * @return
     */
    public static int way3(int[] arr, int left, int right, int[][] fdp, int[][] gdp) {
        int N = arr.length;
        int len = arr.length - 1;
        for (int i = 0; i < len; i++) {
            int heng = N - i;
            int zong = i + 1;
            for (int j = 1; j < heng; j++) {
                for (int k = zong; k < N; k++) {
                    fdp[j][k] = Math.max(arr[j] + gdp[i + 1][j], arr[k] + gdp[j][k - 1]);
                    gdp[j][k] = Math.min(fdp[j + 1][k], fdp[j][k - 1]);
                }
            }
        }
        return Math.max(fdp[0][arr.length], gdp[0][arr.length]);
    }
}
