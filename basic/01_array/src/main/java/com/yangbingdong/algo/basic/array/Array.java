package com.yangbingdong.algo.basic.array;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public interface Array<T> {

    void add(T t);

    void add(int index, T t);

    T get(int index);

    T remove(int index);

    void set(int index, T t);

    int size();

    boolean contains(T t);

    Iterator<T> iterator();

}
