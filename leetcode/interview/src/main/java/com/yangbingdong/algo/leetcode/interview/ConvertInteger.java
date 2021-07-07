package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/convert-integer-lcci/
 */
public class ConvertInteger {

    public int convertInteger(int A, int B) {
        int i = A ^ B;
        return Integer.bitCount(i);
    }

    public static void main(String[] args) {
        ConvertInteger solution = new ConvertInteger();
        System.out.println(solution.convertInteger(29, 15));
        System.out.println(solution.convertInteger(1, 2));
    }
}
