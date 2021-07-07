package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/string-rotation-lcci/
 */
public class IsFlipedString {

    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }
}
