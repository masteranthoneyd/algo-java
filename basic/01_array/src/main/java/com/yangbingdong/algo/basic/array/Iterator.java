package com.yangbingdong.algo.basic.array;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public interface Iterator<T> {

    boolean hasNext();

    T next();

    void remove();
}
