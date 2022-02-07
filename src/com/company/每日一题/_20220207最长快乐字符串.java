package com.company.每日一题;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/02/07/21:28
 * @Description:
 */
public class _20220207最长快乐字符串 {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        if (a > 0) {
            priorityQueue.add(new int[]{'a', a});
        }
        if (b > 0) {
            priorityQueue.add(new int[]{'b', b});
        }
        if (c > 0) {
            priorityQueue.add(new int[]{'c', c});
        }

        StringBuffer stringBuffer = new StringBuffer();

        while (!priorityQueue.isEmpty()) {
            int[] top = priorityQueue.poll();
            int n = stringBuffer.length();
            // 如果当前的字符串大于2,并且已经连续出现两个字母在一起的情况,需要选次大的
            if (n >= 2 && stringBuffer.charAt(n - 1) == top[0] && stringBuffer.charAt(n - 2) == top[0]) {
                if (priorityQueue.isEmpty()) {
                    return stringBuffer.toString();
                } else {
                    int[] sed = priorityQueue.poll();
                    stringBuffer.append((char) sed[0]);
                    if (--sed[1] >= 1) {
                        priorityQueue.add(sed);
                    }
                    priorityQueue.add(top);
                }
            } else {
                // 直接取最大的即可
                stringBuffer.append((char) top[0]);
                if (--top[1] >= 1) {
                    priorityQueue.add(top);
                }
            }
        }
        return stringBuffer.toString();
    }
}
