package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/11/23/0:28
 * @Description:
 */
public class _1123亲密字符串 {
    public boolean buddyStrings(String s, String goal) {
        // 长度一样
        int len1 = s.length();
        int len2 = goal.length();
        if (len1 != len2) {
            return false;
        }

        // 字符出现的次数是否一样
        int[] arr1 = getArray(s);
        int[] arr2 = getArray(goal);

        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        // 有几个位置不一样的
        int num = 0;
        for (int i = 0; i < len1; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                num++;
            }
        }

        if (num == 2) {
            return true;
        }
        if (num == 1 || num > 2) {
            return false;
        }

        // 如果都相等的话，看一下有没有重复可以直接交换的
        for (int i = 0; i < 26; i++) {
            if (arr1[i] >= 2) {
                return true;
            }
        }
        return false;
    }

    public int[] getArray(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        return arr;
    }
}
