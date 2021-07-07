package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
 */
public class KthToLastOfListNode {

    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            head = head.next;
        }
        return head.val;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
