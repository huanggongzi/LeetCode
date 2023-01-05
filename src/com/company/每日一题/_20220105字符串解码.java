package com.company.每日一题;

import java.util.Stack;

public class _20220105字符串解码 {
    public static void main(String[] args) {
        System.out.println(decodeString("100[leetcode]"));
    }

    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        if (s == null || s.length() == 0) {
            return "";
        }

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            // 如果是空的，说明刚开始，需要添加数据
            if (stack.isEmpty()) {
                stack.add(chars[i]);
            } else {
                char ch = chars[i];
                if (ch == ']') {
                    StringBuffer sb = new StringBuffer();
                    while (stack.peek() != '[') {
                        sb.append(stack.pop());
                    }

                    // 翻转一下
                    sb = sb.reverse();

                    // 弹出符号[
                    stack.pop();

                    // 选择当前的数字
                    StringBuffer numSb = new StringBuffer();
                    while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                        numSb.append(stack.pop());
                    }
                    int num = Integer.valueOf(numSb.reverse().toString());

                    // 循环几次，放进去
                    for (int j = 0; j < num; j++) {
                        for (int k = 0; k < sb.length(); k++) {
                            stack.add(sb.charAt(k));
                        }
                    }
                } else {
                    stack.add(chars[i]);
                }
            }
        }

        StringBuffer result = new StringBuffer();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}
