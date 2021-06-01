package com.yangbingdong.algo.basic.sort;

import static com.yangbingdong.algo.basic.sort.SortUtil.partition;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * 快速排序, 从数组中选一个数 pivot(可以选择最右边的那个),
 * 起始时假设 pivotIndex 在最左边, 从左到右遍历数组, 小于 pivot 的, 跟 nums[pivotIndex] 交换位置, pivotIndex
 * 最后交换 nums[pivotIndex] 与最右边元素的位置
 */
public class QuickSort implements Sort {

    @Override
    public int[] sort(int[] nums) {
        sortInner(nums, 0, nums.length - 1);
        return nums;
    }

    protected void sortInner(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(nums, left, right);
        sortInner(nums, left, pivot - 1);
        sortInner(nums, pivot + 1, right);
    }

}
