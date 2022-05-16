package com.company.每日一题;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/05/16/23:29
 * @Description:
 */
public class _20220516后继者 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if (pre == p) {
                return node;
            }
            pre = node;
            root = node.right;
        }

        return null;
    }
}
