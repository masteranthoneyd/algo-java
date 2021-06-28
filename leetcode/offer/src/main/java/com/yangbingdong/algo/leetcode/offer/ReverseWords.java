package com.yangbingdong.algo.leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 */
public class ReverseWords {

    public String reverseWords(String s) {

        Deque<String> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            while (i < chars.length && chars[i] != ' ') {
                sb.append(chars[i++]);
            }
            stack.push(sb.toString());
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            if (!stack.isEmpty()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}
