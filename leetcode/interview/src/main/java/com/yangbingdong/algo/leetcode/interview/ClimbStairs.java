package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int a = 1, b = 2, sum = a + b;
        for (int i = 3; i < n; i++) {
            a = b;
            b = sum;
            sum = a + b;
        }
        return sum;
    }

}
