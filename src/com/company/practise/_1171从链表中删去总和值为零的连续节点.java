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
                next.next = node.next;
                int start = remove(pre[i], pre);
                for (int j = start + 1; j <= i; j++) {
                    map.remove(pre[j]);
                }
            } else {
                map.put(pre[i], node);
            }
            node = node.next;
        }
        return dumy.next;
    }

    public int remove(int value, int[] pre) {
        for (int i = 0; i < pre.length; i++) {
            if (pre[i] == value) {
                return i;
            }
        }
        return 0;
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
