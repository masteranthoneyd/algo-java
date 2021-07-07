package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/diving-board-lcci/
 */
public class DivingBoard {

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{longer * k};
        }
        int[] res = new int[k + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = shorter * (k - i) + longer * i;
        }
        return res;
    }

}
