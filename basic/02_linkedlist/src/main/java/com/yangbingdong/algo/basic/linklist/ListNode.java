package com.yangbingdong.algo.basic.linklist;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public class ListNode {

    int val;
    ListNode next;

    @Override
    public String toString() {
        ListNode n = this;
        StringBuilder sb = new StringBuilder();
        while (n != null) {
            sb.append(n.val);
            n = n.next;
            if (n != null) {
                sb.append(" -> ");
            }
        }
        return sb.toString();
    }

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

