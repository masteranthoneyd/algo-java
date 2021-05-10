package com.yangbingdong.algo.basic.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * LeetCode 22 https://leetcode-cn.com/problems/valid-parentheses/
 */
public class ValidParenthesesSolution {

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
