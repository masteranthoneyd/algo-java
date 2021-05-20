package com.yangbingdong.algo.basic.sort;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * 插入排序, 核心思想, 数组分成有序(左边)和无序(右边)分区, 一开始只有第一个元素构成有有序分区
 * 遍历无序分区, 在有序分区中找到自己合适的位置并插入
 */
public class InsertionSort implements Sort {

    @Override
    public int[] sort(int[] nums) {
        if (nums == null || nums.length == 1) {
            return nums;
        }
        return sortInner2(nums);
    }

    private int[] sortInner2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int cur = nums[i];
            for (; j >= 0; j--) {
                if (nums[j] > cur) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = cur;
        }
        return nums;
    }


    private int[] sortInner1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            while (j >= 0 && nums[j] > nums[i]) {
                j--;
            }
            if (j != i - 1) {
                int tmp = nums[i];
                System.arraycopy(nums, j + 1, nums, j + 2, i - j - 1);
                nums[j + 1] = tmp;
            }
        }
        return nums;
    }
}
