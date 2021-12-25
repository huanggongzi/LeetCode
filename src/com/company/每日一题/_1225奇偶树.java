package com.company.每日一题;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/25/23:44
 * @Description:
 */
public class _1225奇偶树 {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (root.val % 2 == 0) {
            return false;
        }
        queue.add(root);
        int num = 0;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if (check(currNode, num, level)) {
                    if (currNode.left != null) {
                        queue.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        queue.add(currNode.right);
                    }
                } else {
                    //System.out.println(level);
                    return false;
                }
                num = currNode.val;
            }
            level++;
            if (level % 2 == 0) {
                num = 0;
            } else {
                num = 10000000;
            }
        }
        return true;
    }

    public boolean check(TreeNode root, int num, int level) {
        int value = root.val;
        // 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
        if (level % 2 == 0) {
            if (value % 2 == 1 && value > num) {
                return true;
            } else {
                return false;
            }
        } else {
            // 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
            if (value % 2 == 0 && value < num) {
                return true;
            } else {
                return false;
            }
        }
    }
}
