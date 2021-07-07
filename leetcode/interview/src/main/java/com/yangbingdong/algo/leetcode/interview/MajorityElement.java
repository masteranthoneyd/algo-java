package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int cand = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cand) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    cand = nums[i];
                    count = 1;
                }
            }
        }
        int candSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == cand) {
                candSize++;
            }
        }
        return candSize > nums.length / 2 ? cand : -1;
    }

}
