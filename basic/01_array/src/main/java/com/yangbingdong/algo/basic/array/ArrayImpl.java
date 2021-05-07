package com.yangbingdong.algo.basic.array;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
@SuppressWarnings("unchecked")
public class ArrayImpl<T> implements Array<T> {

    private T[] array;

    private int size;

    private int modCount;

    public ArrayImpl(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        array = (T[]) new Object[capacity];
        modCount = size = 0;
    }

    public ArrayImpl() {
        this(8);
    }

    @Override
    public void add(T t) {
        add(size, t);
    }

    @Override
    public void add(int index, T t) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
        if (array.length == size) {
            resize(array.length << 1);
        }
        for (int i = size; i > index; i--) {
            array[size] = array[size - 1];
        }
        array[index] = t;
        size++;
        modCount++;
    }

    protected void resize(int size) {
        T[] newArray = (T[]) new Object[size];
        System.arraycopy(array, 0, newArray, 0, array.length);
        this.array = newArray;
        modCount++;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    protected void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        T oldElement = array[index];
        int moveNum = size - index - 1;
        if (moveNum > 0) {
            System.arraycopy(array, index + 1, array, index, moveNum);
        }
        array[size--] = null;
        modCount++;
        return oldElement;
    }

    @Override
    public void set(int index, T t) {
        checkIndex(index);
        array[index] = t;
        modCount++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T t) {
        T e;
        for (int i = 0; i < size; i++) {
            e = array[i];
            if (e != null && e.equals(t)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        T t;
        for (int i = 0; i < size; i++) {
            t = array[i];
            sb.append(t);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {

        private int cursor;
        private int expectModCount;
        private int lastRet;

        public Itr() {
            this.expectModCount = ArrayImpl.this.modCount;
            cursor = 0;
            lastRet = -1;
        }

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public T next() {
            checkMod();
            int nextIndex = cursor;
            if (nextIndex >= size) {
                throw new NoSuchElementException();
            }
            cursor++;
            return array[lastRet = nextIndex];
        }

        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            checkMod();
            ArrayImpl.this.remove(lastRet);
            cursor = lastRet;
            lastRet = -1;
            this.expectModCount = ArrayImpl.this.modCount;
        }

        private void checkMod() {
            if (this.expectModCount != ArrayImpl.this.modCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

}
