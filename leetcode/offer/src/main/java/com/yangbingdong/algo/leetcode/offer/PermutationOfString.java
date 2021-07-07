package com.yangbingdong.algo.leetcode.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 */
public class PermutationOfString {

    private char[] chars;

    public String[] permutation(String s) {
        chars = s.toCharArray();
        List<String> res = new ArrayList<>();
        permutationInner(res, 0);
        return res.toArray(new String[0]);
    }

    private void permutationInner(List<String> res, int first) {
        if (first == chars.length) {
            String s = new String(chars);
            res.add(s);
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = first; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            swap(first, i);
            permutationInner(res, first + 1);
            swap(first, i);
        }
    }

    private void swap(int a, int b) {
        if (a == b) {
            return;
        }
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }

}
