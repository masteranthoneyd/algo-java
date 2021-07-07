package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/compress-string-lcci/
 */
public class CompressString {

    public static void main(String[] args) {
        CompressString solution = new CompressString();
        System.out.println(solution.compressString("aabcccccaaa"));
    }

    public String compressString(String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int count = 1;
            while (++i < S.length() && S.charAt(i) == c) {
                count++;
            }
            i--;
            sb.append(c);
            sb.append(count);
        }
        return sb.length() >= S.length() ? S : sb.toString();
    }

}
