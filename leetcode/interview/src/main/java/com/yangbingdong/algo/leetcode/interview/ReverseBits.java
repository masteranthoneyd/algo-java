package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/reverse-bits/
 */
public class ReverseBits {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int t = (n >> i) & 1;
            res = res | (t << (31 - i));
        }
        return res;
    }


}
