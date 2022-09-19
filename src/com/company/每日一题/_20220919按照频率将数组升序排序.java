package com.company.每日一题;

import java.util.*;

public class _20220919按照频率将数组升序排序 {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Data> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            list.add(new Data(key, map.get(key)));
        }

        Collections.sort(list, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if (o1.num > o2.num) {
                    return 1;
                } else if (o1.num < o2.num) {
                    return -1;
                }

                if (o1.value > o2.value) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        int[] array = new int[nums.length];
        int index = 0;
        for (Data data : list) {
            int value = data.value;
            int num = data.num;
            for (int i = 0; i < num; i++) {
                array[index++] = data.value;
            }
        }
        return array;
    }
}

class Data {
    int value;
    int num;

    public Data(int value, int num) {
        this.value = value;
        this.num = num;
    }
}
