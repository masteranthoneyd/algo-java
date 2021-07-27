package com.yangbingdong.algo.leetcode.offer;

import java.util.PriorityQueue;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class GetLeastNumbers {


    /**
     * 使用大顶堆
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) ->  b - a);
        for (int i = 0; i < k; i++) {
            heap.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (heap.peek() > arr[i]) {
                heap.poll();
                heap.add(arr[i]);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = heap.poll();
        }
        return res;
    }

    /**
     * 使用快排加二分思想
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        binaryMove(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    private void binaryMove(int[] arr, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int index = partition(arr, left, right);
        if (index == k - 1) {
            return;
        } else if (index < k - 1) {
            binaryMove(arr, index + 1, right, k);
        } else {
            binaryMove(arr, left, index - 1, k);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        swap(arr, mid, right);
        int index = left;
        int val = arr[right];
        for (int i = left; i < right; i++) {
            if (arr[i] < val) {
                swap(arr, i, index++);
            }
        }
        swap(arr, index, right);
        return index;
    }

    private void swap(int[] num, int a, int b) {
        if (a == b) {
            return;
        }
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }

}
