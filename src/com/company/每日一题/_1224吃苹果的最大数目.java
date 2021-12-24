package com.company.每日一题;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/24/22:14
 * @Description:
 */
public class _1224吃苹果的最大数目 {
    public int eatenApples(int[] apples, int[] days) {
        // 贪心，每天只能吃一个
        int n = apples.length;

        PriorityQueue<Apple> priorityQueue = new PriorityQueue<>(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.time - o2.time;
            }
        });

        int sum = 0;
        int time = 0;
        // 计算下当前能吃的苹果 模拟一下
        for (int i = 0; i < apples.length; i++) {
            Apple apple = new Apple();
            apple.value = apples[i];
            apple.time = i + days[i];
            if (apple.value != 0) {
                priorityQueue.add(apple);
            }

            // 处理过期的数据
            while (!priorityQueue.isEmpty() && (priorityQueue.peek().time <= time || priorityQueue.peek().value == 0)) {
                priorityQueue.poll();
            }

            if (priorityQueue.isEmpty()) {
                time++;
                continue;
            }

            // 直接弹出最上面的，也就是快过期的
            Apple firstApple = priorityQueue.poll();

            // 看当前剩余了多少
            if (firstApple.value - 1 > 0) {
                firstApple.value--;
                priorityQueue.add(firstApple);
            }
            sum++;
            time++;
        }

        while (!priorityQueue.isEmpty()) {
            while (!priorityQueue.isEmpty() && (priorityQueue.peek().time <= time || priorityQueue.peek().value == 0)) {
                priorityQueue.poll();
            }
            if (priorityQueue.isEmpty()) {
                return sum;
            }
            // 直接弹出最上面的，也就是快过期的
            Apple firstApple = priorityQueue.poll();

            // 看当前剩余了多少
            if (firstApple.value - 1 > 0) {
                firstApple.value--;
                priorityQueue.add(firstApple);
            }
            sum++;
            time++;
        }


        return sum;

    }
}

class Apple {
    int value;
    int time;
}