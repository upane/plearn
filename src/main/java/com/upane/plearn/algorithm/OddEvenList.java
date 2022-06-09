package com.upane.plearn.algorithm;

/**
 * Description: 奇偶链表
 *
 * @Author:pan
 * @Date:2022/6/8
 */
public class OddEvenList {
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

    public ListNode solution(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode events = head.next;
        // 把链表 指针 重排
        ListNode left = head, right = events;
        while (right != null && right.next != null) {
            left.next = right.next;
            left = left.next;
            right.next = left.next;
            right = right.next;
        }
        left.next = events;
        // 所以返回head
        return head;

    }

    public static void main(String[] args) {
        ListNode myLinkedList6 = new ListNode(6);
        ListNode myLinkedList5 = new ListNode(5, myLinkedList6);
        ListNode myLinkedList4 = new ListNode(4, myLinkedList5);
        ListNode myLinkedList3 = new ListNode(3, myLinkedList4);
        ListNode myLinkedList2 = new ListNode(2, myLinkedList3);
        ListNode myLinkedList1 = new ListNode(1, myLinkedList2);

        OddEvenList removeNthFromEnd = new OddEvenList();
        ListNode listNode = removeNthFromEnd.solution(myLinkedList1);
        System.out.println(listNode);

    }
}
