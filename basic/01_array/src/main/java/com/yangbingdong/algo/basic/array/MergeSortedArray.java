package com.yangbingdong.algo.basic.array;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * Leetcode 88. https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        mergeInner2(nums1, m, nums2, n);
    }

    /**
     * 新建一个长度为 m+n 的数组
     * 逐个对比 nums1 与 nums2 元素, 小的元素追加到新的数组中
     * 最后再将新的数组赋值给 nums1
     */
    private void mergeInner1(int[] nums1, int m, int[] nums2, int n) {
        int[] ret = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (j < m && k < n) {
            if (nums1[j] < nums2[k]) {
                ret[i++] = nums1[j++];
            } else {
                ret[i++] = nums2[k++];
            }
        }

        if (j < m) {
            while (j < m) {
                ret[i++] = nums1[j++];
            }
        }
        if (k < n) {
            while (k < n) {
                ret[i++] = nums2[k++];
            }
        }
        System.arraycopy(ret, 0, nums1, 0, ret.length);
    }

    /**
     * 不消耗外空间
     * 由于两个数组已排好序, 所以可以采取从后向前填充最大值的方式解决
     */
    private void mergeInner2(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        int j = m - 1, k = n - 1;
        while (j >= 0 && k >= 0) {
            if (nums1[j] > nums2[k]) {
                nums1[i--] = nums1[j--];
            }else {
                nums1[i--] = nums2[k--];
            }
        }
        if (j >= 0) {
            while (j >= 0) {
                nums1[i--] = nums1[j--];
            }
        }

        if (k >= 0) {
            while (k >= 0) {
                nums1[i--] = nums2[k--];
            }
        }
    }


}
