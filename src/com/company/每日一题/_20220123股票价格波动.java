package com.company.每日一题;

import java.sql.Time;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/01/23/15:27
 * @Description:
 */
public class _20220123股票价格波动 {
    // 价格：时间点数量
    TreeMap<Integer, Integer> map1;
    // 时间：价格
    HashMap<Integer, Integer> map2;

    // 最新时间
    int currTime;

    public _20220123股票价格波动() {
        map1 = new TreeMap<>();
        map2 = new HashMap<>();
    }

    // 在时间点 timestamp 更新股票价格为 price
    public void update(int timestamp, int price) {
        // 判断是否存在
        if (map2.containsKey(timestamp)) {
            int oldPrice = map2.get(timestamp);
            int value = map1.get(oldPrice);
            if (value > 1) {
                map1.put(oldPrice, value - 1);
            } else {
                map1.remove(oldPrice);
            }
        }
        map1.put(price, map1.getOrDefault(price, 0) + 1);
        map2.put(timestamp, price);
        currTime = Math.max(currTime, timestamp);
    }

    // 最新价格
    public int current() {
        return map2.get(currTime);
    }

    // 最高
    public int maximum() {
        return map1.lastKey();
    }

    // 最低
    public int minimum() {
        return map1.firstKey();
    }
}

/**
 * 使用堆
 */
class _20220123股票价格波动Two {
    PriorityQueue<int[]> priorityQueueMax;
    PriorityQueue<int[]> priorityQueueMin;
    HashMap<Integer, Integer> map;
    int currTime;

    public _20220123股票价格波动Two() {
        priorityQueueMax = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        priorityQueueMin = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        map = new HashMap<>();
    }

    // 在时间点 timestamp 更新股票价格为 price
    public void update(int timestamp, int price) {
        currTime = Math.max(currTime, timestamp);
        priorityQueueMax.add(new int[]{timestamp, price});
        priorityQueueMin.add(new int[]{timestamp, price});
        map.put(timestamp, price);
    }

    // 最新价格
    public int current() {
        return map.get(currTime);
    }

    // 最高
    public int maximum() {
        while (!priorityQueueMax.isEmpty()) {
            int[] target = priorityQueueMax.peek();
            // 查看是否过期
            int newPrice = map.get(target[0]);
            if (newPrice == target[1]) {
                return newPrice;
            } else {
                priorityQueueMax.poll();
            }
        }
        return -1;
    }

    // 最低
    public int minimum() {
        while (!priorityQueueMin.isEmpty()) {
            int[] target = priorityQueueMin.peek();
            // 查看是否过期
            int newPrice = map.get(target[0]);
            if (newPrice == target[1]) {
                return newPrice;
            } else {
                priorityQueueMin.poll();
            }
        }
        return -1;
    }

}
