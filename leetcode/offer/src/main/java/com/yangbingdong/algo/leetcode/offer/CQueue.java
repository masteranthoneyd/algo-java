package com.yangbingdong.algo.leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class CQueue {

    private Deque<Integer> container;
    private Deque<Integer> temp;

    public CQueue() {
        container = new LinkedList<>();
        temp = new LinkedList<>();
    }

    public void appendTail(int value) {
        while (!container.isEmpty()) {
            temp.push(container.pop());
        }
        temp.push(value);
        while (!temp.isEmpty()) {
            container.push(temp.pop());
        }
    }

    public int deleteHead() {
        if (container.isEmpty()) {
            return -1;
        }
        return container.pop();
    }
}
