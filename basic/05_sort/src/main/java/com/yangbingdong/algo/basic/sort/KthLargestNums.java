package com.yangbingdong.algo.basic.sort;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * LeetCode https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestNums {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        KthLargestNums solution = new KthLargestNums();
        int kthLargest = solution.findKthLargest(nums, 4);
        System.out.println(kthLargest);
    }

    /**
     * 利用快速排序的思想, 经过 partition 之后, 返回的下标是固定的了, 如果 k 比 partition 小, 则下一次寻找 [left, partition - 1], 反之寻找 [partition + 1, right]
     */
    public int findKthLargest(int[] nums, int k) {
        return nums[quickSelect(nums, 0, nums.length - 1, nums.length - k)];
    }

    public int quickSelect(int[] nums, int left, int right, int index) {
        if (left >= right) {
            return left;
        }
        int partition = partition(nums, left, right);

        if (partition == index) {
            return partition;
        } else if (partition > index) {
            return quickSelect(nums, left, partition - 1, index);
        } else {
            return quickSelect(nums, partition + 1, right, index);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivotIndex = left;
        int pivot = nums[right];

        for (int i = left; i < right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, pivotIndex++);
            }
        }
        swap(nums, pivotIndex, right);
        return pivotIndex;
    }

    public void swap(int[] nums, int a, int b) {
        if (a == b) {
            return;
        }
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
