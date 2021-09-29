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
    public static void DFS(Node node) {
        Stack<Node> stack = new Stack<>();
        Set<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.add(cur);
                    stack.add(next);
                    System.out.println(next.value);
                    set.add(next);
                    break;
                }
            }
        }
    }
}
