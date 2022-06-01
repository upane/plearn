package com.upane.plearn.algorithm;

/**
 * Description: 删除链表的倒数第 N 个节点
 *
 * <p>
 * <p>
 * 采取双重遍历肯定是可以解决问题的，但题目要求我们一次遍历解决问题，那我们的思路得发散一下。
 * <p>
 * 我们可以设想假设设定了双指针 p 和 q 的话，当 q 指向末尾的 NULL，p 与 q 之间相隔的元素个数为 n 时，那么删除掉 p 的下一个指针就完成了要求。
 * <p>
 * 设置虚拟节点 dummyHead 指向 head
 * 设定双指针 p 和 q，初始都指向虚拟节点 dummyHead
 * 移动 q，直到 p 与 q 之间相隔的元素个数为 n
 * 同时移动 p 与 q，直到 q 指向的为 NULL
 * 将 p 的下一个节点指向下下个节点
 * <p>
 * 作者：cxywushixiong
 * 链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list/solution/dong-hua-tu-jie-leetcode-di-19-hao-wen-ti-shan-chu/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @Author:pan
 * @Date:2022/6/1
 */
public class RemoveNthFromEnd {

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
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

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dump = new ListNode(0, head);
            ListNode slow = dump;
            ListNode fast = head;

            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            ListNode ans = dump.next;
            return ans;
        }
    }
}
