package com.yangbingdong.algo.basic.map;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public class HashMap<K, V> implements Map<K, V> {

    /**
     * 散列表默认长度
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 8;

    /**
     * 装载因子
     */
    private static final float LOAD_FACTOR = 0.75f;

    private int size = 0;

    /**
     * 总容量
     */
    private int capacity;
    /**
     * 装载因子, 越大 hash 冲突越大
     */
    private float loadFactor;
    /**
     * 扩容阈值, capacity * loadFactor, 当 size 大于该值, 则需要扩容
     */
    private int threshold;

    private Node<K, V>[] table;

    public HashMap() {
        this(DEFAULT_INITIAL_CAPACITY, LOAD_FACTOR);
    }

    public HashMap(int capacity) {
        this(capacity, LOAD_FACTOR);
    }

    public HashMap(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.threshold = (int) (capacity * loadFactor);
        //noinspection unchecked
        this.table = new Node[capacity];
    }

    @Override
    public void put(K k, V v) {
        int hash = hash(k);
        if (table[hash] == null) {
            table[hash] = new Node<>(k, v, null);
        } else {
            Node<K, V> node = table[hash];
            while (node.next != null) {
                if (node.k == k || node.k.equals(k)) {
                    node.v = v;
                    return;
                }
                node = node.next;
            }
            node.next = new Node<>(k, v, null);
        }
        if (++size > threshold) {
            resize();
        }
    }

    protected void resize() {
        this.capacity = table.length * 2;
        @SuppressWarnings("unchecked")
        Node<K, V>[] newTable = new Node[this.capacity];
        this.threshold = (int) (newTable.length * loadFactor);
        Node<K, V> node;
        for (int i = 0; i < table.length; i++) {
            if ((node =table[i]) == null) {
                continue;
            }
            int hash = hash(node.k);
            newTable[hash] = node;
        }
        this.table = newTable;
    }

    @Override
    public V get(K k) {
        int hash = hash(k);
        Node<K, V> node = table[hash];
        if (node == null) {
            return null;
        }
        while (node != null) {
            if (node.k == k || node.k.equals(k)) {
                return node.v;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(K k) {
        int hash = hash(k);
        Node<K, V> node = table[hash];
        if (node == null) {
            return;
        }
        node = removeNode(node, k);
        table[hash] = node;
        size--;
    }

    protected Node<K, V> removeNode(Node<K, V> head, K k) {
        Node<K, V> del = head,delPrev = null;
        while (del.k != k && !del.k.equals(k)) {
            delPrev = del;
            del = del.next;
        }
        if (delPrev == null) {
            return null;
        }
        delPrev.next = del.next;
        return head;
    }

    protected int hash(Object key) {
        int h;
        return (key == null) ? 0 : ((h = key.hashCode()) ^ (h >>> 16)) % table.length;
    }

    static class Node<K, V> {
        K k;
        V v;
        Node<K, V> next;

        public Node(K k, V v, Node<K, V> next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }
    }
}
