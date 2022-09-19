package com.company.每日一题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _20220822输出二叉树 {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        int height = getHeight(root);
        int m = height;
        int n = getLine(height) - 1;

        Queue<Tree> queue = new LinkedList<>();

        queue.add(new Tree(root, 0, (n - 1) / 2));

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> path = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Tree tree = queue.poll();
                TreeNode node = tree.root;
                int heng = tree.i;
                int j = tree.j;


                setList(path, (n - 1) / 2, n, node);

                if (node.left != null) {
                    queue.add(new Tree(node.left, heng + 1, j - getLine(height - 2 - heng)));
                }
                if (node.right != null) {
                    queue.add(new Tree(node.left, heng + 1, j + getLine(height - 2 - heng)));
                }
            }
        }

        return list;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }

    public int getLine(int height) {
        int sum = 0;
        for (int i = 0; i < height; i++) {
            sum = sum * 2;
        }
        return sum;
    }

    public void setList(List<String> path, int j, int n, TreeNode node) {
        for (int i = 0; i < j - 1; i++) {
            path.add("");
        }
        path.add(String.valueOf(node.val));
    }
}

class Tree {
    TreeNode root;
    int i;
    int j;

    public Tree(TreeNode root, int i, int j) {
        this.root = root;
        this.i = i;
        this.j = j;
    }
}