package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/happy-number/
 */
public class IsHappyNum {

    public boolean isHappy(int n) {
        int s = n, f = n;
        do {
            s = sum(s);
            f = sum(sum(f));
        } while (s != f);
        return s == 1;
    }

    private int sum(int n) {
        int add = 0;
        while (n > 0) {
            add += Math.pow(n % 10, 2);
            n /= 10;
        }
        return add;
    }

    public static void main(String[] args) {
        IsHappyNum solution = new IsHappyNum();
        System.out.println(solution.sum(19));
    }
}
