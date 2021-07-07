package com.yangbingdong.algo.leetcode.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/house-robber/
 * https://leetcode-cn.com/problems/house-robber-ii
 * https://leetcode-cn.com/problems/house-robber-iii
 */
public class Rob {

    public int rob(TreeNode root) {
        Map<TreeNode, Integer> memo = new HashMap<>();
        return robInner(root, memo);
    }

    public int robInner(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        int m = root.val;
        if (root.left != null) {
            m += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            m += rob(root.right.left) + rob(root.right.right);
        }
        int max = Math.max(m, rob(root.left) + rob(root.right));
        memo.put(root, max);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = root.left == null ? 0 : dfs(root.left.left) + dfs(root.left.right);
        int r = root.right == null ? 0 : dfs(root.right.left) + dfs(root.right.right);
        return l + r + root.val;
    }

    public int robII(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robI(Arrays.copyOfRange(nums, 0, nums.length - 1)), robI(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int robI(int[] nums) {
        int a = nums[0];
        if (nums.length == 1) {
            return a;
        }
        int b = Math.max(a, nums[1]);
        if (nums.length == 2) {
            return Math.max(a, b);
        }
        int c = Math.max(b, a + nums[2]);
        for (int i = 3; i < nums.length; i++) {
            a = b;
            b = c;
            c = Math.max(b, a + nums[i]);
        }
        return c;
    }

    public static void main(String[] args) {
        Rob solution = new Rob();
        int ans = solution.robI(new int[]{1, 2, 3, 1});
        System.out.println(ans);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
