package com.company.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/11/17/0:20
 * @Description:
 */
public class _1117最大单词长度乘积 {
    public int maxProduct(String[] words) {
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            list.add(f(words[i]));
        }

        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
            int[] array = list.get(i);
            for (int j = i + 1; j < words.length; j++) {
                int[] curr = list.get(j);
                if (isSame(array, curr)) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }

        return max;
    }


    public int[] f(String str) {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        return arr;
    }

    public boolean isSame(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] > 0 && arr2[i] > 0) {
                return false;
            }
        }

        return true;
    }
}
