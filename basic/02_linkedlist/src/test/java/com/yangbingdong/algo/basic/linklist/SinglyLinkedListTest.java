package com.yangbingdong.algo.basic.linklist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
class SinglyLinkedListTest {

    SinglyLinkedList<String> linkedList;

    @BeforeEach
    void init() {
        linkedList = new SinglyLinkedList<>();
    }

    @Test
    void testAdd() {
        linkedList.add("A");
        linkedList.add("B");
        assertEquals("B", linkedList.getFirst());
        assertEquals(2, linkedList.getSize());
        linkedList.add("C");
        linkedList.add("D");
        assertEquals("D", linkedList.getFirst());
        assertEquals(4, linkedList.getSize());
        System.out.println(linkedList);
    }

    @Test
    void testGetFirst() {
        assertNull(linkedList.getFirst());
        assertEquals(0, linkedList.getSize());
        linkedList.add("D");
        assertEquals("D", linkedList.getFirst());
        linkedList.add("A");
        assertEquals("A", linkedList.getFirst());
    }

    @Test
    void testAddLast() {
        linkedList.addLast("A");
        linkedList.addLast("B");
        linkedList.addLast("C");
        linkedList.addLast("D");
        assertEquals(4, linkedList.getSize());
        assertEquals("A", linkedList.getFirst());
        System.out.println(linkedList);
    }

    @Test
    void testRemoveFirstByValue() {
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        assertNull(linkedList.removeFirstByValue("D"));
        assertEquals("B", linkedList.removeFirstByValue("B"));
        System.out.println(linkedList);

        linkedList.removeFirstByValue("C");
        assertEquals("A", linkedList.getFirst());

        linkedList.add("C");
        linkedList.removeFirstByValue("A");
        linkedList.removeFirstByValue("C");
        assertEquals(0, linkedList.getSize());
    }

    @Test
    void testClean() {
        linkedList.add("A");
        linkedList.add("B");
        linkedList.clean();
        assertNull(linkedList.getFirst());
        assertEquals(0, linkedList.getSize());
    }

}
