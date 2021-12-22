package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/22/23:50
 * @Description:
 */
public class _1222重复叠加字符串匹配 {
    public int repeatedStringMatch(String a, String b) {
        if (b.length() == 0) {
            return 0;
        }
        // 先排除掉两个中有不存在的字符
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < a.length(); i++) {
            arr1[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            arr2[b.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr2[i] > 0 && arr1[i] <= 0) {
                return -1;
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(0)) {
                min = Math.min(min, getNum(a, b, i));
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int getNum(String a, String b, int index) {
        int lenA = a.length();
        int num = 1;
        for (int i = 0; i < b.length(); i++) {
            if (a.charAt(index) == b.charAt(i) && i < b.length() - 1) {
                index++;
                if (index == lenA) {
                    index = 0;
                    num++;
                }
            } else if (a.charAt(index) == b.charAt(i) && i == b.length() - 1) {
                return num;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        return num;
    }
}
