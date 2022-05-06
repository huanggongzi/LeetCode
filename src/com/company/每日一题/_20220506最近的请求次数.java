package com.company.每日一题;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/05/06/23:51
 * @Description:
 */
public class _20220506最近的请求次数 {
    LinkedList<Integer> queue;

    public _20220506最近的请求次数() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.addLast(t);
        while (queue.peekFirst() < t - 3000) {
            queue.pollFirst();
        }
        return queue.size();
    }
}
