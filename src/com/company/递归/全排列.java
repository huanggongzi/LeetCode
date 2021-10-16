package com.company.递归;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/16/22:08
 * @Description:
 */
public class 全排列 {
    public static void main(String[] args) {
        String str = "abc";
        List<String> ans = new ArrayList<>();
        StringBuffer path = new StringBuffer();
        boolean[] vis = new boolean[str.length()];
        f(str.toCharArray(), path, ans, vis);
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
     * @param rest
     * @param path
     * @param ans
     */
    public static void f(char[] rest, StringBuffer path, List<String> ans) {
        if (path.length() == rest.length) {
            ans.add(path.toString());
            return;
        }
        for (int i = 0; i < rest.length; i++) {

        }
    }

    public void swap(char[] rest, int i, int j) {
        char ch = rest[i];
        rest[i] = rest[j];
        rest[j] = ch;
    }
}
