package com.yangbingdong.algo.basic.linklist;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * 检测环形链表, 使用快慢指针, 慢指针每次都一步, 快指针每次走两步
 * 如果有环, 则快慢指针会相遇
 */
public class CircleLinkedChecker {

    public <T> boolean check(SNode<T> n) {
        if (n == null) {
            return false;
        }

        SNode<T> slow = n;
        SNode<T> fast = n;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
