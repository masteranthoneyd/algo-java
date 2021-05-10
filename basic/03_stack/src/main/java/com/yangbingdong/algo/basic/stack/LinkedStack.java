package com.yangbingdong.algo.basic.stack;

import lombok.Data;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * 基于链表实现的栈
 */
public class LinkedStack<T> implements Stack<T> {

    private Node head;

    private int size;

    public LinkedStack() {
        size = 0;
    }

    @Override
    public T pop() {
        if (size == 0) {
            return null;
        }
        Node cur = head;
        head = head.next;
        size--;
        return cur.t;
    }

    @Override
    public void push(T t) {
        Node newNode = new Node(t);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    @Override
    public T peek() {
        if (head == null) {
            return null;
        }
        return head.t;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clean() {
        head = null;
        size = 0;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Node n = head;
        for (int i = 0; i < size; i++) {
            sb.append(n.t);
            if (i != size - 1) {
                sb.append(" -> ");
            }
            n = n.next;
        }
        return sb.toString();
    }

    @Data
    class Node {
        T t;
        Node next;

        public Node(T t) {
            this.t = t;
        }
    }


}
