package com.company.每日一题;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/01/14/0:26
 * @Description:
 */
public class _20220114查找和最小的K对数字 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(new MyCompareTo());
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer> path = new ArrayList<>();
                path.add(nums1[i]);
                path.add(nums2[i]);
                priorityQueue.add(path);
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        while (k > 0) {
            if (priorityQueue.isEmpty()) {
                return list;
            }
            list.add(priorityQueue.poll());
            k--;
        }
        return list;
    }


    class MyCompareTo implements Comparator<List<Integer>> {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            return o1.get(0) + o1.get(1) - o2.get(0) - o2.get(1);

        }
    }

    class MyCompareToTwo implements Comparator<List<Integer>> {
        int[] nums1;
        int[] nums2;

        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            return nums1[o1.get(0)] + nums2[o1.get(1)] - nums1[o2.get(0)] - nums2[o2.get(1)];
        }

        public MyCompareToTwo(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
        }
    }

    public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(new MyCompareToTwo(nums1, nums2));
        int len = nums1.length;
        for (int i = 0; i < Math.min(len, k); i++) {
            List<Integer> path = new ArrayList<>();
            path.add(i);
            path.add(0);
            priorityQueue.add(path);
        }

        List<List<Integer>> list = new ArrayList<>();
        while (k-- > 0 && !priorityQueue.isEmpty()) {
            List<Integer> path = priorityQueue.poll();
            List<Integer> x = new ArrayList<>();
            x.add(nums1[path.get(0)]);
            x.add(nums2[path.get(1)]);
            priorityQueue.add(path);
            if (path.get(1) + 1 < nums2.length) {
                List<Integer> path1 = new ArrayList<>();
                path.add(path1.get(0));
                path.add(path.get(1) + 1);
                priorityQueue.add(path);
            }
        }
        return list;
    }
}
