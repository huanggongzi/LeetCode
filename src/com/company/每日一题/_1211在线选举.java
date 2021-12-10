package com.company.每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/11/2:06
 * @Description:
 */
public class _1211在线选举 {
    class TopVotedCandidate {
        int[] persons;
        int[] times;
        Map<Integer, Integer> map = new HashMap<>();
        int[] person = new int[5001];

        public TopVotedCandidate(int[] persons, int[] times) {
            this.persons = persons;
            this.times = times;
            int max = -1;
            int index = -1;
            for (int i = 0; i < times.length; i++) {
                int cnt = ++person[persons[i]];
                if (cnt >= max) {
                    index = persons[i];
                    max = cnt;
                    map.put(times[i], persons[i]);
                } else {
                    map.put(times[i], index);
                }
            }
        }

        public int q(int t) {
            int index = erfer(times, t);
            return map.get(times[index]);
        }


        public int erfer(int[] times, int t) {
            int left = 0;
            int right = times.length - 1;
            while (left <= right) {
                int mid = right - left + (left / 2);
                if (times[mid] == t) {
                    return mid;
                } else if (times[mid] < t) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left - 1;
        }
    }

}
