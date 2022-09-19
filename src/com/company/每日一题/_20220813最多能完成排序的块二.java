package com.company.每日一题;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;

public class _20220813最多能完成排序的块二 {
    public static void main(String[] args) {
        GenericEventExecutorChooser genericEventExecutorChooser = new GenericEventExecutorChooser();
        while (true) {
            genericEventExecutorChooser.next();
        }
    }

    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int num : arr) {
            if (stack.isEmpty() || num >= stack.peek()) {
                stack.push(num);
            } else {
                int mx = stack.pop();
                while (!stack.isEmpty() && stack.peek() > num) {
                    stack.pop();
                }
                stack.push(mx);
            }
        }
        return stack.size();
    }
}

class GenericEventExecutorChooser {
    private final AtomicInteger idx = new AtomicInteger();
    private final int[] executors = new int[10];

    {
        for (int i = 0; i < executors.length; i++) {
            executors[i] = i;
        }
    }

    public int next() {
        idx.set(Integer.MAX_VALUE);
        //递增、取模，取正值，不然可能是负数，另外：有个非常小的缺点，当idx累加成最大值后，有短暂的不公平：
        //1，2，3，4，5，6，7，0，7（注意这里不是1，而是7，然而往前的第二个也是7，所以不够公平），6，5
        System.out.println(idx.getAndIncrement() % executors.length);
        return 1;
        // return executors[Math.abs(];
    }
}
