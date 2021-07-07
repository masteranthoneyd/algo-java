package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/power-of-three/
 */
public class IsPowerOfThree {

    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        IsPowerOfThree solution = new IsPowerOfThree();
        System.out.println(solution.isPowerOfThree(9));
        System.out.println(solution.isPowerOfThree(3));
        System.out.println(solution.isPowerOfThree(0));
        System.out.println(solution.isPowerOfThree(45));
    }

}
