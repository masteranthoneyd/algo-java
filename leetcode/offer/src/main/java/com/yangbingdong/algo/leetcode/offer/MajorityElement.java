package com.yangbingdong.algo.leetcode.offer;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int cand_num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cand_num) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    cand_num = nums[i];
                    count = 1;
                }
            }
        }
        return cand_num;
    }

}
