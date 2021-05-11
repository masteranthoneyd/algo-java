package com.yangbingdong.algo.basic.linklist;

import com.yangbingdong.algo.basic.linklist.MergeTwoSortedListNode.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
class MergeTwoSortedListNodeTest {

    MergeTwoSortedListNode mergeTwoSortedListNode;

    @BeforeEach
    void init() {
        mergeTwoSortedListNode = new MergeTwoSortedListNode();
    }

    @Test
    void testMerge1() {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        l11.next = l12;
        l12.next = new ListNode(4);

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        l21.next = l22;
        l22.next = new ListNode(4);

        ListNode ret = mergeTwoSortedListNode.solution(l11, l21);
        System.out.println(ret);
    }
}
