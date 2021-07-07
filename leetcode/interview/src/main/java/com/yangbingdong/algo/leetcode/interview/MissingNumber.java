package com.yangbingdong.algo.leetcode.interview;

import java.util.Arrays;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/missing-number-lcci/
 * https://leetcode-cn.com/problems/missing-number/
 */
public class MissingNumber {

    /**
     * 位移法
     */
    public int missingNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i] ^ i;
        }
        return ans ^ nums.length;
    }


    /**
     * 排序法
     */
    public int missingNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 数学法, 等差数列求和, 再减去全部, 得出就是缺失的
     */
    public int missingNumber3(int[] nums) {
        int count = (1 + nums.length) * nums.length / 2;
        for (int num : nums) {
            count -= num;
        }
        return count;
    }

}
