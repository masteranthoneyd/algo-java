package com.yangbingdong.algo.leetcode.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/single-number/
 */
public class SingleNumber {

    /**
     * 哈希法
     */
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                set.remove(nums[i]);
            }
        }
        return set.toArray(new Integer[0])[0];
    }

    /**
     * 排序法
     */
    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[++i]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    /**
     * 位移消除法 a ^ a = 0, a ^ 0 = a => a ^ a ^ b = b
     */
    public int singleNumber3(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] ^= nums[i - 1];
        }
        return nums[nums.length - 1];
    }

}
