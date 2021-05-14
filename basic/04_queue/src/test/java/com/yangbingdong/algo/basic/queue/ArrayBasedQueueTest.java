package com.yangbingdong.algo.basic.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
class ArrayBasedQueueTest {

    Queue<String> queue;

    @BeforeEach
    void init() {
        queue = new ArrayBasedQueue<>(3);
    }

    @Test
    void testEnqueue() {
        assertEquals(0, queue.size());
        queue.enqueue("A");
        assertEquals(1, queue.size());
    }

    @Test
    void testDequeue() {
        assertNull(queue.dequeue());
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println(queue);
        assertEquals(3, queue.size());
        assertEquals("A", queue.dequeue());
        assertEquals(2, queue.size());
    }

    @Test
    void shouldEnqueueFail_whenFull() {
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        boolean enqueueRet = queue.enqueue("D");
        assertFalse(enqueueRet);
        assertEquals(3, queue.size());
    }

    @Test
    void shouldMove_whenNextEqualsCapacity() {
        ArrayBasedQueue<Object> queue = new ArrayBasedQueue<>(3);
        queue = Mockito.spy(queue);
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        assertEquals("A", queue.dequeue());
        assertEquals(2, queue.size());

        boolean enqueueRet = queue.enqueue("D");
        Mockito.verify(queue).move();
        assertTrue(enqueueRet);
        assertEquals(3, queue.size());
        System.out.println(queue);
    }




}
