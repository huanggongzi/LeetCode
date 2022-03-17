package com.company.每日一题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/17/22:47
 * @Description:
 */
public class _20220317词典中最长的单词 {
    public static void main(String[] args) {
        String[] strings = new String[]{"a", "b", "aa"};
        longestWord(strings);
    }

    public static String longestWord(String[] words) {
        Map<String, String> map = new HashMap<>();
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return -1;
                } else if (o1.length() < o2.length()) {
                    return 1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
            map.put(words[i], "1");
        }
        // 搞一个队列
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            boolean flag = true;
            for (int j = 0; j < str.length(); j++) {
                if (!map.containsKey(str.substring(0, j + 1))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return str;
            }
        }
        return "";
    }
}
