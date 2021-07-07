package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/sqrtx/
 */
public class MySqrt {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int l = 1, r = x / 2, mid, t;
        while (l < r) {
            mid = l + (r - l) / 2 + 1;
            t = x / mid;
            if (mid > t) {
                r = mid - 1;
            } else if (mid < t) {
                l = mid;
            } else {
                return mid;
            }
        }
        return l;
    }

}
