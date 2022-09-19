package com.company.每日一题;

import java.util.HashMap;
import java.util.Map;

public class _20220913最大交换 {
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();

        // 每个字符的后面的最大值的映射
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            int index = -1;
            int value = -1;
            // 依次遍历最后面的值
            for (int j = i; j < chars.length; j++) {
                if (chars[j] >= chars[i]) {
                    value = chars[j] - '0';
                    index = j;
                }
            }
            map.put(i, new int[]{index, value});
        }

        for (int i = 0; i < chars.length; i++) {
            int[] array = map.get(i);
            int index = array[0];
            int value = array[1];
            // 不能是本身
            if (index != i && value != chars[i] - 'a') {
                // 进行交换
                char temp = chars[i];
                chars[i] = chars[index];
                chars[index] = temp;
                return Integer.valueOf(String.valueOf(chars));
            }
        }

        return Integer.valueOf(String.valueOf(chars));
    }
}
