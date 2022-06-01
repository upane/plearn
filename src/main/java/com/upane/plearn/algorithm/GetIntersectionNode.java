package com.upane.plearn.algorithm;

/**
 * Description: 相交链表
 * <p>
 * 弄这么多字也没讲明白。若相交，链表A： a+c, 链表B : b+c. a+c+b+c = b+c+a+c 。则会在公共处c起点相遇。若不相交，a +b = b+a 。因此相遇处是NULL
 * 可以理解成两个人速度一致， 走过的路程一致。那么肯定会同一个时间点到达终点。如果到达终点的最后一段路两人都走的话，那么这段路上俩人肯定是肩并肩手牵手的。 nb
 *
 * @Author:pan
 * @Date:2022/6/1
 */
public class GetIntersectionNode {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode aa = headA, bb = headB;
            while (aa != bb) {
                aa = aa == null ? headB : aa.next;
                bb = bb == null ? headA : bb.next;
            }
            return aa;
        }
    }
}
