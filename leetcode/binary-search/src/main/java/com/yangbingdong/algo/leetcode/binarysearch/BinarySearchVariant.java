package com.yangbingdong.algo.leetcode.binarysearch;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * 二分查找变种
 */
public class BinarySearchVariant {

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 5, 7, 8, 8, 8, 8, 9, 11, 19};
        BinarySearchVariant binarySearch = new BinarySearchVariant();
        int ret = binarySearch.findLastEquals(nums, 2);
        System.out.println(ret);

        nums = new int[]{3, 5, 7, 7, 9, 17};
        ret = binarySearch.findLastLe(nums, 7);
        System.out.println(ret);
    }

    /**
     * 找到第一个等于给定值的元素下标
     */
    public int findFirstEquals(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        if (nums[l] == target) {
            return l;
        }
        return -1;
    }

    /**
     * 找到最后一个等于给定值的元素下标
     */
    public int findLastEquals(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2 + 1;
            if (nums[mid] <= target) {
                l = mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            }
        }
        if (nums[l] == target) {
            return l;
        }
        return -1;
    }

    /**
     * 找到第一个大于等于给定值的元素下标
     */
    public int findFirstGe(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (nums[l] >= target) {
            return l;
        }
        return -1;
    }

    /**
     * 找到最后一个小于等于给定值的元素下标
     */
    public int findLastLe(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2 + 1;
            // int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        if (nums[l] <= target) {
            return l;
        }
        return -1;
    }

}
