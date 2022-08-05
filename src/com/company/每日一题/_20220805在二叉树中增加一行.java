package com.company.每日一题;

import java.util.LinkedList;
import java.util.Queue;

public class _20220805在二叉树中增加一行 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }else{
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int hight = 1;
            while(!queue.isEmpty()){
                if(hight == depth - 1){
                    int size = queue.size();
                    for(int i = 0; i < size; i++){
                        TreeNode currNode = queue.poll();
                        currNode.left = new TreeNode(val, currNode.left, null);
                        currNode.right = new TreeNode(val, null, currNode.right);

                    }
                }else{
                    int size = queue.size();
                    for(int i = 0; i < size; i++){
                        TreeNode currNode = queue.poll();
                        if(currNode.left != null){
                            queue.add(currNode.left);
                        }
                        if(currNode.right != null){
                            queue.add(currNode.right);
                        }
                    }
                }
                hight++;
            }
        }
        return root;
    }
}
