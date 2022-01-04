package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/01/05/0:26
 * @Description:
 */
public class _20220105替换所有的问号 {
    public static void main(String[] args) {
        _20220105替换所有的问号 test = new _20220105替换所有的问号();
        System.out.println(test.modifyString("a?b"));
    }

    public String modifyString(String s) {
        if (s.length() == 1) {
            if (s.charAt(0) == '?') {
                return "a";
            } else {
                return s;
            }
        }
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < sb.length(); i++) {
            if (i == sb.length() - 1 && sb.charAt(sb.length() - 1) == '?') {
                sb.setCharAt(sb.length() - 1, getChar(sb.charAt(s.length() - 2), 'z'));
            } else if (i == 0 && sb.charAt(0) == '?') {
                sb.setCharAt(0, getChar(sb.charAt(i + 1), 'z'));
            } else if (sb.charAt(i) == '?') {
                sb.setCharAt(i, getChar(sb.charAt(i - 1), sb.charAt(i + 1)));
            }
        }

        return sb.toString();
    }

    public char getChar(char ch1, char ch2) {
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (ch != ch1 && ch != ch2) {
                return ch;
            }
        }
        return 'c';
    }
}
