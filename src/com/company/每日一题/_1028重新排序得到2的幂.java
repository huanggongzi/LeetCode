package com.company.每日一题;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/28/23:11
 * @Description:
 */
public class _1028重新排序得到2的幂 {
    static int max = 1000000000;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) {
        _1028重新排序得到2的幂 tset = new _1028重新排序得到2的幂();
        tset.reorderedPowerOf2(16);
    }

    static {
        int sum = 2;
        list.add(getArr(sum));
        while (sum * 2 <= max) {
            sum = sum * 2;
            list.add(getArr(sum));
        }
    }


    public static int[] getArr(int num) {
        int[] arr = new int[10];
        while (num != 0) {
            arr[num % 10]++;
            num = num / 10;
        }
        return arr;
    }

    public boolean reorderedPowerOf2(int n) {

        if (n == 1) {
            return true;
        }
        return isSame(list, getArr(n));
    }


    public boolean isSame(List<int[]> list, int[] target) {
        // for(int i = 0; i < target.length; i++){
        //     System.out.println(target[i]);
        // }
        for (int i = 0; i < list.size(); i++) {
            int[] arr = list.get(i);
            boolean flag = true;
            for (int j = 0; j < 10; j++) {
                int p1 = arr[j];
                int p2 = target[j];
                // 如果有一个不相等
                if (p1 != p2) {
                    flag = false;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }

    /**
     * 全排列
     */

}

class Solution {
    static int max = 1000000000;
    static Set<String> set = new HashSet<>();

    public boolean reorderedPowerOf2(int n) {
        if (n == 1) {
            return true;
        }
        char[] ch = String.valueOf(n).toCharArray();
        List<String> list = new ArrayList<>();
        quanpailie(ch, 0, list);
        for (int i = 0; i < list.size(); i++) {
            if (set.contains(list.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void quanpailie(char[] ch, int index, List<String> list) {
        if (index == ch.length) {
            list.add(String.valueOf(ch));
            return;
        }

        boolean[] vis = new boolean[256];
        for (int i = index; i < ch.length; i++) {
            if (!vis[ch[i]]) {
                vis[ch[i]] = true;
                swap(ch, i, index);
                quanpailie(ch, index + 1, list);
                swap(ch, i, index);
            }
        }
    }

    public void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    static {
        int sum = 2;
        set.add(getArr(sum));
        while (sum * 2 <= max) {
            sum = sum * 2;
            set.add(getArr(sum));
        }
    }


    public static String getArr(int num) {
        String str = "";
        while (num != 0) {
            str = str + (num % 10);
            num = num / 10;
        }
        return str;
    }
}