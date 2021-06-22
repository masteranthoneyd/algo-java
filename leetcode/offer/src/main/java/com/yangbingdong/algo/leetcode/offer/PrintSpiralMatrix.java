package com.yangbingdong.algo.leetcode.offer;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 */
public class PrintSpiralMatrix {

    public int[] spiralOrder(int[][] matrix) {

        if (matrix.length == 0) {
            return new int[0];
        }

        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, c = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            // 左 -> 右
            for (int i = l; i <= r; i++) {
                res[c++] = matrix[t][i];
            }
            if (++t > b) {
                break;
            }
            // 上 -> 下
            for (int i = t; i <= b; i++) {
                res[c++] = matrix[i][r];
            }
            if (l > --r) {
                break;
            }
            // 右 -> 左
            for (int i = r; i >= l; i--) {
                res[c++] = matrix[b][i];
            }
            if (t > --b) {
                break;
            }
            // 下 -> 上
            for (int i = b; i >= t; i--) {
                res[c++] = matrix[i][l];
            }
            if (++l > r) {
                break;
            }
        }
        return res;
    }

}
