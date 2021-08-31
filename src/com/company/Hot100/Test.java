package com.company.Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 你的名字
 * @Date: 2021/08/20/0:31
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'a', 'a', 'b', 'b', 'a', 'a'};
        System.out.println(new Test().compress(chars));
    }

    public int compress(char[] chars) {
        int len = chars.length;
        if (len <= 1) {
            return len;
        }
        int left = 0;
        int right = 1;
        int index = 0;

        while (right < len && left <= right) {
            while (right < len && chars[right] == chars[left]) {
                right++;
            }
            chars[index] = chars[left];
            if (right - left >= 10) {
                List<Integer> list = new ArrayList<>(2000);
                int num = right - left;
                while (num != 0) {
                    int value = num % 10;
                    num = num / 10;
                    list.add(value);
                }
                for (int i = list.size() - 1; i >= 0; i--) {
                    chars[++index] = (char) (list.get(i) + '0');
                }
            } else if (right - left >= 2) {
                chars[++index] = (char) (right - left + '0');
            }
            index++;
            left = right;
        }

        return index;
    }
}
