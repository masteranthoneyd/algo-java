package com.yangbingdong.algo.basic.sort;

import static com.yangbingdong.algo.basic.sort.SortUtil.swap;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * 冒泡排序, 遍历数组, 每次只与后一个元素比较, 比后一个大则交换位置
 *
 * 小优化: 如果每次遍历没有元素交换, 则说明后面的都是有序的
 */
public class BubbleSort implements Sort {

    @Override
    public int[] sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        for (int k = 0; k < nums.length - 1; k++) {
            boolean swap = false;
            for (int i = 0; i < nums.length - 1 - k; i++) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
        return nums;
    }
}
