package com.yangbingdong.algo.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 */
public class LengthOfLongestSubstring {


    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0, left = 0;
        char c;
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            // 这里有两种情况, 1. map 没有 c, 2. map 中存有之前一样的 c, 比如 abba 这种情况
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }

}
