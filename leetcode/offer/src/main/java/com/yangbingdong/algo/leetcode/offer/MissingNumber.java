package com.yangbingdong.algo.leetcode.offer;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == mid) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (nums[l] == l) {
            l++;
        }
        return l;
    }

    /**
     * 暴力破解
     */
    public int missingNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
}
