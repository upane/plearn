package com.upane.plearn.algorithm;

/**
 * Description: 回文判断
 * 快慢指针+缓存指针反转前半段，最后为依次比对
 *
 * @Author:pan
 * @Date:2022/6/9
 */
public class IsPalindrome {

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

    public boolean solution(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        // 功能：反转前半个链表 和后半个 比较  牛
        // fast.next != null 这个为判断奇偶链表
        while (fast != null && fast.next != null) {
            // 记录当前值
            pre = slow;
            slow = slow.next;
            // 快指针 用于遍历结束
            fast = fast.next.next;
            // 指向前一个缓存的指针
            pre.next = prepre;
            // 将指针缓存
            prepre = pre;
        }
        // 处理为奇数 数据时候
        if (fast != null) {
            slow = slow.next;
        }

        // 这步为依次比对 容易看懂
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode myLinkedList6 = new ListNode(6);
        ListNode myLinkedList5 = new ListNode(5, myLinkedList6);
        ListNode myLinkedList4 = new ListNode(4, myLinkedList5);
        ListNode myLinkedList3 = new ListNode(4, myLinkedList4);
        ListNode myLinkedList2 = new ListNode(5, myLinkedList3);
        ListNode myLinkedList1 = new ListNode(6, myLinkedList2);

        IsPalindrome removeNthFromEnd = new IsPalindrome();
        boolean solution = removeNthFromEnd.solution(myLinkedList2);
        System.out.println(solution);

    }
}
