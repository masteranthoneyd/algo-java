package com.yangbingdong.algo.basic.linklist;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * LeetCode 876 https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class MiddleOfLinkedList {

    /**
     * 使用快慢指针, 快指针每次走两步, 慢指针每次走一步
     * 快指针的速度是慢指针的两倍, 所以当快指针到达终点时慢指针恰好在中间位置
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
