package com.yangbingdong.algo.basic.linklist;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
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
