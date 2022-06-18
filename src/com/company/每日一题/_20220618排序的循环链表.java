package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/06/18/23:41
 * @Description:
 */
public class _20220618排序的循环链表 {
    public Node insert(Node head, int insertVal) {
        Node curr = new Node(insertVal);
        if(head == null){
            curr.next = curr;
            return curr;
        }
        Node p1 = head;
        Node p2 = head;
        if(p1.next == p1){
            p1.next = curr;
            curr.next = p1;
            return head;
        }
        Node max = p1;
        Node min = p1;
        p1 = p1.next;
        while(p1 != head){
            if(p1.val >= max.val){
                max = p1;
            }
            if(p1.val < min.val){
                min = p1;
            }
            p1 = p1.next;
        }
        if(insertVal >= max.val || insertVal <= min.val){
            max.next = curr;
            curr.next = min;
        }else{
            while(insertVal < p2.val || insertVal > p2.next.val){
                p2 = p2.next;
            }
            Node next = p2.next;
            p2.next = curr;
            curr.next = next;
        }


        return head;
    }
}
