package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/19/23:36
 * @Description:
 */
public class _20220319根据二叉树创建字符串 {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return Integer.toString(root.val);
        }
        if (root.right == null) {
            return new StringBuffer().append(root.val).append("(").append(tree2str(root.left)).append(")").toString();
        }
        return new StringBuffer().append(root.val).append("(").append(tree2str(root.left)).append(")(").append(tree2str(root.right)).append(")").toString();
    }
}
