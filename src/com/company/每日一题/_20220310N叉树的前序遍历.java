package com.company.每日一题;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/10/23:26
 * @Description:
 */
public class _20220310N叉树的前序遍历 {
    // 迭代
    public List<Integer> preorder(Node1 root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node1> stack = new Stack<>();
        if(root == null){
            return list;
        }
        stack.add(root);

        while(!stack.isEmpty()){
            Node1 currNode1 = stack.pop();
            list.add(currNode1.val);
            if(currNode1.children != null){
                for(int i = currNode1.children.size() - 1; i >= 0; i--){
                    stack.add(currNode1.children.get(i));
                }
            }
        }
        return list;
    }
}
class Node1 {
    public int val;
    public List<Node1> children;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, List<Node1> _children) {
        val = _val;
        children = _children;
    }
}