package com.yangbingdong.algo.leetcode.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            Integer[] t = new Integer[i + 1];
            t[0] = t[i] = 1;
            for (int j = 1; j < i; j++) {
                t[j] = res.get(i - 1).get(j) + res.get(i - 1).get(j - 1);
            }
            res.add(Arrays.asList(t));
        }
        return res;
    }

    public static void main(String[] args) {
        PascalsTriangle solution = new PascalsTriangle();
        List<List<Integer>> generate = solution.generate(5);
        for (List<Integer> integers : generate) {
            System.out.println(Arrays.toString(integers.toArray(new Integer[0])));
        }
    }
}
