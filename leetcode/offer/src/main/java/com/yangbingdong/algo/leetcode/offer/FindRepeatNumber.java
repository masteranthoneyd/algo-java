package com.yangbingdong.algo.leetcode.offer;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class FindRepeatNumber {

    /**
     * 方法一: 使用 HashSet, 包含重复的数字返回, 空间时间复杂度 O(n)
     * 方法二: 原地交换法, 题目中说明了数组长度为n, 数字取值范围 0~n-1, 所以元素与下标至少有一个唯一对应关系, 胡萝卜占坑, 空间复杂度 O(1)
     */
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        return -1;
    }

}
