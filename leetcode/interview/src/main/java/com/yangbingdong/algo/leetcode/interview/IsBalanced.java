package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/check-balance-lcci/
 */
public class IsBalanced {

    /**
     * 自底向上, 遍历 左 -> 右 -> 自身, 返回高度, 如果不平衡, 返回 -1
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    /**
     * 自顶向下
     */
    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }
        int ld = depth(root.left);
        int rd = depth(root.right);
        return Math.abs(ld - rd) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
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
