package com.company.每日一题;

import java.util.List;
import java.util.Stack;

public class _20220807函数的独占时间 {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (n == 0) {
            return new int[0];
        }
        int[] nums = new int[n];

        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < logs.size(); i++) {
            String[] strings = logs.get(i).split(":");
            int index = Integer.valueOf(strings[0]);
            String type = strings[1];
            int time = Integer.valueOf(strings[2]);

            // 系统调用
            if (type.equals("start")) {
                if (!stack.isEmpty()) {
                    nums[stack.peek()[0]] += time - stack.peek()[1];
                    stack.peek()[1] = time;
                }
                stack.add(new int[]{index, time});
            } else {
                int[] org = stack.pop();
                nums[index] += time - org[1] + 1;
                if(!stack.isEmpty()){
                    stack.peek()[1] = time + 1;
                }
            }
        }
        return nums;
    }
}
