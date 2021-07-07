package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/reverse-bits-lcci/
 */
public class CountReverseBits {

    public int reverseBits(int num) {
        int maxSize = 0, tempSize = 0, lastZero = -1;
        for (int i = 0; i < 32; i++) {
            int bit = num & (1 << 31 - i);
            if (bit != 0) {
                tempSize++;
            } else {
                tempSize = i - lastZero;
                lastZero = i;
            }
            maxSize = Math.max(maxSize, tempSize);
        }
        return maxSize;
    }

}
