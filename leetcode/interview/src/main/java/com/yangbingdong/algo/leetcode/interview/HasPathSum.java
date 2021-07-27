package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/path-sum/
 */
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, 0, targetSum);
    }

    private boolean dfs(TreeNode node, int sum, int targetSum) {
        if (node.left == null && node.right == null) {
            return sum + node.val == targetSum;
        }
        return (node.left != null && dfs(node.left, sum + node.val, targetSum)) ||
            (node.right != null && dfs(node.right, sum + node.val, targetSum));
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
