package com.yangbingdong.algo.basic.heap;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public class Heap {

    private int[] a;
    private int capacity;
    private int size;

    public Heap(int[] source) {
        a = source;
        capacity = source.length - 1;
        size = source.length - 1;
        for (int i = capacity / 2; i >= 1; --i) {
            heapify(a, i);
        }
    }

    public Heap(int capacity) {
        this.a = new int[capacity + 1];
        this.capacity = capacity;
        this.size = 0;
    }

    public void insert(int data) {
        if (size == capacity) {
            return;
        }
        size++;
        a[size] = data;
        int i = size;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(a, i, i / 2);
            i /= 2;
        }
    }

    public int removeMax() {
        if (this.size == 0) {
            return -1;
        }
        int res = a[1];
        a[1] = a[size];
        int i = 1;
        while (true) {
            int maxPox = i;
            if (i * 2 <= capacity && a[i] < a[i * 2]) {
                maxPox = i * 2;
            }
            if (i * 2 + 1 <= capacity && a[maxPox] < a[i * 2 + 1]) {
                maxPox = i * 2 + 1;
            }
            if (maxPox == i) {
                break;
            }
            swap(a, maxPox, i);
        }
        size--;
        return res;
    }

    public int peek() {
        return a[1];
    }

    private void heapify(int[] a, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= capacity && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= capacity && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (i == maxPos) {
                break;
            }
            swap(a, i, maxPos);
        }
    }

    private void swap(int[] a, int b, int c) {
        if (b == c) {
            return;
        }
        int t = a[b];
        a[b] = a[c];
        a[c] = t;
    }

}
