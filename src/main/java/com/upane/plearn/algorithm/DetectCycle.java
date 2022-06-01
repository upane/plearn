package com.upane.plearn.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 环形链表  入环值
 * 作者：白鲨码农
 * 链接：https://leetcode.cn/leetbook/read/linked-list/jjhf6/?discussion=fy1wvC
 * 来源：力扣（LeetCode）
 *
 * @Author:pan
 * @Date:2022/5/30
 */
public class DetectCycle {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode detectCycleMath(ListNode head) {
        ListNode slow = head, fast = head;
        //快慢指针相遇
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //第一次相遇退出循环
            if (slow == fast) break;
        }
        //判断是否有环
        if (fast == null || fast.next == null) return null;
        //有环则将fast移动至head并移动S2距离
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }
}
