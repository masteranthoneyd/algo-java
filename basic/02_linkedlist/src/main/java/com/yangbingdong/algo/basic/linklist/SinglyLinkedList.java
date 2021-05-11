package com.yangbingdong.algo.basic.linklist;

import lombok.Getter;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * 单向链表
 */
public class SinglyLinkedList<T> {

    private SNode<T> head;
    @Getter
    private int size;

    public SinglyLinkedList() {
        size = 0;
    }

    public T getFirst() {
        return head == null ? null : head.value;
    }

    public void add(T t) {
        SNode<T> n = new SNode<>(t);
        n.next = head;
        head = n;
        size++;
    }

    public void addLast(T t) {
        SNode<T> n = new SNode<>(t);
        if (head == null) {
            head = n;
        } else {
            SNode<T> last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = n;
        }
        size++;
    }

    public T removeFirstByValue(T t) {
        SNode<T> n = findFirstNode(t);
        if (n == null) {
            return null;
        }
        if (n == head) {
            head = head.next;
            size--;
        } else {
            SNode<T> pre = findPre(n);
            if (pre != null) {
                pre.next = pre.next.next;
                size--;
            }
        }
        return n.value;
    }

    protected SNode<T> findFirstNode(T t) {
        SNode<T> n = head;
        while (n != null) {
            if (n.value.equals(t)) {
                return n;
            }
            n = n.next;
        }
        return null;
    }

    protected SNode<T> findPre(SNode<T> n) {
        SNode<T> pre = head;
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
        return head.toString();
    }

}
