package com.company.practise;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 你的名字
 * @Date: 2021/09/18/1:13
 * @Description:
 */
public class _1910删除一个字符串中所有出现的给定子字符串 {
    public static void main(String[] args) {
        removeOccurrences("daabcbaabcbc", "abc");
    }

    public static String removeOccurrences(String s, String part) {
        // 双指针 和 栈
        int len = part.length();
        Stack<Character> stack = new Stack<>();
        char target = part.charAt(len - 1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == target) {
                // 判断 去除
                stack.add(s.charAt(i));
                isMatching(stack, part);
            } else {
                stack.add(s.charAt(i));
            }
        }

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }


    public static void isMatching(Stack<Character> stack, String part) {
        StringBuffer sb = new StringBuffer();
        int len = part.length() - 1;
        while ( len >= 0) {
            sb.append(stack.pop());
            len--;
        }

        if (!isSame(sb.toString(), part)) {
            for (int i = sb.length() - 1; i >= 0; i--) {
                stack.add(sb.charAt(i));
            }
        }
    }

    public static boolean isSame(String s1, String s2) {
        int len = s2.length() - 1;
        for (int i = 0; i <= len; i++) {
            if (s1.charAt(i) != s2.charAt(len - i)) {
                return false;
            }
        }
        return true;
    }

}
