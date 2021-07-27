package com.yangbingdong.algo.leetcode.interview;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class IsValidBST {

    private long pre = Long.MIN_VALUE;

    /**
     * 搜索树的特征就是中序遍历是从小到大的, 所以如果中序遍历是从小到大
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }


    /**
     * 使用模拟栈
     */
    public boolean isValidBST1(TreeNode root) {
        long pre = Long.MIN_VALUE;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (root.val <= pre) {
                    return false;
                }
                pre = root.val;
                root = root.right;
            }
        }
        return true;
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
