package com.yangbingdong.algo.basic.sort;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * 希尔排序, 插入排序升级版, 通过步伐逐步将数组变成有序
 */
public class ShellSort implements Sort {

    @Override
    public int[] sort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int gap = nums.length / 2;
        while (gap >= 1) {
            for (int i = gap; i < nums.length; i++) {
                int cur = nums[i];
                int j = i - gap;
                for (; j >= 0; j -= gap) {
                    if (cur < nums[j]) {
                        nums[j + gap] = nums[j];
                    } else {
                        break;
                    }
                }
                nums[j + gap] = cur;
            }
            gap = gap / 2;
        }
        return nums;
    }
}
