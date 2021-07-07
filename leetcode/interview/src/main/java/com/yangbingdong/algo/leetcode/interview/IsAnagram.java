package com.yangbingdong.algo.leetcode.interview;

import java.util.Arrays;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class IsAnagram {

    /**
     * 排序法
     */
    public boolean isAnagram2(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return Arrays.equals(sc, tc);
    }

    /**
     * 哈希法
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (--table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsAnagram solution = new IsAnagram();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram("rat", "car"));
        System.out.println(solution.isAnagram("ab", "ba"));
    }

}
