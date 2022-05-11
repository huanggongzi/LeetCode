package com.company.每日一题;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/05/11/23:54
 * @Description:
 */
public class _20220511序列化和反序列化二叉搜索树 {
    // Encodes a tree to a single string.
    // 如果当前位置的没有数据，则标为 X
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                sb.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            }else{
                sb.append("X,");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == ""){
            return null;
        }

        Queue<String> nodes = new ArrayDeque<>(Arrays.asList(data.split(",")));
        TreeNode root = new TreeNode(Integer.parseInt(nodes.poll()));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            String left = nodes.poll();
            String right = nodes.poll();

            if(!left.equals("X")){
                curr.left = new TreeNode(Integer.parseInt(left));
                queue.add(curr.left);
            }
            if(!right.equals("X")){
                curr.right = new TreeNode(Integer.parseInt(right));
                queue.add(curr.right);
            }
        }
        return root;
    }
}
