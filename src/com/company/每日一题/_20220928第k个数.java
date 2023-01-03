package com.company.每日一题;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _20220928第k个数 {
    public int getKthMagicNumber(int k) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int tmp = 1;

        set.add(tmp);
        list.add(tmp);

        int index = 1;

        while (set.size() < k) {
            if (set.contains(tmp * 3)) {
                set.add(tmp * 3);
                list.add(tmp * 3);
            }
            if (panduan(list, k) != -1) {
                return panduan(list, k);
            }
            if (set.contains(tmp * 5)) {
                set.add(tmp * 5);
                list.add(tmp * 5);
            }
            if (panduan(list, k) != -1) {
                return panduan(list, k);
            }
            if (set.contains(tmp * 7)) {
                set.add(tmp * 7);
                list.add(tmp * 7);
            }
            if (panduan(list, k) != -1) {
                return panduan(list, k);
            }
            tmp = list.get(index++);
        }

        return list.get(list.size() - 1);
    }

    public int panduan(List<Integer> list, int k) {
        if (list.size() == k) {
            return list.get(list.size() - 1);
        }
        return -1;
    }
}
