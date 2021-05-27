package com.yangbingdong.algo.leetcode.binarysearch;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * LeetCode https://leetcode-cn.com/problems/search-insert-position/
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        SearchInsertPosition solution = new SearchInsertPosition();
        int ret = solution.searchInsert(nums, 2);
        System.out.println(ret);
    }

    public int searchInsert(int[] nums, int target) {
        return searchInner(nums, target);
    }

    /**
     * 直接循环暴力破解
     */
    private int searchInner(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 二分法, 通过 mid 将数组分成两个区间 [left, mid], [mid + 1, right]
     */
    private int searchInner2(int[] nums, int target) {
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
