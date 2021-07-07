package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/minimum-height-tree-lcci/
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTInner(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTInner(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBSTInner(nums, left, mid - 1);
        node.right = sortedArrayToBSTInner(nums, mid + 1, right);
        return node;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
