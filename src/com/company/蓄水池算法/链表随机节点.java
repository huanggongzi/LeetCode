package com.company.蓄水池算法;


import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/01/17/23:15
 * @Description:
 */
public class 链表随机节点 {
    ListNode head;
    Random random;

    public 链表随机节点(ListNode head) {
        random = new Random();
        this.head = head;
    }

    public int getRandom() {
        ListNode target = head;
        ListNode p1 = head;
        int num = 1;
        while (p1 != null) {
            if (num == 1) {
                target = p1;
            } else {
                if (getNum(num) == 1) {
                    target = p1;
                }
            }
            num++;
            p1 = p1.next;
        }
        return target.val;
    }

    public int getNum(int i) {
        // random.nextInt(i):返回[0,i)的数
        return random.nextInt(i) + 1;
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