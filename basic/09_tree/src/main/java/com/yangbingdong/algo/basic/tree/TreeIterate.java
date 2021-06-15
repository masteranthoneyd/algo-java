package com.yangbingdong.algo.basic.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * 树的遍历
 */
public class TreeIterate {

    public static void main(String[] args) {
        TreeIterate treeIterate = new TreeIterate();
        Node node = treeIterate.buildNode();
        treeIterate.preOrder(node);
        System.out.println();
        treeIterate.inOrder(node);
        System.out.println();
        treeIterate.postOrder(node);
        System.out.println();
        List<Node> nodes = new ArrayList<>();
        nodes.add(node);
        treeIterate.byFloor(nodes);
    }

    public void byFloor(List<Node> nodes) {
        if (nodes == null || nodes.isEmpty()) {
            return;
        }
        List<Node> nexts = new ArrayList<>(nodes.size() * 2);
        for (Node node : nodes) {
            System.out.print(node.data + " ");
            if (node.left != null) {
                nexts.add(node.left);
            }
            if (node.right != null) {
                nexts.add(node.right);
            }
        }
        byFloor(nexts);
    }

    public void preOrder(Node n) {
        if (n == null) {
            return;
        }
        System.out.print(n.data + " ");
        preOrder(n.left);
        preOrder(n.right);
    }

    public void inOrder(Node n) {
        if (n == null) {
            return;
        }
        inOrder(n.left);
        System.out.print(n.data + " ");
        inOrder(n.right);
    }

    public void postOrder(Node n) {
        if (n == null) {
            return;
        }
        postOrder(n.left);
        postOrder(n.right);
        System.out.print(n.data + " ");
    }

    public Node buildNode() {
        Node D = new Node("D", null, null);
        Node E = new Node("E", null, null);
        Node B = new Node("B", D, E);

        Node F = new Node("F", null, null);
        Node G = new Node("G", null, null);
        Node C = new Node("C", F, G);

        return new Node("A", B, C);
    }

    static class Node {
        String data;
        Node left;
        Node right;

        public Node(String data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
