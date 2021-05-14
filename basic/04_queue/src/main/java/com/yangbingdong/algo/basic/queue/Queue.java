package com.yangbingdong.algo.basic.queue;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public interface Queue<T> {

    boolean enqueue(T t);

    T dequeue();

    int size();
}
