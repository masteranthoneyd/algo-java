package com.yangbingdong.algo.leetcode.offer;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        invertInner(root);
        return root;
    }

    private void invertInner(TreeNode node) {
        if (node == null) {
            return;
        }
        invertInner(node.left);
        invertInner(node.right);
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
