package com.yangbingdong.algo.leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 */
public class MaxSlidingWindow {

    /**
     * 采用双端队列
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];

        // 未成区间
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[i] > queue.peekLast()) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
        }
        res[0] = queue.peekFirst();
        for (int i = k; i < nums.length; i++) {
            // //i-k是已经在区间外了，如果首位等于nums[i-k]，那么说明此时首位值已经不再区间内了，需要删除
            if (nums[i - k] == queue.peekFirst()) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && nums[i] > queue.peekLast()) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
            res[i - k + 1] = queue.peekFirst();
        }
        return res;
    }


}
