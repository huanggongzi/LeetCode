package com.company.Offer;

import com.company.CodeTop.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/06/05/23:55
 * @Description:
 */
public class _32从上到下打印二叉树III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int num = 0;
        while (!queue.isEmpty()) {
            LinkedList<Integer> path = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (num % 2 == 0) {
                    path.addFirst(node.val);
                } else {
                    path.addLast(node.val);
                }
            }
            list.add(path);
        }
        return list;
    }
}
