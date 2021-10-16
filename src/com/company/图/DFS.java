package com.company.图;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/09/29/0:19
 * @Description:
 */
public class DFS {
    public static void main(String[] args) {
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node0.nexts.add(node3);
        node0.nexts.add(node1);
        node3.nexts.add(node2);
        node3.nexts.add(node4);
        node4.nexts.add(node5);
        DFS(node0);
        System.out.println();
        System.out.println("递归版本：");
        DFS2(node0, new HashSet<>());
    }

    public static void DFS(Node node) {
        Stack<Node> stack = new Stack<>();
        Set<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println("迭代版本：");
        System.out.print(node.value + " ");
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.add(cur);
                    stack.add(next);
                    System.out.print(next.value + " ");
                    set.add(next);
                    break;
                }
            }
        }
    }

    /**
     *
     * @param node
     * @param set
     */
    public static void DFS2(Node node, Set<Node> set) {
        if (node == null) {
            return;
        }
        if (!set.contains(node)) {
            set.add(node);
            System.out.print(node.value + " ");
            for (Node node1 : node.nexts) {
                DFS2(node1, set);
            }
        }
    }
}
