package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/min-stack-lcci/
 */
public class TripleInOne {

    private final int[][] stack;
    private final int[] size;
    private final int stackSize;

    public TripleInOne(int stackSize) {
        this.stackSize = stackSize;
        this.size = new int[3];
        this.stack = new int[3][stackSize];
    }

    public void push(int stackNum, int value) {
        int curSize = size[stackNum];
        if (curSize == stackSize) {
            return;
        }
        stack[stackNum][size[stackNum]++] = value;
    }

    public int pop(int stackNum) {
        int curSize = size[stackNum];
        if (curSize == 0) {
            return -1;
        }
        int res = stack[stackNum][--size[stackNum]];
        stack[stackNum][size[stackNum]] = 0;
        return res;
    }

    public int peek(int stackNum) {
        int curSize = size[stackNum];
        if (curSize == 0) {
            return -1;
        } else {
            return stack[stackNum][size[stackNum] - 1];
        }
    }

    public boolean isEmpty(int stackNum) {
        return size[stackNum] == 0;
    }

    public static void main(String[] args) {
        TripleInOne tripleInOne = new TripleInOne(18);
        tripleInOne.push(1, 40);
        tripleInOne.push(1, 54);
        System.out.println(tripleInOne.pop(1));
        System.out.println(tripleInOne.peek(1));
    }

}
