package com.yangbingdong.algo.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/check-permutation-lcci/
 */
public class CheckPermutation {

    /**
     * 抵消法
     */
    public boolean CheckPermutation(String s1, String s2) {
        List<Character> list = new ArrayList<>();
        for (char c : s1.toCharArray()) {
            list.add(c);
        }
        for (char c : s2.toCharArray()) {
            if (!list.remove(Character.valueOf(c))) {
                return false;
            }
        }
        return list.isEmpty();
    }
}
