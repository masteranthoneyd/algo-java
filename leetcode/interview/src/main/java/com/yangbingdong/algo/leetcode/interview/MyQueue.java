package com.yangbingdong.algo.leetcode.interview;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/implement-queue-using-stacks-lcci/
 */
public class MyQueue {

    private final Deque<Integer> out;
    private final Deque<Integer> in;

    /** Initialize your data structure here. */
    public MyQueue() {
        out = new LinkedList<>();
        in = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (out.isEmpty()) {
            inToOut();
        }
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (out.isEmpty()) {
            inToOut();
        }
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void inToOut() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        queue.push(3);
        System.out.println(queue.peek());
    }

}
