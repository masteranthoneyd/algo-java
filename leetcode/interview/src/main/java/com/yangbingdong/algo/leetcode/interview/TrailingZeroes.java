package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 */
public class TrailingZeroes {

    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }


    /**
     * 该方法会超时
     */
    public int trailingZeroes2(int n) {
        long t = 1;
        for (int i = 0; i < n; i++) {
            t = t * (i + 1);
        }
        int count = 0;
        while (t > 0) {
            if (t % 10 == 0) {
                count++;
                t = t / 10;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TrailingZeroes solution = new TrailingZeroes();
        System.out.println(solution.trailingZeroes(13));
    }

}
