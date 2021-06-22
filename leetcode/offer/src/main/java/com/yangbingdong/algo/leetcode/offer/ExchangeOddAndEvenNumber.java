package com.yangbingdong.algo.leetcode.offer;

import java.util.Arrays;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class ExchangeOddAndEvenNumber {

    public int[] exchange(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (isOdd(nums[i])) {
                swap(nums, j++, i);
            }
        }
        return nums;
    }

    private boolean isOdd(int num) {
        return (num & 1) == 1;
    }

    private void swap(int[] nums, int a, int b) {
        if (a == b) {
            return;
        }
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        ExchangeOddAndEvenNumber solution = new ExchangeOddAndEvenNumber();
        int[] nums = {1, 2, 3, 4};
        solution.exchange(nums);
        System.out.println(Arrays.toString(nums));
    }

}
