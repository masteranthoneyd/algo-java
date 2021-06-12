package com.yangbingdong.algo.basic.map;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public interface LRU<K, V> {

    void put(K k, V v);

    V get(K k);

    V remove(K k);

    int size();

}
