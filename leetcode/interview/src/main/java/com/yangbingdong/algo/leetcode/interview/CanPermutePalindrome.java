package com.yangbingdong.algo.leetcode.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/palindrome-permutation-lcci/
 */
public class CanPermutePalindrome {

    public static void main(String[] args) {
        CanPermutePalindrome solution = new CanPermutePalindrome();
        System.out.println(solution.canPermutePalindrome("code"));
        System.out.println(solution.canPermutePalindrome("tactcoa"));
        System.out.println(solution.canPermutePalindrome("AaBb//a"));
    }

    public boolean canPermutePalindrome(String s) {
        long lo = 0, hi = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > 63) {
                hi ^= 1L << s.charAt(i);
            } else {
                lo ^= 1L << s.charAt(i);
            }
        }
        return Long.bitCount(lo) + Long.bitCount(hi) <= 1;
    }

    /**
     * 哈希法
     */
    public boolean canPermutePalindrome1(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i))) {
                set.remove(s.charAt(i));
            }
        }
        return set.size() <= 1;
    }

}
