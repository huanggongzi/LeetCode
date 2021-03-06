package com.company.递归.递归第一节;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/16/22:08
 * @Description:
 */
public class 全排列 {
    public static void main(String[] args) {
        ArrayList<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        char[] chars = new char[]{'a', 'c', 'c'};
        List<String> ans = new ArrayList<>();
        StringBuffer path = new StringBuffer();
        // boolean[] vis = new boolean[str.length()];
        f3(chars, ans, 0);
        System.out.println(ans);
    }

    /**
     * 常规版的全排列
     *
     * @param rest
     * @param path
     * @param ans
     */
    public static void f(char[] rest, StringBuffer path, List<String> ans, boolean[] vis) {
        if (path.length() == rest.length) {
            ans.add(path.toString());
            return;
        }
        for (int i = 0; i < rest.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                path.append(rest[i]);
                f(rest, path, ans, vis);
                vis[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    /**
     * 左神的暴力全排列
     *
     * @param rest
     * @param path
     * @param ans
     */
    public static void f1(ArrayList<Character> rest, String path, List<String> ans, int size) {
        if (path.length() == size) {
            ans.add(path);
            return;
        }
        int N = rest.size();
        for (int i = 0; i < N; i++) {
            char ch = rest.get(i);
            rest.remove(i);
            f1(rest, path + ch, ans, size);
            rest.add(i, ch);
        }
    }

    /**
     * 交换下的全排列
     *
     * @param rest
     * @param ans
     * @param index
     */
    public static void f3(char[] rest, List<String> ans, int index) {
        if (index == rest.length) {
            ans.add(String.valueOf(rest));
            return;
        }
        // 当前是哪个字符
        // 只能往后交换
        // 如果需要去重的话，加一个boolen标记
        // 每次都以rest[index]开头,并且不能和之后出现的一样，比如：acc,当选中c时,之后的c不再选中
        boolean[] vis = new boolean[256];
        for (int i = index; i < rest.length; i++) {
            if (!vis[rest[i]]) {
                vis[rest[i]] = true;
                swap(rest, index, i);
                f3(rest, ans, index + 1);
                swap(rest, index, i);
            }
        }
    }

    public static void swap(char[] rest, int i, int j) {
        char ch = rest[i];
        rest[i] = rest[j];
        rest[j] = ch;
    }

    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    if (i != j && j != k && i != k) {
                        getSum(digits[i], digits[j], digits[k], set);
                    }
                }
            }
        }

        int[] arr = new int[set.size()];
        int num = 0;
        for(Integer value : set){
            arr[num++] = value;
        }
        Arrays.sort(arr);
        return arr;
    }

    public void getSum(int a, int b, int c, Set<Integer> set) {
        if (getNum(a, b, c) >= 0) {
            set.add(getNum(a, b, c));
        }
        if (getNum(a, c, b) >= 0) {
            set.add(getNum(a, c, b));
        }
        if (getNum(b, a, c) >= 0) {
            set.add(getNum(b, a, c));
        }
        if (getNum(b, c, a) >= 0) {
            set.add(getNum(b, c, a));
        }
        if (getNum(c, a, b) >= 0) {
            set.add(getNum(c, a, b));
        }
        if (getNum(c, b, a) >= 0) {
            set.add(getNum(c, b, a));
        }
    }

    public int getNum(int a, int b, int c) {
        if (a == 0 || c % 2 == 1) {
            return -1;
        }
        return a * 100 + b * 10 + c;
    }
}
