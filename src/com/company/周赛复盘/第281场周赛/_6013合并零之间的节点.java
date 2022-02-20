package com.company.周赛复盘.第281场周赛;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/02/20/18:16
 * @Description:
 */
public class _6013合并零之间的节点 {
    public ListNode mergeNodes(ListNode head) {
        ListNode p1 = new ListNode(0);
        ListNode p2 = p1;
        ListNode newHead = head.next;
        int sum = 0;
        while (newHead != null) {
            if (newHead.val == 0) {
                ListNode next = new ListNode(sum);
                p2.next = next;
                p2 = p2.next;
                sum = 0;
            } else {
                sum = sum + newHead.val;
            }
            newHead = newHead.next;
        }
        return p1.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}