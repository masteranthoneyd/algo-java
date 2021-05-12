package com.yangbingdong.algo.basic.linklist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
class RemoveNthNodeFromEndOfListTest {


    RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList;

    @BeforeEach
    void inti() {
        removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
    }


    @Test
    void testRemove1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode listNode = removeNthNodeFromEndOfList.removeNthFromEnd(n1, 2);
        System.out.println(listNode);
    }

    @Test
    void testRemove2() {
        ListNode n1 = new ListNode(1);

        ListNode listNode = removeNthNodeFromEndOfList.removeNthFromEnd(n1, 1);
        System.out.println(listNode);
    }

    @Test
    void testRemove3() {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);

        ListNode listNode = removeNthNodeFromEndOfList.removeNthFromEnd(n1, 1);
        System.out.println(listNode);
    }

    @Test
    void testRemove4() {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);

        ListNode listNode = removeNthNodeFromEndOfList.removeNthFromEnd(n1, 2);
        System.out.println(listNode);
    }


}
