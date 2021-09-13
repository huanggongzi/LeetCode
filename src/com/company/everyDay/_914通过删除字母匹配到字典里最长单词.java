package com.company.everyDay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 你的名字
 * @Date: 2021/09/14/0:23
 * @Description:
 */
public class _914通过删除字母匹配到字典里最长单词 {
    public static void main(String[] args) {
        String[] str = new String[]{"ale", "apple", "monkey", "plea"};
    }

    // 直接调用版本
    public String findLongestWord(String s, List<String> dictionary) {
        List<String> list = new ArrayList<>();
        List<String> retultList = new ArrayList<>();
        int maxSize = 0;
        for (int i = 0; i < dictionary.size(); i++) {
            if (getBoolean(s, dictionary.get(i))) {
                maxSize = Math.max(maxSize, dictionary.get(i).length());
                list.add(dictionary.get(i));
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == maxSize) {
                retultList.add(list.get(i));
            }
        }

        Collections.sort(retultList);
        if (retultList.size() == 0) {
            return "";
        } else {
            return retultList.get(0);
        }
    }
    // 重写Sort版本
    public void findLongestWordTwo(String s, List<String> dictionary) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < dictionary.size(); i++) {
//            if (getBoolean(s, dictionary.get(i))) {
            list.add(dictionary.get(i));
//            }
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return -1;
                } else if (o1.length() < o2.length()) {
                    return 1;
                } else if (o1.length() == o2.length()) {
                    char[] chars1 = o1.toCharArray();
                    char[] chars2 = o2.toCharArray();
                    int i = 0;
                    while (i < chars1.length && i < chars2.length) {
                        if (chars1[i] > chars2[i]) {
                            return 1;
                        } else if (chars1[i] < chars2[i]) {
                            return -1;
                        } else {
                            i++;
                        }
                    }
                    if (i == chars1.length) {  //o1到头
                        return -1;
                    }
                    if (i == chars2.length) { //o2到头
                        return 1;
                    }
                }
                return 0;
            }
        });
        for (String str : list) {
            System.out.println(str);
        }
    }

    public boolean getBoolean(String s1, String s2) {
        // 删除s1中的某些字符是否能得到s2
        // 代表s2的下标
        int index = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (index < s2.length() && s1.charAt(i) == s2.charAt(index)) {
                index++;
            }
        }

        if (index == s2.length()) {
            return true;
        }

        return false;
    }
}
