package com.yangbingdong.algo.basic.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public class LRUImpl<K, V> implements LRU<K, V> {

    private final int maxSize;
    private final Map<K, Node> cache;

    private final Node head;
    private final Node tail;

    private int size;

    public LRUImpl(int maxSize) {
        this.maxSize = maxSize;
        size = 0;
        cache = new HashMap<>(maxSize);

        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public void put(K k, V v) {
        Node node = cache.get(k);
        if (node == null) {
            node = new Node(k, v);
            cache.put(k, node);
            if (size >= maxSize) {
                removeNode(head.next);
            } else {
                size++;
            }
        } else {
            node.v = v;
            removeNode(node);
        }
        linkedToTail(node);
    }


    @Override
    public V get(K k) {
        Node node = cache.get(k);
        if (node == null) {
            return null;
        }
        removeNode(node);
        linkedToTail(node);
        return node.v;
    }

    @Override
    public V remove(K k) {
        Node node = cache.get(k);
        if (node == null) {
            return null;
        }
        removeNode(node);
        cache.remove(k);
        size--;
        return node.v;
    }

    @Override
    public int size() {
        return size;
    }

    protected void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    protected void linkedToTail(Node node) {
        Node last = tail.prev;
        tail.prev = node;
        last.next = node;
        node.prev = last;
        node.next = tail;
    }

    @Override
    public String toString() {
        if (head.next == tail) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        Node node = head.next;
        while (node != tail) {
            sb.append(node.v);
            if (node != tail.prev) {
                sb.append(" -> ");
            }
            node = node.next;
        }
        return sb.toString();
    }

    class Node {

        K k;
        V v;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }
}
