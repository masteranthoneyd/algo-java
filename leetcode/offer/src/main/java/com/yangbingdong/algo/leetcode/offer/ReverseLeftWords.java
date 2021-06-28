package com.yangbingdong.algo.leetcode.offer;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        ReverseLeftWords solution = new ReverseLeftWords();
        String res = solution.reverseLeftWords(s, 2);
        System.out.println(res);
    }

}
