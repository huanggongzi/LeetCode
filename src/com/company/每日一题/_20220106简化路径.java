package com.company.每日一题;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/01/06/22:31
 * @Description:
 */
public class _20220106简化路径 {
    public static void main(String[] args) {
        simplifyPath("/home//foo/");
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        // 第一个想法，肯定是按'/'分
        String[] str = path.split("/");
        for (int i = 0; i < str.length; i++) {
            if ("..".equals(str[i])) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (".".equals(str[i]) || "".equals(str[i])) {
                continue;
            } else {
                stack.add(str[i]);
            }
        }
        Stack<String> stackTwo = new Stack<>();
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            stackTwo.add(stack.pop());
        }
        while (!stackTwo.isEmpty()) {
            sb.append("/" + stackTwo.pop());
        }
        if (sb.length() == 0) {
            return "/";
        }
        return sb.toString();
    }
}
