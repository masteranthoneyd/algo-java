package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/roman-to-integer/
 */
public class RomanToInt {

    public static void main(String[] args) {
        RomanToInt solution = new RomanToInt();
        System.out.println(solution.romanToInt("IV"));
    }

    public int romanToInt(String s) {
        int pre = getValue(s.charAt(0)), sum = 0, value;
        for (int i = 1; i < s.length(); i++) {
            value = getValue(s.charAt(i));
            if (pre < value) {
                sum -= pre;
            } else {
                sum += pre;
            }
            pre = value;
        }
        sum += pre;
        return sum;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
