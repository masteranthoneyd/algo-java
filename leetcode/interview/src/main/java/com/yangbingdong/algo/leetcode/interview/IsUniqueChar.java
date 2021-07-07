package com.yangbingdong.algo.leetcode.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/is-unique-lcci
 */
public class IsUniqueChar {

    /**
     * 位运算法
     */
    public boolean isUnique(String astr) {
        if (astr.length() > 0) {
            int bools = 0, index;
            for (int i = 0; i < astr.length(); i++) {
                index = 1 << (astr.charAt(i) - 'a');
                if ((bools & index) == 0) {
                    bools |= index;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 哈希法
     */
    public boolean isUnique2(String astr) {
        if (astr.length() > 0) {
            Set<Character> set = new HashSet<>(astr.length());
            for (int i = 0; i < astr.length(); i++) {
                if (!set.add(astr.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char b = 'b';
        System.out.println(b - 'a');
    }
}
