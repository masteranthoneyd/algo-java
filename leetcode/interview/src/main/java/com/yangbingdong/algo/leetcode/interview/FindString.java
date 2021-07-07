package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/sparse-array-search-lcci/
 */
public class FindString {

    public int findString(String[] words, String s) {
        for (int i = 0; i < words.length; i++) {
            if (s.equals(words[i])) {
                return i;
            }
        }
        return -1;
    }

}
