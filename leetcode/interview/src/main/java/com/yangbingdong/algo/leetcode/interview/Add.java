package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/add-without-plus-lcci/
 */
public class Add {

    public int add(int a, int b) {
        int temp;
        while (b != 0) {
            temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }

}
