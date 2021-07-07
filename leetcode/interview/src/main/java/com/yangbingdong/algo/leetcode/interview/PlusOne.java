package com.yangbingdong.algo.leetcode.interview;

import java.util.Arrays;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/plus-one/
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        PlusOne solution = new PlusOne();
        int[] ints = solution.plusOne(new int[]{9});
        System.out.println(Arrays.toString(ints));
    }


}
