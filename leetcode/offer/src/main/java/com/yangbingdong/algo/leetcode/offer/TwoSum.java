package com.yangbingdong.algo.leetcode.offer;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 */
public class TwoSum {

    /**
     * 双指针
     */
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int res = nums[l] + nums[r];
            if (res < target) {
                l++;
            } else if (res > target) {
                r--;
            } else {
                return new int[]{nums[l], nums[r]};
            }

        }
        return new int[0];
    }

}
