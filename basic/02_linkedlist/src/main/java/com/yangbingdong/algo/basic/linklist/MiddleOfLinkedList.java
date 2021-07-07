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

    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(5);
        a.next = b;
        ListNode c = new ListNode(1);
        b.next = c;
        ListNode d = new ListNode(9);
        c.next = d;
        MiddleOfLinkedList solution = new MiddleOfLinkedList();
        ListNode middleNode = solution.middleNode(a);
        System.out.println(middleNode.val);
    }
}
