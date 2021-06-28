package com.yangbingdong.algo.leetcode.offer;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class SearchDuplicateNumInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (nums[l] != target) {
            return new int[]{-1, -1};
        }
        int i = l;
        while (i < nums.length && nums[i] == target) {
            i++;
        }
        return new int[]{l, i - 1};
    }

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int i = l;
        while (i < nums.length && nums[i] == target) {
            i++;
        }
        return i - l;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        SearchDuplicateNumInSortedArray solution = new SearchDuplicateNumInSortedArray();
        int res = solution.search(nums, 5);
        System.out.println(res);
    }
}
