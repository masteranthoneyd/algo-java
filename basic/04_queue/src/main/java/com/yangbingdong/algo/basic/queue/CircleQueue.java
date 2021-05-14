package com.yangbingdong.algo.basic.queue;

import java.util.Arrays;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * 环形队列, 实现关键在于空队列以及满队列的判断
 * 空队列: head == tail
 * 满队列: (tail + 1) % capacity == head
 */
public class CircleQueue<T> implements Queue<T> {

    private int capacity;
    private int head = 0;
    private int tail = 0;
    private T[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public CircleQueue(int capacity) {
        this.capacity = capacity + 1;
        array = (T[]) new Object[this.capacity];
        size = 0;
    }

    public CircleQueue() {
        this(16);
    }

    @Override
    public boolean enqueue(T t) {
        if ((tail + 1) % capacity == head) {
            return false;
        }
        array[tail] = t;
        tail = (tail + 1) % capacity;
        size++;
        return true;
    }

    @Override
    public T dequeue() {
        if (head == tail) {
            return null;
        }
        T el = array[head];
        array[head] = null;
        head = (head + 1) % capacity;
        size--;
        return el;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
