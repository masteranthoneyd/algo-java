package com.yangbingdong.algo.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 */
public class FindContinuousSequence {

    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 1, sum = 0;
        List<int[]> res = new ArrayList<>();
        while (i <= target / 2) {
            if (sum < target) {
                sum += j;
                j++;
            } else if (sum > target) {
                sum -= i;
                i++;
            } else {
                int[] r = new int[j - i];
                for (int k = i; k < j; k++) {
                    r[k - i] = k;
                }
                res.add(r);
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
