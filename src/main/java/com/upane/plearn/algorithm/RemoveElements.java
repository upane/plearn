package com.upane.plearn.algorithm;

/**
 * Description:
 *
 * @Author:pan
 * @Date:2022/6/6
 */
public class RemoveElements {


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

    public ListNode removeElements(ListNode head, int val) {
        ListNode tmp = new ListNode(0, head);
        // 用于缓存 链表
        ListNode res = tmp;
        while (res.next != null) {
            if (res.next.val == val) {
                // 改变的都为同一个对象（也就是同一个存储地址，只是指针不同）
                // res改变 temp也会改变 head也会改变
                res.next = res.next.next;
            } else {
                res = res.next;
            }
        }
        return tmp.next;
    }

    public static void main(String[] args) {
        ListNode myLinkedList6 = new ListNode(6);
        ListNode myLinkedList5 = new ListNode(5, myLinkedList6);
        ListNode myLinkedList4 = new ListNode(4, myLinkedList5);
        ListNode myLinkedList3 = new ListNode(3, myLinkedList4);
        ListNode myLinkedList2 = new ListNode(5, myLinkedList3);
        ListNode myLinkedList1 = new ListNode(1, myLinkedList2);

        RemoveElements removeNthFromEnd = new RemoveElements();
        ListNode listNode = removeNthFromEnd.removeElements(myLinkedList1, 5);
        System.out.println(listNode);

    }

}
