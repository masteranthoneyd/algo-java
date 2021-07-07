package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/delete-middle-node-lcci/
 */
public class DeleteMiddleNode {

    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode s = node, f = node, pre = null;
        while (f.next != null && f.next.next != null) {
            pre = s;
            s = s.next;
            f = f.next.next;
        }
        pre.next = s.next;
        s.next = null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
