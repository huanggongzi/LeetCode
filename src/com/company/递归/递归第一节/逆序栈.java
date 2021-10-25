package com.company.递归.递归第一节;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/17/22:52
 * @Description:
 */
public class 逆序栈 {
    public int finalValue(Stack<Integer> stack) {
        int value = stack.pop();
        if (stack.isEmpty()) {
            return value;
        }
        int last = finalValue(stack);
        stack.add(value);
        return last;
    }


    public void reserve(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int value = finalValue(stack);
        reserve(stack);
        stack.add(value);
    }
}
