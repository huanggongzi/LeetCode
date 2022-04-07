package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/04/07/23:57
 * @Description:
 */
public class _20220407旋转字符串 {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        goal = goal + goal;
        // System.out.println(goal);
        for (int i = 0; i < goal.length() / 2; i++) {
            if (f(s, goal, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean f(String s, String goal, int index) {
        int start = 0;
        for (int i = index; i < s.length() + index; i++) {
            if (s.charAt(start++) != goal.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
