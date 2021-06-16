package com.yangbingdong.algo.basic.tree;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public class BinarySearchTree {

    private Node root;

    public Node find(int num) {
        Node n = root;
        while (n != null) {
            if (num == n.data) {
                return n;
            }
            n = num < n.data ? n.left : n.right;
        }
        return null;
    }

    public void insert(int num) {
        if (root == null) {
            root = new Node(num);
        }

        Node n = root;
        while (true) {
            if (num < n.data) {
                if (n.left == null) {
                    n.left = new Node(num);
                    return;
                }
                n = n.left;
            } else {
                if (n.right == null) {
                    n.right = new Node(num);
                    return;
                }
                n = n.right;
            }
        }
    }

    public Node findMin() {
        if (root == null) {
            return null;
        }
        Node n = root;
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }

    public Node findMax() {
        if (root == null) {
            return null;
        }
        Node n = root;
        while (n.right != null) {
            n = n.right;
        }
        return n;
    }

    public void delete(int num) {
        // 1 找到要删除的节点以及其父节点
        Node n = root;
        Node np = null;
        while (n != null && n.data != num) {
            np = n;
            n = num < n.data ? n.left : n.right;
        }
        if (n == null) {
            return;
        }

        // 2 如果该节点有左右节点, 则找到右子树最小的节点, 并将其值赋值给当前要删除的节点, 然后将要删除的节点指向该最小节点(第3步完成)
        if (n.left != null && n.right != null) {
            Node minN = n.right;
            Node minNp = n;
            while (minN.left != null) {
                minNp = minN;
                minN = minN.left;
            }
            n.data = minN.data;
            n = minN;
            np = minNp;
        }


        // 3 走到这里应该就只有两种情况了, 待删除节点只有一个子节点或者没有子节点
        // 3.1 找到该子节点 child
        Node child = null;
        if (n.left != null) {
            child = n.left;
        } else if (n.right != null) {
            child = n.right;
        }

        // 3.2 删除
        if (np == null) {
            root = child;
        } else if (np.left == n) {
            np.left = child;
        } else if (np.right == n) {
            np.right = child;
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
