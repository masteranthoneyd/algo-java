package com.yangbingdong.algo.basic.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
        System.out.println(Arrays.toString(nums1));
        Assertions.assertArrayEquals(nums1, new int[]{1, 2, 2, 3, 5, 6});
    }

    @Test
    void testMerge2() {
        // nums1 = [1], m = 1, nums2 = [], n = 0
        // [1]
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] nums1 = {1};
        int[] nums2 = {};
        mergeSortedArray.merge(nums1, 1, nums2, 0);
        System.out.println(Arrays.toString(nums1));
        Assertions.assertArrayEquals(nums1, new int[]{1});
    }

    @Test
    void testMerge3() {
        // nums1 = [0], m = 0, nums2 = [1], n = 1
        // [1]
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] nums1 = {0};
        int[] nums2 = {1};
        mergeSortedArray.merge(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
        Assertions.assertArrayEquals(nums1, new int[]{1});
    }

    @Test
    void testMerge4() {
        // nums1 = [2, 0], m = 1, nums2 = [1], n = 1
        // [1]
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] nums1 = {2, 0};
        int[] nums2 = {1};
        mergeSortedArray.merge(nums1, 1, nums2, 1);
        System.out.println(Arrays.toString(nums1));
        Assertions.assertArrayEquals(nums1, new int[]{1, 2});
    }

    @Test
    void testMerge5() {
        // nums1 = [1,2,3,0,0,0], m = 3, nums2 = [4,5,6], n = 3
        // [1]
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {4, 5, 6};
        mergeSortedArray.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
        Assertions.assertArrayEquals(nums1, new int[]{1, 2, 3, 4, 5, 6});
    }

    @Test
    void testMerge6() {
        // nums1 = [0,0,3,0,0,0,0,0,0], m = 3, nums = [-1,1,1,1,2,3], n = 6
        // [-1,0,0,1,1,1,2,3,3]
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] nums1 = {0, 0, 3, 0, 0, 0, 0, 0, 0};
        int[] nums2 = {-1, 1, 1, 1, 2, 3};
        mergeSortedArray.merge(nums1, 3, nums2, 6);
        System.out.println(Arrays.toString(nums1));
        Assertions.assertArrayEquals(nums1, new int[]{-1, 0, 0, 1, 1, 1, 2, 3, 3});
    }
}
