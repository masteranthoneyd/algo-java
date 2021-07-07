package com.yangbingdong.algo.leetcode.interview;

import java.util.Arrays;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/count-primes
 */
public class CountPrimes {

    public static void main(String[] args) {
        CountPrimes solution = new CountPrimes();
        System.out.println(solution.countPrimes(10));
        System.out.println(solution.countPrimes(4));
    }

    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i]) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
        }
        return ans;
    }



    /**
     * 暴力法, 超时
     */
    public int countPrimes2(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrimes(int n) {
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
