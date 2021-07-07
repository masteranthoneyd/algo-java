package com.yangbingdong.algo.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/fizz-buzz/
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        boolean d3, d5;
        for (int i = 1; i <= n; i++) {
            d3 = i % 3 == 0;
            d5 = i % 5 == 0;
            if (d3 && d5) {
                res.add("FizzBuzz");
            } else if (d5) {
                res.add("Buzz");
            } else if (d3) {
                res.add("Fizz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }

}
