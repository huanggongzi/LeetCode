package com.company.每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/21/23:57
 * @Description:
 */
public class _20220321两数之和输入BST {
    boolean flag = false;

    public boolean findTarget(TreeNode root, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, k, map);
        return flag;
    }

    public void dfs(TreeNode root, int k, Map<Integer, Integer> map) {
        if (root != null && !flag) {
            dfs(root.left, k, map);
            if (map.containsKey(k - root.val)) {
                flag = true;
            } else {
                map.put(root.val, 1);
            }
            dfs(root.right, k, map);
        }
    }
}
