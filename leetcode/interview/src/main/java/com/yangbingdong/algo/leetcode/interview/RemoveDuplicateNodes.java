package com.yangbingdong.algo.leetcode.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 */
public class RemoveDuplicateNodes {

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode node = head;
        while (node.next != null) {
            if (!set.add(node.next.val)) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
