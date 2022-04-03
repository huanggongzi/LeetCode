package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/04/03/23:46
 * @Description:
 */
public class _20220403寻找比目标字母大的最小字母 {
    public char nextGreatestLetter(char[] letters, char target) {
        char ch = (char) ('z' + 1);
        for (int i = 0; i < letters.length; i++) {
            if (f(letters[i], target) && f(ch, letters[i])) {
                ch = letters[i];
            }
        }
        return ch == '{' ? letters[0] : ch;
    }

    public boolean f(char ch, char target) {
        int num1 = ch - 'a';
        int num2 = target - 'a';
        if (num1 > num2) {
            return true;
        } else {
            return false;
        }
    }
}
