package com.yangbingdong.algo.basic.sort;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * 选择排序, 与插入排序类似, 分为有序跟无序区, 不同的是, 选择排序每次冲无序区中选择最小的, 插入到有序区的下一个
 */
public class SelectionSort implements Sort {
    @Override
    public int[] sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        for (int j = 0; j < nums.length - 1; j++) {
            int minIdx = j;
            int i = minIdx + 1;
            for (; i < nums.length; i++) {
                if (nums[minIdx] > nums[i]) {
                    minIdx = i;
                }
            }
            SortUtil.swap(nums, minIdx, j);
        }
        return nums;
    }
}
