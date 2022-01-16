package com.company.每日一题;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/01/16/0:09
 * @Description:
 */
public class _20220116链表随机节点 {
    Map<Integer, ListNode> map;
    int len;
    Random random;

    public _20220116链表随机节点(ListNode head) {
        map = new HashMap<>();
        random = new Random();
        ListNode p1 = head;
        int len = 0;
        while (p1 != null) {
            map.put(len, p1);
            p1 = p1.next;
            len++;
        }
        this.len = len;
    }

    public int getRandom() {
        int index = random.nextInt(len);
        return map.get(index).val;
    }
}
