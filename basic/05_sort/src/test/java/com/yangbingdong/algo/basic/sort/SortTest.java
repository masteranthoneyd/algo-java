package com.yangbingdong.algo.basic.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public class SortTest {

    Sort sort;
    int numsListSize = 50;
    int numsLength = 20;

    @Test
    void testSort() {
        List<int[]> numsList = produceRandomNums(numsListSize, numsLength);
        for (int[] nums : numsList) {
            int[] res = this.sort.sort(Arrays.copyOf(nums, nums.length));

            Arrays.sort(nums);
            Assertions.assertArrayEquals(nums, res);
        }
    }

    List<int[]> produceRandomNums(int numsListSize, int numsLength) {
        Random random = new Random();
        List<int[]> numsList = new ArrayList<>(numsListSize);
        for (int i = 0; i < numsListSize; i++) {
            int[] nums = new int[numsLength];
            for (int j = 0; j < numsLength; j++) {
                nums[j] = random.nextInt(numsLength);
            }
            numsList.add(nums);
        }
        return numsList;
    }

}
