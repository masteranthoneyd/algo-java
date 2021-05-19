package com.yangbingdong.algo.basic.array;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * LeetCode 26 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * 使用双指针(l, i)
     * i 每次循环往后走一步
     * 当 l 位置的元素不等于 i 位置的, 则将 i 位置的元素赋值给 l + 1 位置的, 同时 l 往后走一步
     *
     * 小优化: 当数组是 1,2,3,4,5 这种前面有序的情况, 并不需要交换位置, 所以可以判断 i - l > 1 时再赋值
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int l = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[l] != nums[i]) {
                if (i - l > 1) {
                    nums[l + 1] = nums[i];
                }
                l++;
            }
        }
        return l + 1;
    }
}
