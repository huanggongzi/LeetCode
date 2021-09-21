package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 你的名字
 * @Date: 2021/09/21/21:35
 * @Description:
 */
public class _921最后一个单词的长度 {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        for (len = len - 1; len >= 0; len--) {
            if (s.charAt(len) != ' ') {
                break;
            }
        }

        int sum = 0;

        while (len >= 0 && s.charAt(len) != ' ') {
            len--;
            sum++;
        }

        return sum;

    }
}
