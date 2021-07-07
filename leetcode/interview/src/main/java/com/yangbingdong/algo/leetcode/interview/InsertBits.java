package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/insert-into-bits-lcci/solution/
 */
public class InsertBits {

    public int insertBits(int N, int M, int i, int j) {
        // 将 j~i 位置零
        for (int k = i; k <= j; k++) {
            N &= ~(1 << k);
        }
        // 将 M 左移 i 位, 对应上了 N 的 j~i 位
        M <<= i;
        // 最后将 M 插入到 N
        return N | M;
    }

    public static void main(String[] args) {
        InsertBits solution = new InsertBits();
        System.out.println(solution.insertBits(1024, 19, 2, 6));
    }

}
