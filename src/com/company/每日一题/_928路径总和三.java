package com.company.每日一题;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/09/28/22:03
 * @Description:
 */
public class _928路径总和三 {
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        bianli(root, targetSum);
        return count;
    }

    // 回溯 + 前缀和
    public int getNum(HashMap<Integer, Integer> map, TreeNode root, int targetSum, int curr) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        curr = curr + root.val;
        ret = map.getOrDefault(curr - targetSum, 0);
        map.put(curr, map.getOrDefault(curr, 0) + 1);
        ret = ret + getNum(map, root.left, targetSum, curr);
        ret = ret + getNum(map, root.right, targetSum, curr);
        map.put(curr, map.getOrDefault(curr, 0) - 1);
        return ret;
    }

    // 自上而下
    public void dfs(TreeNode node, int targetSum, int sum) {
        if (node == null) {
            return;
        }
        if (sum + node.val == targetSum) {
            count++;
        }
        dfs(node.left, targetSum, sum + node.val);
        dfs(node.right, targetSum, sum + node.val);
    }

    public void bianli(TreeNode node, int targetSum) {
        if (node != null) {
            bianli(node.left, targetSum);
            dfs(node, targetSum, 0);
            bianli(node.right, targetSum);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}