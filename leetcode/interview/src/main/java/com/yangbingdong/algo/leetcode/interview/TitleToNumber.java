package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/excel-sheet-column-number/
 */
public class TitleToNumber {

    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int t = columnTitle.charAt(i) - 'A' + 1;
            res = res * 26 + t;
        }
        return res;
    }

    public static void main(String[] args) {
        TitleToNumber solution = new TitleToNumber();
        System.out.println(solution.titleToNumber("A"));
        System.out.println(solution.titleToNumber("AB"));
    }

}
