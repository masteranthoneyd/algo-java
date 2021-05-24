package com.yangbingdong.algo.basic.sort;

import java.util.Arrays;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * 归并排序, 通过将数组拆分成对半的两个子数组再合并
 * 这是个递归的过成, 直到拆分的子数组长度为 1(长度为 1 是确认有序的), 再不断 [合并两个有序数组]
 * 空间复杂度 O(nlogn)
 */
public class MergeSort implements Sort {

    public static void main(String[] args) {
        int[] nums = {3, 2, 6, 4, 5, 1, 9, 20, 13, 16};
        Sort sort = new MergeSort();
        sort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Override
    public int[] sort(int[] nums) {
        mergerSortInner(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergerSortInner(int[] nums, int a, int c) {
        if (a >= c) {
            return;
        }
        // 防止 a+c 溢出
        int b = a + (c - a) / 2;

        mergerSortInner(nums, a, b);
        mergerSortInner(nums, b + 1, c);

        merge2(nums, a, b, c);
    }

    /**
     * 使用两个数组(left, right) 分别记录 [a, b], [b+1, c] 下标的元素
     * 此时的 left, right 数组已经是有序的, 接下来就是合并这两个有序数组, 存放到 tmp 数组中
     * 最后将 tmp 中的数组 copy 回 nums 的 [a,c] 下标位置
     */
    private void merge(int[] nums, int a, int b, int c) {
        int[] tmp = new int[c - a + 1];

        int[] left = new int[b - a + 1];
        System.arraycopy(nums, a, left, 0, left.length);

        int[] right = new int[c - b];
        System.arraycopy(nums, b + 1, right, 0, right.length);

        int l = 0, r = 0, t = 0;
        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                tmp[t++] = left[l++];
            } else {
                tmp[t++] = right[r++];
            }
        }

        if (l < left.length) {
            while (l < left.length) {
                tmp[t++] = left[l++];
            }
        }
        if (r < right.length) {
            while (r < right.length) {
                tmp[t++] = right[r++];
            }
        }

        System.arraycopy(tmp, 0, nums, a, tmp.length);
    }

    /**
     * 与上面 merge 函数类似, 只不过是不需要 left 以及 right 这两个额外的空间
     */
    private void merge2(int[] nums, int a, int b, int c) {
        int[] tmp = new int[c - a + 1];
        int l = a, r = b + 1, t = 0;
        while (l <= b && r <= c) {
            if (nums[l] < nums[r]) {
                tmp[t++] = nums[l++];
            } else {
                tmp[t++] = nums[r++];
            }
        }

        if (l <= b) {
            while (l <= b) {
                tmp[t++] = nums[l++];
            }
        }
        if (r <= c) {
            while (r <= c) {
                tmp[t++] = nums[r++];
            }
        }
        System.arraycopy(tmp, 0, nums, a, tmp.length);
    }
}





















