package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/27/23:57
 * @Description:
 */
public class _20220327找出缺失的观测数据 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int i = 0; i < rolls.length; i++) {
            sum += rolls[i];
        }
        int num = n + rolls.length;
        int targetSum = num * mean - sum;
        if (targetSum < n || targetSum > 6 * n) {
            return new int[0];
        }
        int[] array = new int[n];
        int avl = targetSum / n;
        int p = targetSum % n;
        for (int i = 0; i < n; i++) {
            array[i] = avl;
        }
        if (p == 0) {
            return array;
        }
        int index = 0;
        while (p != 0) {
            array[index++]++;
            p--;
        }
        return array;
    }
}
