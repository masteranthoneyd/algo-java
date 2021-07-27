package com.yangbingdong.algo.basic.heap;

import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
class HeapTest {

    @Test
    void testHeap() {
        int[] nums = {0, 33, 17, 21, 16, 13, 15, 9, 5, 6, 7, 8, 1, 2};
        Heap heap = new Heap(nums);
        System.out.println(heap.peek());
    }

    @Test
    void testAddAndRemove() {
        Heap heap = new Heap(5);
        heap.insert(1);
        heap.insert(7);
        heap.insert(9);
        heap.insert(3);
        heap.insert(2);
        System.out.println(heap.removeMax());
        System.out.println(heap.removeMax());
        System.out.println(heap.removeMax());
    }

}
