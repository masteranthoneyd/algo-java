package com.yangbingdong.algo.basic.linklist;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * LeetCode 21 https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedListNode {

    public ListNode solution(ListNode l1, ListNode l2) {
        ListNode s = new ListNode(0);
        ListNode n = s;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                n.next = l1;
                l1 = l1.next;
            } else {
                n.next = l2;
                l2 = l2.next;
            }
            n = n.next;
        }
        if (l1 != null) {
            n.next = l1;
        }
        if (l2 != null) {
            n.next = l2;
        }
        return s.next;
    }
}
