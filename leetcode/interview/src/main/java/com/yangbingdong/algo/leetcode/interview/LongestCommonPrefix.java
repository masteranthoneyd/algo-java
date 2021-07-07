package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        LongestCommonPrefix solution = new LongestCommonPrefix();
        System.out.println(solution.longestCommonPrefix(strs));

        strs = new String[]{"dog", "racecar", "car"};
        System.out.println(solution.longestCommonPrefix(strs));

        strs = new String[]{"d"};
        System.out.println(solution.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length ==0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        boolean match;
        while (true) {
            if (index >= strs[0].length()) {
                break;
            }
            match = true;
            for (int i = 0; i < strs.length - 1; i++) {
                if (index >= strs[i + 1].length() || strs[i].charAt(index) != strs[i + 1].charAt(index)) {
                    match = false;
                    break;
                }
            }
            if (!match) {
                break;
            }
            sb.append(strs[0].charAt(index));
            index++;
        }
        return sb.toString();
    }
}
