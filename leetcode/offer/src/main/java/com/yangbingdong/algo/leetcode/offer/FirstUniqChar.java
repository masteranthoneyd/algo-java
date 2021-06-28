package com.yangbingdong.algo.leetcode.offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class FirstUniqChar {

    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            map.compute(c, (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return v + 1;
            });
        }
        for (Map.Entry<Character, Integer> en : map.entrySet()) {
            if (en.getValue() == 1) {
                return en.getKey();
            }
        }
        return ' ';
    }

}
