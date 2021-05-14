package com.yangbingdong.algo.basic.queue;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public class LinkedBasedQueue<T> implements Queue<T> {

    private Node head;

    private Node tail;

    private int size;

    public LinkedBasedQueue() {
    }

    @Override
    public boolean enqueue(T t) {
        Node newNode = new Node(t);
        if (head == null) {
            head = this.tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
        return true;
    }

    @Override
    public T dequeue() {
        if (head == null) {
            return null;
        }
        if (head == tail) {
            tail = null;
        }
        T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return null;
        }
        Node n = head;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(n.value);
            if (i != size - 1) {
                sb.append(" -> ");
            }
            n = n.next;
        }
        return sb.toString();
    }

    class Node {
        private final T value;

        private Node next;

        public Node(T value) {
            this.value = value;
        }
    }

}

