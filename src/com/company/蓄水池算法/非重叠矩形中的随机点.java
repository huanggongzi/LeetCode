package com.company.蓄水池算法;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/01/17/23:17
 * @Description:
 */
public class 非重叠矩形中的随机点 {
    int[][] rects;
    Random random;

    public 非重叠矩形中的随机点(int[][] rects) {
        this.rects = rects;
        random = new Random();
    }

    public int[] pick() {
        // 挑选第一个矩阵
        int len = 0;
        int[] targetArr = new int[4];
        for (int[] arr : rects) {
            int k = getSum(arr);
            len = len + k;
            if (len == k) {
                copyArr(targetArr, arr);
            } else {
                if (getNum(len) <= k) {
                    copyArr(targetArr, arr);
                }
            }
        }
        int x1 = targetArr[0];
        int y1 = targetArr[1];
        int x2 = targetArr[2];
        int y2 = targetArr[3];
        return new int[]{x1 + random.nextInt(x2 - x1 + 1), y1 + random.nextInt(y2 - y1 + 1)};
    }

    public void copyArr(int[] target, int[] arr) {
        target[0] = arr[0];
        target[1] = arr[1];
        target[2] = arr[2];
        target[3] = arr[3];
    }


    public int getNum(int i) {
        return random.nextInt(i) + 1;
    }


    public int getSum(int[] arr) {
        return (arr[2] - arr[0] + 1) * (arr[3] - arr[1] + 1);
    }

}
