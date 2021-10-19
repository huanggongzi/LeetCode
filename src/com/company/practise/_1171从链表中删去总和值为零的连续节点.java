package com.company.practise;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/18/23:38
 * @Description:
 */
public class _1171从链表中删去总和值为零的连续节点 {
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return null;
        }
        int n = 0;
        ListNode node = head;
        while (node != null) {
            n++;
            node = node.next;
        }
        int[] pre = new int[n + 1];
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode dumy = new ListNode(0, head);
        node = head;
        map.put(0, dumy);
        for (int i = 1; i <= n; i++) {
            pre[i] = node.val + pre[i - 1];
            if (map.containsKey(pre[i])) {
                ListNode next = map.get(pre[i]);
                ListNode p = next.next;
                int value = pre[i] + p.val;
                while (value != pre[i]) {
                    map.remove(value);
                    p = p.next;
                    value += p.val;
                }
                next.next = node.next;
            } else {
                map.put(pre[i], node);
            }
            node = node.next;
        }
        return dumy.next;
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
