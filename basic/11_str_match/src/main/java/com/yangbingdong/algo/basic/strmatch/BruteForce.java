package com.yangbingdong.algo.basic.strmatch;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * 暴力匹配法
 */
public class BruteForce {

    public int indexOf(String main, String pattern) {
        int m = main.length(), n = pattern.length();
        boolean match;
        for (int i = 0; i < m - n; i++) {
            match = true;
            for (int j = 0; j < n; j++) {
                if (main.charAt(j + i) != pattern.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return i;
            }
        }
        return -1;
    }
}
