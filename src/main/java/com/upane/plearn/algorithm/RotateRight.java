package com.upane.plearn.algorithm;

/**
 * Description:旋转链表
 *
 * @Author:pan
 * @Date:2022/6/16
 */
public class RotateRight {

    public static class ListNode {
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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) {
            return head;
        }
        ListNode flag = head;
        // 需要从1 开始累加 链表长度
        int n = 1;
        while (flag.next != null) {
            flag = flag.next;
            n++;
        }
        int pos = n - k % n;
        if (pos == n) {
            return head;
        }
        // 将链表连接成环
        flag.next = head;
        while (pos-- >= 0) {
            flag = flag.next;
        }

        // 需要指定为 flag， head的头指针不对，需要为next（因为指针位置
        ListNode res = flag.next;
        flag.next = null;
        return res;
    }

    public static void main(String[] args) {

        ListNode myLinkedList6 = new ListNode(6);
        ListNode myLinkedList5 = new ListNode(5, myLinkedList6);
        ListNode myLinkedList4 = new ListNode(4, myLinkedList5);
        ListNode myLinkedList3 = new ListNode(3, myLinkedList4);
        ListNode myLinkedList2 = new ListNode(2, myLinkedList3);
        ListNode myLinkedList1 = new ListNode(1, myLinkedList2);

        RotateRight removeNthFromEnd = new RotateRight();
        ListNode listNode = removeNthFromEnd.rotateRight(myLinkedList1, 4);
        System.out.println(listNode);

    }
}
