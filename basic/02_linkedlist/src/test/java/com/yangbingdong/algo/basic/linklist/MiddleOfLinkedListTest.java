package com.yangbingdong.algo.basic.linklist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
class MiddleOfLinkedListTest {

    MiddleOfLinkedList middleOfLinkedList;

    @BeforeEach
    void init() {
        middleOfLinkedList = new MiddleOfLinkedList();
    }

    @Test
    void testMiddleNode1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode ret = middleOfLinkedList.middleNode(n1);
        System.out.println(ret);
    }

    @Test
    void testMiddleNode2() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode ret = middleOfLinkedList.middleNode(n1);
        System.out.println(ret);
    }

    @Test
    void testMiddleNode3() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;

        ListNode ret = middleOfLinkedList.middleNode(n1);
        System.out.println(ret);
    }


}
