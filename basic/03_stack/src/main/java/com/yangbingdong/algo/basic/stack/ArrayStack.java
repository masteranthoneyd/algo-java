package com.yangbingdong.algo.basic.stack;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * 基于数组实现的栈
 */
public class ArrayStack<T> implements Stack<T> {

    private T[] array;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        capacity = 8;
        array = (T[]) new Object[capacity];
        size = 0;
    }

    @Override
    public T pop() {
        if (size == 0) {
            return null;
        }
        int cursor = size-- - 1;
        T element = array[cursor];
        array[cursor] = null;
        return element;
    }

    @Override
    public void push(T t) {
        if (size == capacity) {
            grow();
        }
        array[size++] = t;
    }

    @Override
    public T peek() {
        if (size == 0) {
            return null;
        }
        return array[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        this.capacity = this.capacity << 1;
        T[] newArray = (T[]) new Object[this.capacity];
        System.arraycopy(array, 0, newArray, 0, array.length);
        this.array = newArray;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = size - 1; i >= 0; i--) {
            sb.append(array[i]);
            if (i != 0) {
                sb.append(" -> ");
            }
        }
        return sb.toString();
    }
}
