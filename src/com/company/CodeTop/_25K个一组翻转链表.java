package com.company.CodeTop;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/02/23:47
 * @Description:
 */
public class _25K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode pre = dumy;
        ListNode end = dumy;
        while (end != null) {
            for (int i = 0; i < k; i++) {
                // 如果不足K的需要交换
                if (end.next == null) {
                    ListNode p1 = reverse(pre.next);
                    pre.next = p1;
                    end = null;
                    break;
                }
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode next = end.next;
            ListNode start = pre.next;
            end.next = null;
            ListNode newHead = reverse(start);
            start.next = next;
            pre.next = end;
            pre = start;
            end = start;
        }
        return dumy.next;
    }


    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
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