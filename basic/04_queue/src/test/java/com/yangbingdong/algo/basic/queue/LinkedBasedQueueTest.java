package com.yangbingdong.algo.basic.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
class LinkedBasedQueueTest {

    Queue<String> queue;

    @BeforeEach
    void init() {
        queue = new LinkedBasedQueue<>();
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


}
