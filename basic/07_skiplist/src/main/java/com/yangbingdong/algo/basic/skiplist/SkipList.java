package com.yangbingdong.algo.basic.skiplist;

import java.util.Random;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public class SkipList {

    private int maxLevel = 16;
    private Random random = new Random();
    private Node head = new Node();
    private int levelCount = 1;

    public Node find(int value) {
        Node n = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (n.nexts[i] != null && n.nexts[i].value < value) {
                n = n.nexts[i];
            }
        }

        if (n.nexts[0] != null && n.nexts[0].value == value) {
            return n.nexts[0];
        }

        return null;
    }

    public void insert(int value) {
        int level = randomLevel();
        Node newNode = new Node();
        newNode.value = value;
        newNode.level = level;

        // 找到每层需要更新的节点
        Node[] update = new Node[level];
        for (int i = 0; i < level; i++) {
            update[i] = head;
        }

        Node n = head;
        for (int i = level - 1; i >= 0; i--) {
            while (n.nexts[i] != null && n.nexts[i].value < value) {
                n = n.nexts[i];
            }
            update[i] = n;
        }

        // 更新
        for (int i = 0; i < level; i++) {
            newNode.nexts[i] = update[i].nexts[i];
            update[i].nexts[i] = newNode;
        }

        if (level > levelCount) {
            levelCount = level;
        }
    }

    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node n = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (n.nexts[i] != null && n.nexts[i].value < value) {
                n = n.nexts[i];
            }
            update[i] = n;
        }

        if (n.nexts[0] != null && n.nexts[0].value == value) {
            for (int i = 0; i < levelCount; i++) {
                if (update[i].nexts[0] != null && update[i].nexts[0].value == value) {
                    update[i].nexts[0] = update[i].nexts[0].nexts[0];
                }
            }
        }

        while (levelCount > 1 && head.nexts[levelCount] == null) {
            levelCount--;
        }
    }

    private int randomLevel() {
        int level = 1;
        while (random.nextBoolean() && level < maxLevel) {
            level++;
        }
        return level;
    }

    public void printAll() {
        Node n = head;
        while (n.nexts[0] != null) {
            System.out.print(n.nexts[0] + " ");
            n = n.nexts[0];
        }
        System.out.println();
    }

    class Node {
        private int value = -1;
        private int level = 0;
        private Node[] nexts = new Node[maxLevel];

        @Override
        public String toString() {
            return "Node{" +
                "value=" + value +
                ", level=" + level +
                '}';
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.insert(1);
        skipList.insert(3);
        skipList.insert(5);
        skipList.insert(7);
        skipList.insert(9);
        skipList.insert(11);
        skipList.printAll();
        Node node = skipList.find(5);
        System.out.println(node);

        skipList.delete(5);
        skipList.printAll();
    }
}
