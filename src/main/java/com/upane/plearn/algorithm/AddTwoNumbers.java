package com.upane.plearn.algorithm;

/**
 * Description: 链表两数相加
 * 自己写出来辣，debug 天下第一
 * 需要注意在两个链表结束后，为1的 进位
 *
 * @Author:pan
 * @Date:2022/6/9
 */
public class AddTwoNumbers {
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

    public ListNode solution(ListNode one, ListNode two) {
        ListNode res = new ListNode(0);
        ListNode tempp = res;
        int temp = 0;
        while (one != null || two != null) {
            int tempOne = one == null ? 0 : one.val;
            int tempTwo = two == null ? 0 : two.val;
            if (temp > 0) {
                temp = tempOne + tempTwo + 1;
            } else {
                temp = tempOne + tempTwo;
            }
            if (temp >= 10) {
                ListNode tempNum = new ListNode(temp % 10);
                tempp.next = tempNum;
                tempp = tempp.next;
                temp = 1;
            } else {
                ListNode tempNum = new ListNode(temp);
                tempp.next = tempNum;
                tempp = tempp.next;
                temp = 0;
            }
            one = one == null ? null : one.next;
            two = two == null ? null : two.next;
        }

        if (temp > 0) {
            ListNode tempNum = new ListNode(1);
            tempp.next = tempNum;
        }
        return res.next;

    }

    public static void main(String[] args) {
        ListNode myLinkedList6 = new ListNode(9);
        ListNode myLinkedList5 = new ListNode(9, myLinkedList6);
        ListNode myLinkedList4 = new ListNode(9, myLinkedList5);
        ListNode myLinkedList3 = new ListNode(9, myLinkedList4);
        ListNode myLinkedList2 = new ListNode(9, myLinkedList3);
        ListNode myLinkedList1 = new ListNode(9, myLinkedList2);

        AddTwoNumbers removeNthFromEnd = new AddTwoNumbers();
        ListNode solution = removeNthFromEnd.solution(myLinkedList5, myLinkedList6);
        System.out.println(solution);

    }

}
