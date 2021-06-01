package com.yangbingdong.algo.basic.sort;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public class RadixSort implements Sort {

    @Override
    public int[] sort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }

        // 从个位开始，对数组arr按"指数"进行排序
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(nums, exp);
        }
        return nums;
    }

    private void countingSort(int[] nums, int exp) {
        // 统计基数
        int[] c = new int[10];
        for (int i = 0; i < nums.length; i++) {
            c[(nums[i] / exp) % 10]++;
        }

        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        int[] r = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            r[c[(num / exp) % 10] - 1] = num;
            c[(num / exp) % 10]--;
        }
        System.arraycopy(r, 0, nums, 0, nums.length);
    }
}
