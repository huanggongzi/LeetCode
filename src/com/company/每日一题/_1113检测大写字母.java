package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/11/13/23:21
 * @Description:
 */
public class _1113检测大写字母 {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }

        // 看第一个字母
        char first = word.charAt(0);
        if (first >= 'A' && first <= 'Z') {
            for (int i = 1; i < word.length() - 1; i++) {
                if (f(word.charAt(i)) != f(word.charAt(i + 1))) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean f(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return true;
        }
        return false;
    }
}
