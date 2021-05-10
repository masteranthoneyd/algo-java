package com.yangbingdong.algo.basic.linklist;

import lombok.Getter;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * 单向链表
 */
public class SinglyLinkedList<T> {

    private Node head;
    @Getter
    private int size;

    public SinglyLinkedList() {
        size = 0;
    }

    public T getFirst() {
        return head == null ? null : head.value;
    }

    public void add(T t) {
        Node n = new Node(t);
        n.next = head;
        head = n;
        size++;
    }

    public void addLast(T t) {
        Node n = new Node(t);
        if (head == null) {
            head = n;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = n;
        }
        size++;
    }

    public T removeFirstByValue(T t) {
        Node n = findFirstNode(t);
        if (n == null) {
            return null;
        }
        if (n == head) {
            head = head.next;
            size--;
        } else {
            Node pre = findPre(n);
            if (pre != null) {
                pre.next = pre.next.next;
                size--;
            }
        }
        return n.value;
    }

    protected Node findFirstNode(T t) {
        Node n = head;
        while (n != null) {
            if (n.value.equals(t)) {
                return n;
            }
            n = n.next;
        }
        return null;
    }

    protected Node findPre(Node n) {
        Node pre = head;
        while (pre.next != null) {
            if (pre.next.equals(n)) {
                return pre;
            }
            pre = pre.next;
        }
        return null;
    }

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
        while (n != null) {
            sb.append(n.value);
            n = n.next;
            if (n != null) {
                sb.append(" -> ");
            }
        }
        return sb.toString();
    }

    class Node{
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
        }
    }
}
