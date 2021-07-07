package com.yangbingdong.algo.leetcode.offer;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 */
public class TreeToDoublyList {

    Node head, pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
            cur.left = pre;
        }
        pre = cur;
        dfs(cur.right);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int val) {
            val = val;
        }

        public Node(int val,Node left,Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    };
}
