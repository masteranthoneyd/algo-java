package com.yangbingdong.algo.basic.strmatch;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public class RabinKarp {

    public int indexOf(String main, String pattern) {
        if (main.length() < pattern.length()) {
            return -1;
        }

        int pHashCode = 0;
        int n = pattern.length(), m = main.length();
        for (int i = 0; i < n; i++) {
            pHashCode += pattern.charAt(i) - 'a';
        }

        int mHashCode = 0;
        for (int i = 0; i < n; i++) {
            mHashCode += main.charAt(i) - 'a';
        }
        if (pHashCode == mHashCode && match(main, 0, pattern)) {
            return 0;
        }
        for (int i = n; i < m; i++) {
            mHashCode = mHashCode - (main.charAt(i - n) - 'a') + main.charAt(i) - 'a';
            if (pHashCode == mHashCode && match(main, i - n + 1, pattern)) {
                return i - n + 1;
            }
        }
        return -1;
    }

    private boolean match(String main, int start, String pattern) {
        for (int i = 0; i < pattern.length(); i++) {
            if (main.charAt(start + i) != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
