package com.yangbingdong.algo.basic.sort;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public class SortUtil {

    /**
     * 交换 els 中 a 与 b 的位置
     */
    public static void swap(int[] els, int a, int b) {
        int temp = els[a];
        els[a] = els[b];
        els[b] = temp;
    }
}
