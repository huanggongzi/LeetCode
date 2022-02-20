package com.company.周赛复盘.第281场周赛;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/02/20/18:16
 * @Description:
 */
public class _6014构造限制重复的字符串 {
    class Solution {
        public String repeatLimitedString(String s, int repeatLimit) {
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0] - o1[0];
                }
            });
            int[] arr = new int[26];
            for (int i = 0; i < s.length(); i++) {
                arr[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (arr[i] != 0) {
                    priorityQueue.add(new int[]{i, arr[i]});
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            while (!priorityQueue.isEmpty()) {
                int[] val = priorityQueue.peek();
                if (stringBuffer.length() != 0 && val[0] + 'a' == stringBuffer.charAt(stringBuffer.length() - 1)) {
                    return stringBuffer.toString();
                }
                if (val[1] <= repeatLimit) {
                    stringBuffer.append(f(val[0], val[1]));
                    priorityQueue.poll();
                } else {
                    stringBuffer.append(f(val[0], repeatLimit));
                    int[] first = priorityQueue.poll();
                    if (priorityQueue.isEmpty()) {
                        return stringBuffer.toString();
                    } else {
                        int[] sed = priorityQueue.peek();
                        if (sed[1] > 0) {
                            stringBuffer.append(f(sed[0], 1));
                            priorityQueue.poll();
                            first[1] = first[1] - repeatLimit;
                            sed[1] = sed[1] - 1;
                            if (first[1] >= 1) {
                                priorityQueue.add(first);
                            }
                            if (sed[1] >= 1) {
                                priorityQueue.add(sed);
                            }
                        }
                    }
                }
            }
            return stringBuffer.toString();
        }

        public String f(int num, int value) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < value; i++) {
                stringBuffer.append((char) (num + 'a'));
            }
            return stringBuffer.toString();
        }

    }
}
