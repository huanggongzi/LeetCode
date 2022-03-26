package com.company.每日一题;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/26/21:41
 * @Description:
 */
public class _20220326棒球比赛 {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            if (ops[i] == "+") {
                int fir = stack.pop();
                int num = fir + stack.peek();
                stack.add(fir);
                stack.add(num);
            } else if (ops[i] == "D") {
                stack.add(2 * stack.peek());
            } else if (ops[i] == "C") {
                stack.pop();
            } else {
                stack.add(getValue(ops[i]));
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum = sum + stack.pop();
        }
        return sum;
    }

    public int getValue(String x) {
        return Integer.parseInt(x);
    }
}
