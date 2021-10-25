package com.company.递归.递归第一节;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/17/17:39
 * @Description:
 */
public class 子序列 {
    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        ans.add(0,"1");
        ans.add(0,"2");
        System.out.println(ans);
    }


    public static void all(String str, List<String> ans, String path, int index) {
        if (index == str.length()) {
            ans.add(path);
            return;
        }
        all(str, ans, path, index + 1);
        String yes = path + String.valueOf(str.charAt(index));
        all(str, ans, yes, index + 1);
    }
}
