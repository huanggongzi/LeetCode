package com.company.CodeTop;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/05/12/0:06
 * @Description:
 */
public class _103二叉树的锯齿形层序遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int count = 0;
        while (!deque.isEmpty()) {
            LinkedList<Integer> path = new LinkedList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (count % 2 == 0) {
                    path.addLast(node.val);
                } else {
                    path.addFirst(node.val);
                }
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
            count++;
            list.add(path);
        }
        return list;
    }
}
