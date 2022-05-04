package com.company.每日一题;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/05/04/0:30
 * @Description:
 */
public class _20220504找出游戏的获胜者 {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (queue.size() != 1) {
            Queue<Integer> path = new LinkedList<>();
            // 队列出来K个
            int k1 = k;
            if (k1 >= queue.size()) {
                k1 = k1 % queue.size();
            }
            for (int i = 0; i < k; i++) {
                path.add(queue.poll());
            }
            for (int i = 0; i < path.size() - 1; i++) {
                queue.add(path.poll());
            }
        }

        return queue.peek();
    }
}
