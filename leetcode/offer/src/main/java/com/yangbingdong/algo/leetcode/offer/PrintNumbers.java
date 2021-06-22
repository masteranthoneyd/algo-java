package com.yangbingdong.algo.leetcode.offer;

import java.util.Arrays;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 */
public class PrintNumbers {

    public int[] printNumbers(int n) {
        int max = 10;
        for (int i = 0; i < n - 1; i++) {
            max = max * 10;
        }
        int[] nums = new int[max - 1];
        for (int i = 1; i < max; i++) {
            nums[i - 1] = i;
        }
        return nums;
    }

    public static void main(String[] args) {
        PrintNumbers solution = new PrintNumbers();
        int[] nums = solution.printNumbers(2);
        System.out.println(Arrays.toString(nums));

    }
}
