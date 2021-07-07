package com.yangbingdong.algo.leetcode.interview;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class InorderTraversal {

    /**
     * 栈模拟递归
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    /**
     * 使用递归
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversalInner(root, res);
        return res;
    }

    private void inorderTraversalInner(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorderTraversalInner(root.left, res);
        res.add(root.val);
        inorderTraversalInner(root.right, res);
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
