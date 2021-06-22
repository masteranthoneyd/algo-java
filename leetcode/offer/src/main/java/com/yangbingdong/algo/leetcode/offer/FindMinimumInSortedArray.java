package com.yangbingdong.algo.leetcode.offer;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class FindMinimumInSortedArray {

    public int minArray(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (numbers[mid] > numbers[r]) {
                l = mid + 1;
            } else if (numbers[mid] < numbers[r]) {
                r = mid;
            } else {
                r--;
            }
        }
        return numbers[l];
    }

    /**
     * 遍历法, 当前一个元素比当前元素大的时候, 那么当前元素就是起点
     * 时间复杂度 O(n)
     */
    private int solution1(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        int pre = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (pre > numbers[i]) {
                return numbers[i];
            }
            pre = numbers[i];
        }
        return numbers[0];
    }

}
