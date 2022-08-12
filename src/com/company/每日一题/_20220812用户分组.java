package com.company.每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _20220812用户分组 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            if (map.containsKey(groupSizes[i])) {
                List<Integer> path = map.get(groupSizes[i]);
                path.add(i);
                map.put(groupSizes[i], path);
            } else {
                List<Integer> path = new ArrayList<>();
                path.add(i);
                map.put(groupSizes[i], path);
            }
        }

        // 3 - 0 1 2 3 4 6
        // 1 - 5
        //
        List<List<Integer>> resultList = new ArrayList<>();
        for (Integer key : map.keySet()) {
            List<Integer> path = map.get(key);
            int size = path.size();
            // 当前的分组的大小 > 总数组的大小，直接分配即可
            if (key >= size) {
                resultList.add(path);
            } else {
                int num = 0;
                while (num <= size) {
                    List<Integer> pathF = new ArrayList<>();
                    for (int i = 0; i < key; i++) {
                        if (num <= size) {
                            pathF.add(path.get(num++));
                        }
                    }
                }
            }
        }
        return resultList;
    }
}
