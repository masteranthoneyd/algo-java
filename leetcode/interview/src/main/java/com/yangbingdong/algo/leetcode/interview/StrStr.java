package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/implement-strstr/
 */
public class StrStr {

    public int strStr(String haystack, String needle) {
        int sourceLength = haystack.length(), targetLength = needle.length(), si;
        boolean matched;
        for (int i = 0; i <= sourceLength - targetLength; i++) {
            matched = true;
            si = i;
            for (int ti = 0; ti < targetLength; ti++) {
                if (needle.charAt(ti) != haystack.charAt(si++)) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                return i;
            }
        }
        return -1;
    }

}
