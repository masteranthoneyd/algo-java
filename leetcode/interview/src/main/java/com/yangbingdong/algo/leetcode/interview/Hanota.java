package com.yangbingdong.algo.leetcode.interview;

import java.util.List;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/hanota-lcci/
 */
public class Hanota {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanota(A.size(), A, B, C);
    }

    private void hanota(int size, List<Integer> a, List<Integer> b, List<Integer> c) {
        if (size == 1) {
            c.add(0, a.remove(0));
            return;
        }
        hanota(size - 1, a, c, b);
        c.add(0, a.remove(0));
        hanota(size - 1, b, a, c);
    }
}
