package com.yangbingdong.algo.basic.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
class RemoveDuplicatesFromSortedArrayTest {

    @Test
    void testRemoveDuplicate1() {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        int[] nums = {1, 2, 2, 2, 3, 4};
        int res = solution.removeDuplicates(nums);
        assertEquals(4, res);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    void testRemoveDuplicate2() {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        int[] nums = {1, 1, 2};
        int res = solution.removeDuplicates(nums);
        assertEquals(2, res);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    void testRemoveDuplicate3() {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int res = solution.removeDuplicates(nums);
        assertEquals(5, res);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    void testRemoveDuplicate4() {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        int[] nums = {1, 1};
        int res = solution.removeDuplicates(nums);
        assertEquals(1, res);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    void testRemoveDuplicate5() {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        int[] nums = {1, 2};
        int res = solution.removeDuplicates(nums);
        assertEquals(2, res);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    void testRemoveDuplicate6() {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        int[] nums = {1, 1, 1};
        int res = solution.removeDuplicates(nums);
        assertEquals(1, res);
        System.out.println(Arrays.toString(nums));
    }


}
