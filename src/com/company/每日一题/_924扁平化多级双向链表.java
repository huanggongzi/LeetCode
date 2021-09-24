package com.company.每日一题;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 你的名字
 * @Date: 2021/09/24/22:14
 * @Description:
 */
public class _924扁平化多级双向链表 {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur != null) {
            if (cur.child != null) {
                Node nodeNext = cur.next;
                Node node = flatten(cur.child);
                cur.next = node;
                node.prev = cur;
                cur.child = null;
                if (nodeNext != null) {
                    while (cur.next != null) {
                        cur = cur.next;
                    }
                    cur.next = nodeNext;
                    nodeNext.prev = cur;
                }
            }
            cur = cur.next;
        }
        return head;
    }

    public Node flatten2(Node head) {
        if (head == null) {
            return head;
        }
        Stack<Node> stack = new Stack<>();
        List<Node> list = new ArrayList<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            Node newNode = stack.pop();
            list.add(newNode);
            if (newNode.next != null) {
                stack.add(newNode.next);
            }
            if (newNode.child != null) {
                stack.add(newNode.child);
            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            Node curNode = list.get(i);
            curNode.child = null;
            Node nextNode = list.get(i + 1);
            nextNode.child = null;
            curNode.next = nextNode;
            nextNode.prev = curNode;
        }
        return list.get(0);
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};