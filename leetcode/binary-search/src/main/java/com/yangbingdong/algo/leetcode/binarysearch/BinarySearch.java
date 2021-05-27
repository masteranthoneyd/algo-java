package com.yangbingdong.algo.leetcode.binarysearch;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * LeetCode https://leetcode-cn.com/problems/binary-search/
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 5, 7, 8, 9};
        BinarySearch binarySearch = new BinarySearch();
        int ret = binarySearch.search(nums, 2);
        System.out.println(ret);
    }

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        return -1;
    }

}
