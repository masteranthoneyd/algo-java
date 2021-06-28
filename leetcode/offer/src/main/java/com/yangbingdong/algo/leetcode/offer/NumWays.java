package com.yangbingdong.algo.leetcode.offer;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public class NumWays {

    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int a = 1, b = 1, sum = a + b;
        for (int i = 2; i < n; i++) {
            a = b;
            b = sum;
            sum = (a + b) % 1000000007;
        }
        return sum;
    }

    public static void main(String[] args) {
        NumWays solution = new NumWays();
        int i = solution.numWays(7);
        System.out.println(i);
    }
}
