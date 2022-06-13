package com.upane.plearn.algorithm;

import java.util.HashMap;

/**
 * Description: 复制带随机指针的链表
 *
 * @Author:pan
 * @Date:2022/6/13
 */
public class CopyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node solution(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        HashMap<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get((cur.next));
            map.get(cur).random = map.get((cur.random));
            cur = cur.next;

        }
        return map.get(head);

    }
}
