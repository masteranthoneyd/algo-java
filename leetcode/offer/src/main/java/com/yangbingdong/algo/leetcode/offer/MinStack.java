package com.yangbingdong.algo.leetcode.offer;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 */
public class MinStack {

    private Node node;

    public MinStack() {

    }

    public void push(int val) {
        if (node == null) {
            node = new Node(val, val);
            return;
        }
        Node newNode = new Node(val, Math.min(val, node.min));
        newNode.next = node;
        node = newNode;
    }

    public void pop() {
        node = node.next;
    }

    public int top() {
        return node.val;
    }

    public int min() {
        return node.min;
    }

    class Node {
        int val;
        int min;
        Node next;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
}
