package com.yangbingdong.algo.leetcode.interview;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/min-stack-lcci/
 */
public class MinStack {

    private final Deque<int[]> stack;

    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new int[]{x, x});
        } else {
            stack.push(new int[]{x, Math.min(x, stack.peek()[1])});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }

}
