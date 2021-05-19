package com.yangbingdong.algo.basic.array;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * LeetCode 26 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {

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
