package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/binode-lcci/
 */
public class ConvertBiNode {

    TreeNode pre, head;

    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        pre.left = null;
        pre.right = null;
        return head;
    }

    private void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
            pre.left = null;
        }
        pre = cur;
        dfs(cur.right);
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
