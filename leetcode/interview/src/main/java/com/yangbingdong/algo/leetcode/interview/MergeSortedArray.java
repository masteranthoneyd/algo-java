package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/sorted-merge-lcci/
 */
public class MergeSortedArray {

    public void merge(int[] A, int m, int[] B, int n) {
        int idx = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (A[m] >= B[n]) {
                A[idx--] = A[m];
                m--;
            } else {
                A[idx--] = B[n];
                n--;
            }
        }
        while (m >= 0) {
            A[idx--] = A[m];
            m--;
        }
        while (n >= 0) {
            A[idx--] = B[n];
            n--;
        }
    }

}
