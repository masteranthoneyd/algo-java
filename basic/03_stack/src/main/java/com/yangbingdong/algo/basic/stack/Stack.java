package com.yangbingdong.algo.basic.stack;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public interface Stack<T> {

    T pop();

    void push(T t);

    T peek();

    boolean isEmpty();

    int size();

    void clean();

}
