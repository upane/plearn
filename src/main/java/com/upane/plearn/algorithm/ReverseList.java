package com.upane.plearn.algorithm;

/**
 * Description:
 *
 * @Author:pan
 * @Date:2022/6/6
 */
public class ReverseList {

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

    public ListNode reverseList(ListNode head) {

        ListNode flag = head;
        ListNode res = new ListNode();

        while (flag != null) {
            // 需要先存下这个链表，
            ListNode temp = flag.next;
            // 构造虚拟的链表
            flag.next = res;
            // 把结果指向虚拟表
            res = flag;
            // 把temp恢复
            flag = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode myLinkedList6 = new ListNode(6);
        ListNode myLinkedList5 = new ListNode(5, myLinkedList6);
        ListNode myLinkedList4 = new ListNode(4, myLinkedList5);
        ListNode myLinkedList3 = new ListNode(3, myLinkedList4);
        ListNode myLinkedList2 = new ListNode(2, myLinkedList3);
        ListNode myLinkedList1 = new ListNode(1, myLinkedList2);

        ReverseList removeNthFromEnd = new ReverseList();
        ListNode listNode = removeNthFromEnd.reverseList(myLinkedList1);
        System.out.println(listNode);

    }
}
