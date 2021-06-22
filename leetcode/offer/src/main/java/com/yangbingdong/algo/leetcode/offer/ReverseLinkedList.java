package com.yangbingdong.algo.leetcode.offer;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode next = cur.next;
        ListNode prev = null;
        while (next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }
        cur.next = prev;
        return cur;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        ListNode head = n;
        n.next = new ListNode(2);
        n = n.next;
        n.next = new ListNode(3);
        n = n.next;
        n.next = new ListNode(4);
        n = n.next;
        n.next = new ListNode(5);
        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode listNode = solution.reverseList(head);
        System.out.println(listNode.val);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
