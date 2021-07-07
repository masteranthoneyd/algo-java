package com.yangbingdong.algo.basic.sort;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public class SortUtil {

    /**
     * 交换 nums 中 a 与 b 的位置
     */
    public static void swap(int[] nums, int a, int b) {
        if (a == b) {
            return;
        }
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    /**
     * 从 nums 中选择一个数, 假设为 pivot(这里选择最右边), 将小于 pivot 的放到左边
     * 最后, nums[left, right] 以 pivot 分割成两个部分
     * 并返回分割线的位置
     */
    public static int partition(int[] nums, int left, int right) {
        int pivotIndex = left;
        int pivot = nums[right];
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, pivotIndex++);
            }
        }
        swap(nums, pivotIndex, right);
        return pivotIndex;
    }

    public static int partition2(int[] nums, int left, int right) {
        int l = left, r = right + 1;
        int pivot = nums[left];
        while (true) {
            while (nums[--r] > pivot) {
                if (r == left) {
                    break;
                }
            }
            while (nums[++l] < pivot) {
                if (l == right) {
                    break;
                }
            }
            if (l >= r) {
                break;
            }
            swap(nums, l, r);
        }
        swap(nums, left, r);
        return r;
    }

}
