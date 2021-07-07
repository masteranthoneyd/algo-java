package com.yangbingdong.algo.leetcode.offer;

import java.util.stream.IntStream;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 */
public class MinNumber {

    public static void main(String[] args) {
        // 30 3 34 5 9
        int[] nums = {3, 30, 34, 5, 9};
        MinNumber solution = new MinNumber();
        String number = solution.minNumber(nums);
        System.out.println(number);
    }

    public String minNumber(int[] nums) {
        String[] strs = IntStream.of(nums).mapToObj(String::valueOf).toArray(String[]::new);
        quickSort(strs, 0, strs.length - 1);
        return String.join("", strs);
    }

    private void quickSort(String[] strs, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(strs, left, right);
        quickSort(strs, left, pivotIndex - 1);
        quickSort(strs, pivotIndex + 1, right);
    }

    private int partition(String[] strs, int left, int right) {
        int pivotIndex = left;
        String y = strs[right];
        for (int i = left; i < right; i++) {
            String x = strs[i];
            if ((x + y).compareTo(y + x) < 0) {
                swap(strs, i, pivotIndex++);
            }
        }
        swap(strs, pivotIndex, right);
        return pivotIndex;
    }

    private void swap(String[] strs, int a, int b) {
        if (a == b) {
            return;
        }
        String temp = strs[a];
        strs[a] = strs[b];
        strs[b] = temp;
    }
}
