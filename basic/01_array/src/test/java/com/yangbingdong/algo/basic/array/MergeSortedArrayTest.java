package com.yangbingdong.algo.basic.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
class MergeSortedArrayTest {

    @Test
    void testMerge() {
        // nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        // [1,2,2,3,5,6]
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        mergeSortedArray.merge(nums1, 3, nums2, 3);
        Assertions.assertArrayEquals(nums1, new int[]{1, 2, 2, 3, 5, 6});
    }
}
