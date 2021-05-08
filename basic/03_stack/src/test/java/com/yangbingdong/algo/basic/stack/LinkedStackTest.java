package com.yangbingdong.algo.basic.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
class LinkedStackTest {

    Stack<String> stack;

    @BeforeEach
    void init() {
        stack = new LinkedStack<>();
    }

    @Test
    void testPushAndPop() {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        System.out.println(stack.toString());
        assertEquals(stack.peek(), "D");
        assertEquals(stack.pop(), "D");
        assertEquals(stack.pop(), "C");
        assertEquals(stack.pop(), "B");
        assertEquals(stack.peek(), "A");
        assertEquals(stack.pop(), "A");
        assertNull(stack.pop());
        assertNull(stack.peek());
    }

    @Test
    void testSizeAndIsEmpty() {
        stack.push("A");
        stack.push("B");
        assertEquals(stack.size(), 2);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertEquals(stack.size(), 1);
        stack.pop();
        assertEquals(stack.size(), 0);
        Assertions.assertTrue(stack.isEmpty());
    }

}
