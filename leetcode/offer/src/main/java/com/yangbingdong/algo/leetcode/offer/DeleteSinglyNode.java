package com.yangbingdong.algo.leetcode.offer;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public class DeleteSinglyNode {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode s = new ListNode(0);
        s.next = head;
        ListNode node = head;
        ListNode prev = s;
        while (node != null) {
            if (node.val == val) {
                prev.next = node.next;
                break;
            }
            prev = node;
            node = node.next;
        }
        return s.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
