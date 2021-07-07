package com.yangbingdong.algo.leetcode.offer;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/three-steps-problem-lcci/
 */
public class WaysToStep {

    public int waysToStep(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        int a = 1, b = 2, c = 4, sum = a + b + c;
        for (int i = 4; i < n; i++) {
            a = b;
            b = c;
            c = sum;
            sum = (((a + b) % 1000000007) + c) % 1000000007;
        }
        return sum;
    }

    public static void main(String[] args) {
        WaysToStep solution = new WaysToStep();
        System.out.println(solution.waysToStep(5));
    }

}
