package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/magic-index-lcci/
 */
public class FindMagicIndex {

    public static void main(String[] args) {
        FindMagicIndex solution = new FindMagicIndex();
        int[] nums = {-99, -87, -69, -51, -40, -38, -31, -30, -18, -1, 10, 11, 41, 63, 71, 72, 72, 78, 86, 88};
        System.out.println(solution.findMagicIndex(nums));

        nums = new int[]{0, 2, 3, 4, 5};
        System.out.println(solution.findMagicIndex(nums));
    }

    public int findMagicIndex(int[] nums) {
        return findInner(nums, 0, nums.length - 1);
    }

    public int findMagicIndex2(int[] nums) {
        return findInner(nums, 0, nums.length - 1);
    }

    private int findInner(int[] nums, int l, int r) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        int left = findInner(nums, l, mid - 1);
        if (left != -1) {
            return left;
        } else if (nums[mid] == mid) {
            return mid;
        }
        return findInner(nums, mid + 1, r);
    }


    public int findMagicIndex1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                return i;
            }
        }
        return -1;
    }

}
