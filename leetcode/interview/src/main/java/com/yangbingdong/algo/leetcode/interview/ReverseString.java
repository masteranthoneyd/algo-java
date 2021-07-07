package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/reverse-string/
 */
public class ReverseString {

    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        char t;
        while (l < r) {
            t = s[l];
            s[l] = s[r];
            s[r] = t;
            l++;
            r--;
        }
    }

}
