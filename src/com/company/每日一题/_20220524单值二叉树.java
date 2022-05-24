package com.company.每日一题;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/05/24/23:46
 * @Description:
 */
public class _20220524单值二叉树 {
    List<Integer> list = new ArrayList<>();

    public boolean isUnivalTree(TreeNode root) {
        dfs(root);
        if (list.size() <= 1) {
            return true;
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) != list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public void dfs(TreeNode root) {
        if (root != null) {
            list.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }
    }
}
