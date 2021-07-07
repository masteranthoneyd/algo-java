package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        ListNode s = head, f = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                return true;
            }
        }
        return false;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
