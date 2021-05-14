package com.yangbingdong.algo.basic.queue;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public class ArrayBasedQueue<T> implements Queue<T> {

    private int capacity;
    private int size;
    private T[] array;

    private int head = 0;
    private int next = 0;

    @SuppressWarnings("unchecked")
    public ArrayBasedQueue(int capacity) {
        this.capacity = capacity;
        size = 0;
        array = (T[]) new Object[capacity];
    }

    public ArrayBasedQueue() {
        this(16);
    }

    @Override
    public boolean enqueue(T t) {
        if (capacity == size) {
            return false;
        }
        if (next == capacity) {
            move();
        }
        array[next++] = t;
        size++;
        return true;
    }

    @Override
    public T dequeue() {
        if (size == 0) {
            return null;
        }
        T headEl = array[head];
        array[head] = null;
        head++;
        size--;
        return headEl;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    protected void move() {
        T[] newArray = (T[]) new Object[capacity];
        System.arraycopy(array, head, newArray, 0, size);
        array = newArray;
        head = 0;
        next = size;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = head; i < size; i++) {
            sb.append(array[i]);
            if (i != size - 1) {
                sb.append(" -> ");
            }
        }
        return sb.toString();
    }
}
