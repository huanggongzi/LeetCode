package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/11/18/1:16
 * @Description:
 */
public class _1118二叉树的坡度 {
    int sum = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return sum;
    }


    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 求出左子树的所有值
        int left = dfs(root.left);
        // 求出右子树的所有值
        int right = dfs(root.right);
        // 左子树和右子树差的绝对值
        sum = sum + Math.abs(left - right);
        // 及时更新当前点的值，为左子树+右子树
        return root.val + left + right;
    }

    public void dfs1(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            sum = sum;
        } else if (root.left == null && root.right != null) {
            dfs(root.right);
            sum = sum + Math.abs(root.right.val);
        } else if (root.left != null && root.right == null) {
            dfs(root.left);
            sum = sum + Math.abs(root.left.val);
        } else {
            dfs(root.left);
            dfs(root.right);
            sum = sum + Math.abs(root.left.val - root.right.val);
        }
        if (root.left != null) {
            root.val = root.val + root.left.val;
        }

        if (root.right != null) {
            root.val = root.val + root.right.val;
        }
    }
}
