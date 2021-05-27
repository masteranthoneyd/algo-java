package com.yangbingdong.algo.basic.sort;

import java.util.Arrays;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public class QuickSort implements Sort{

    public static void main(String[] args) {
        int[] nums = {3, 2, 6, 4, 5, 1, 9, 20, 13, 16};

        Sort sort = new QuickSort();
        sort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

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

    protected int partition(int[] nums, int left, int right) {
        int pivotIndex = left;
        int pivot = nums[right];

        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                int tmp = nums[i];
                nums[i] = nums[pivotIndex];
                nums[pivotIndex++] = tmp;
            }
        }
        int tmp = nums[pivotIndex];
        nums[pivotIndex] = nums[right];
        nums[right] = tmp;
        return pivotIndex;
    }
}
